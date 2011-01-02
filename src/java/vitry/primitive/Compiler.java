package vitry.primitive;

import java.util.LinkedList;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;

import org.objectweb.asm.Opcodes;

import vitry.primitive.expr.*;

/**
 * Compiles expressions to classes.
 * Implements Evaluator by compiling and loading objects dynamically.
 * 
 * See ClassGenerator and ClassReceiver for general API
 *     
 * 
 * TODO
 * 
 *   - Pre-compilation work
 *      - Rewrite inline exprs as apply
 *      - Rewrite overloaded functions in modules as RestArgFunctions with match
 * 
 *      - Static scope resolution
 *          - Non-closure bindings should be taken directly from the stack
 *          - Known functions can be inlined
 *          etc.
 * 
 *   - Tail calls
 *      - Standard Java calling convention does not allow it     
 *      - We use Clojure-style loop/recur as an alternative
 *      - We implement local tail-calls (per module) using trampolines
 *          - After generation of a CallableGen, scan it to find find all
 *            nested CallableGens containing tail-calls
 *              - Must be able to walk branched emitters
 *          - Create a TrampolineGen object containing them and their callees
 *          - Walk root CallableGen and replace emitters with the trampoline
 *          - Problems: 
 *              - Generate suitable dispatcher, must store values from the 
 *                stack to locals to simulate normal invocation
 *      - We implement general tail-calls using Baker's trick
 *         - Walk CallableGen as above
 *          - Replace tail call emitters with a "tail thunk" that contains
 *            a reference to the callee
 *          - Adjust InvokeEmitters so that they guard for such thunks
 *   
 *   
 *      See General tail-call elimination at
 *      http://www.gnu.org/software/kawa/internals/complications.html
 *   
 *     
 * In a distant future:
 * 
 *  Primitive support?
 *      Expr level
 *          Assert safe type hints are available in certain kinds of exprs
 *      Backend level    
 *          Assert other instructions can handle primitives safely
 *          Replace invoke instructions with something in the line of 
 *          "primitiveInvoke"
 *      
 *  Support global non-strict evaluation?
 *      Expr level
 *          Assert parameters to all invoked expressions are wrapped in thunks.
 *          Assert all fetch instruction are safely checked or guarded.
 *      Backend level
 *          Find a way to optimize guards.
 *      
 * 
 * 
 * @author hans
 */
//public class Compiler implements Evaluator
//  {
//
//    public Compiler( ) {
//      this.localTailCallOpt = false;
//      this.generalTailCallOpt = false;
//      this.enableForms = false;
//      this.specialForms = new String[0];
//    }
//
//
//    public Compiler( boolean localTailCallOpt, boolean generalTailCallOpt,
//            boolean enableForms, String[] specialForms ) {
//      this.localTailCallOpt = localTailCallOpt;
//      this.generalTailCallOpt = generalTailCallOpt;
//      this.enableForms = enableForms;
//      this.specialForms = specialForms;
//    }
//
//
//
//    public interface Emitter
//      {
//
//        /**
//         * Emit bytecode.
//         */
//        abstract public void emit( GeneratorAdapter g );
//
//        /**
//         * The number of stack elements pushed (positive) or consumed (negative).
//         */
//        abstract public int getFramesPushed();
//      }
//
//    public interface ClassReceiver
//      {
//
//        /**
//         * Called whenever a class has been generated.
//         */
//        public void receiveClass( String name, byte[] bytecode );
//      }
//
//    public interface ClassGenerator extends Emitter
//      {
//
//        /**
//         * Force generation of compiled classes.
//         */
//        void createClasses( ClassReceiver recv );
//      }
//
//
//
//    public Value eval( Expr expr ) throws Exception {
//      return eval(expr, null);
//    }
//
//    public Value eval( Expr expr, ClassLoader link ) throws Exception {
//      // get dynamic classloader
//      // link with runtime
//      // link with supplied, if not null
//
//      if (expr instanceof ModuleExpr) {
//        // compile and evaluate
//      } else {
//        // add implicit module
//        // compile and evaluate
//      }
//
//      return null; // TODO
//    }
//
//
//
////    public ClassGenerator compile( ModuleExpr expr ) {
////      return compile(expr, null);
////    }
////
////    public ClassGenerator compile( ModuleExpr expr, CallableGenerator _ ) {
////      ModuleGenerator module = new ModuleGenerator(expr.name);
////
////      for (String name : expr.imports)
////        module.addImport(name);
////      for (Assign assign : expr.assigns)
////        compile(assign, module);
////
////      return module;
////    }
////
////    public ClassGenerator compile( Fn expr ) {
////      return compile(expr, null);
////    }
////
////
////    public ClassGenerator compile( Fn expr, CallableGenerator ctxt ) {
////      int arity = expr.params.length;
////      CallableGenerator func;
////      if (ctxt == null) func = new FunctionGenerator(VitryRuntime.getAnonymousFnName(), arity,
////          ctxt);
////      else
////        func = ctxt.addFunction(arity);
////
////      for (int i = 0; i < arity; i++)
////        func.addLoad(i + 1);
////
////      // Arguments are now on stack
////      // We restart from here during tail calls etc
////      func.setRecursionPoint();
////
////      for (int i = 0; i < arity; i++)
////        compile(expr.params[i], func);
////
////      compile(expr.body, func);
////      return func;
////    }
////
////
////
////    public void compile( Let expr, CallableGenerator ctxt ) {
////      ctxt.addPushEnv();
////      for (Assign assign : expr.assigns)
////        compile(assign, ctxt);
////      compile(expr.body, ctxt);
////      ctxt.addPopEnv();
////    }
////
////    public void compile( Where expr, CallableGenerator ctxt ) {
////      ctxt.addPushEnv();
////      for (Assign assign : expr.assigns)
////        compile(assign, ctxt);
////      compile(expr.body, ctxt);
////      ctxt.addPopEnv();
////    }
////
////    public void compile( Assign expr, CallableGenerator ctxt ) {
////      compile(expr.right, ctxt);
////      compile(expr.left, ctxt);
////    }
////
////    public void compile( Left expr, CallableGenerator ctxt ) {
////      compile(expr, ctxt, true);
////    }
////
////
////
////    public void compile( Apply expr, CallableGenerator ctxt, boolean leftSide ) {
////      int arity = expr.args.length;
////
////      compile(expr.f, ctxt, leftSide);
////      for (Expr arg : expr.args)
////        compile(arg, ctxt, leftSide);
////
////      if (leftSide) ctxt.addInvokeInverse(arity);
////      else
////        ctxt.addInvoke(arity);
////    }
////
////    public void compile( TypeExpr expr, CallableGenerator ctxt, boolean leftSide ) {
////      compile(expr.value, ctxt, leftSide);
////      compile(expr.type, ctxt, leftSide);
////      if (leftSide) ctxt.addTypeCheck(); // XXX How to esc from this in match statements?
////      else
////        ctxt.addTypeTag();
////    }
////
////    public void compile( If expr, CallableGenerator ctxt ) {
////      compile(expr.cond, ctxt);
////      // TODO branch
////      compile(expr.alt1, ctxt);
////      compile(expr.alt2, ctxt);
////    }
////
////    public void compile( Match expr, CallableGenerator ctxt ) {
////      // TODO
////    }
////
////    public void compile( Loop expr, CallableGenerator ctxt ) {
////      ctxt.addPushEnv();
////      for (Assign assign : expr.assigns)
////        compile(assign.right, ctxt);
////
////      ctxt.setRecursionPoint();
////
////      for (Assign assign : expr.assigns)
////        compile(assign.left, ctxt);
////
////      compile(expr.body, ctxt);
////      ctxt.addPopEnv();
////    }
////
////    public void compile( Recur expr, CallableGenerator ctxt ) {
////      for (Expr arg : expr.args)
////        compile(arg, ctxt);
////      ctxt.addRecur();
////    }
////
////
////
////    public void compile(
////            NumLiteral expr, CallableGenerator ctxt, boolean leftSide ) {
////      if (leftSide)
////      ;
////      else
////        ;
////    }
////
////    public void compile( FloatLiteral expr, CallableGenerator ctxt,
////            boolean leftSide ) {
////      if (leftSide)
////      ;
////      else
////        ;
////    }
////
////    public void compile( SymLiteral expr, CallableGenerator ctxt,
////            boolean leftSide ) {
////      if (leftSide)
////      ;
////      else {
////        ;
////      }
////    }
////
////    public void compile( StrLiteral expr, CallableGenerator ctxt, boolean leftSide ) {
////      if (leftSide)
////      ;
////      else
////        ;
////    }
////
////
////
////    public void compile( Expr expr, CallableGenerator ctxt ) {
////      compile(expr, ctxt, false);
////    }
////
////
////
////    public void compile( Expr expr, CallableGenerator ctxt, boolean leftSide ) {
////      if (expr instanceof ModuleExpr)     compile((ModuleExpr) expr, null);
////      else if (expr instanceof Fn)        compile((Fn) expr, ctxt);
////
////      else if (expr instanceof Let)       compile((Let) expr, ctxt);
////      else if (expr instanceof Where)     compile((Where) expr, ctxt);
////      else if (expr instanceof Assign)    compile((Assign) expr, ctxt);
////      else if (expr instanceof Left)      compile((Left) expr, ctxt);
////
////      else if (expr instanceof Apply)     compile((Apply) expr, ctxt, leftSide);
////      else if (expr instanceof TypeExpr)  compile((TypeExpr) expr, ctxt, leftSide);
////      else if (expr instanceof If)        compile((If) expr, ctxt);
////      else if (expr instanceof Match)     compile((Match) expr, ctxt);
////      else if (expr instanceof Loop)      compile((Loop) expr, ctxt);
////      else if (expr instanceof Recur)     compile((Recur) expr, ctxt);
////
////      else if (expr instanceof NumLiteral) compile((NumLiteral) expr, ctxt, leftSide);
////      else if (expr instanceof FloatLiteral) compile((FloatLiteral) expr, ctxt, leftSide);
////      else if (expr instanceof SymLiteral) compile((SymLiteral) expr, ctxt, leftSide);
////      else if (expr instanceof StrLiteral) compile((StrLiteral) expr, ctxt, leftSide);
////
////      throw new RuntimeException("Invalid expression type.");
////    }
////
////
//
////    /**
////     * Marks classes that generate JVM bytecode.
////     */
////    public abstract static class AbstractEmitter implements Emitter
////      {
////
////        public String toString() {
////          return getClass().getSimpleName() + " pushing " + getFramesPushed();
////        }
////      }
////
////
////
////    /**
////     * Handles generation of callable entities (classes, modules, thunks).
////     * 
////     * Generates one class for itself and one for each nested callable entity.
////     * Emits code that loads this entity (except for modules).
////     */
////    abstract public static class CallableGenerator extends AbstractEmitter implements
////        ClassGenerator
////      {
////
////        public CallableGenerator( String name, CallableGenerator parent ) {
////          this.name = name;
////          this.parent = parent;
////          this.emitters = new LinkedList<AbstractEmitter>();
////        }
////
////        public CallableGenerator( String name, CallableGenerator parent,
////            LinkedList<AbstractEmitter> emitters ) {
////          this.name = name;
////          this.parent = parent;
////          this.emitters = emitters;
////        }
////
////
////        public CallableGenerator addEmitter( AbstractEmitter i ) {
////          if (this.generating)
////              throw new IllegalStateException("Can not add emitters"
////                        + "during class generation. Make a new "
////                        + "instruction instead");
////          emitters.add(i);
////          return this;
////        }
////
////        public int addStore() {
////          int address = reserveLocal();
////          addEmitter(new StoreEmitter(address));
////          return address;
////        }
////
////        public void addStore( int index ) {
////          addEmitter(new StoreEmitter(index));
////        }
////
////        public void addLoad( int index ) {
////          if (checkForThunks()) addEmitter(new LoadCheckedEmitter(index));
////          else if (guardForThunks()) addEmitter(new LoadGuardedEmitter(index));
////          else
////            addEmitter(new LoadEmitter(index));
////        }
////
////        public void addPushEnv() {
////          addEmitter(new PushEnvEmitter());
////        }
////
////        public void addPopEnv() {
////          addEmitter(new PopEnvEmitter());
////        }
////
////        public void addDefine() {
////          addEmitter(new DefineEmitter());
////        }
////
////        public void addLookup() {
////          if (checkForThunks()) addEmitter(new LookupCheckedEmitter());
////          else if (guardForThunks()) addEmitter(new LookupGuardedEmitter());
////          else
////            addEmitter(new LookupEmitter());
////        }
////
////        public void addInvoke( int arity ) {
////          addEmitter(new InvokeEmitter(arity));
////        }
////
////        public void addInvokeInverse( int arity ) {
////          addEmitter(new InvokeInverseEmitter(arity));
////        }
////
////        public void addTypeTag() {
////          addEmitter(new TypeTagEmitter());
////        }
////
////        public void addTypeCheck() {
////          addEmitter(new TypeCheckEmitter());
////        }
////
////        public void addRecur() {
////          // TODO
////        }
////
////        public void addReturn() {
////          addEmitter(new ReturnEmitter());
////        }
////
////        public ThunkGenerator addThunk() {
////          String name = this.name + "$thunk" + (anonymousThunks++);
////          ThunkGenerator gen = new ThunkGenerator(name, this);
////          addEmitter(gen);
////          return gen;
////        }
////
////        public FunctionGenerator addFunction( int arity ) {
////          String name = this.name + "$fn" + (anonymousFns++);
////          FunctionGenerator gen = new FunctionGenerator(name, arity, this);
////          addEmitter(gen);
////          return gen;
////        }
////
////        public void setRecursionPoint() {
////          // TODO Auto-generated method stub
////        }
////
////        public int reserveLocal() {
////          return reservedLocals++;
////        }
////
////        public String getName() {
////          return name;
////        }
////
////        public ClassGenerator getParent() {
////          return parent;
////        }
////
////        public Emitter getTail() {
////          return null; // TODO
////        }
////
////        public boolean hasTailCall() {
////          //            return getTail() instanceof FunctionGen;
////          return false; // TODO
////        }
////
////        /**
////         * Computes the stack size after all instructions have been executed,
////         * based on information from the emitters.
////         */
////        public int getFinalStackSize() {
////          int size = 0;
////          for (AbstractEmitter emitter : this.emitters)
////            size += emitter.getFramesPushed();
////          return size;
////        }
////
////        public int getFramesPushed() {
////          return 1;
////        }
////
////        public void emit( GeneratorAdapter g ) {
////          // TODO copy environment
////          g.newInstance(Type.getType(this.name));
////        }
////
////        public void createClasses( ClassReceiver recv ) {
////          verifyStack();
////          generating = true;
////
////          ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
////
////          int version = 0;
////          int access = Opcodes.ACC_PUBLIC;
////          String superName = getSuperClass().getInternalName();
////          cw.visit(version, access, this.name, null, superName, null);
////
////          Method m = getMethod();
////          GeneratorAdapter mg = new GeneratorAdapter(Opcodes.ACC_PUBLIC, m, null, null, cw);
////
////          for (AbstractEmitter emitter : this.emitters) {
////            emitter.emit(mg);
////            if (emitter instanceof ClassGenerator)
////                ((ClassGenerator) emitter).createClasses(recv);
////          }
////          mg.endMethod();
////          cw.visitEnd();
////
////          recv.receiveClass(this.name, cw.toByteArray());
////        }
////
////        /**
////         * Performs basic checks on the generated instructions. 
////         */
////        public void verifyStack() {
////          int fs = getFinalStackSize();
////          if (fs != 0)
////              throw new IllegalStateException("Final stack size is " + fs
////                        + ", should be 0.");
////        }
////
////        public void dumpEmitters() {
////          System.out.println(this.toString());
////          for (AbstractEmitter emitter : this.emitters)
////            System.out.println("    " + emitter.toString());
////        }
////
////        public String toString() {
////          return super.toString() + " " + this.getName();
////        }
////
////        abstract protected Type getSuperClass();
////
////        abstract protected Method getMethod();
////
////        /** The number of locals to reserve for arguments etc */
////        abstract protected int getReservedLocals();
////
////        /** Inserts thunk checks or guards after lookup and fetch instructions */
////        abstract protected boolean checkForThunks();
////
////        abstract protected boolean guardForThunks();
////
////        private final String                      name;
////        protected final CallableGenerator         parent;
////        private int                               reservedLocals  = getReservedLocals();
////        private int                               anonymousThunks = 0;
////        private int                               anonymousFns    = 0;
////        private boolean                           generating      = false;
////        private final LinkedList<AbstractEmitter> emitters;
////      }
////
////
////
////    /* thunk <nested code>                      
////     * ... -> ... thunk    
////     *         Effects the generation of a thunk class at compile-time. 
////     *         Emits bytecode that creates an instance of that class.
////     *         Generated code inherits the enclosing environment.
////     */
////    public static class ThunkGenerator extends CallableGenerator
////      {
////        public ThunkGenerator( String name, CallableGenerator parent ) {
////          super(name, parent);
////        }
////
////        public Type getSuperClass() {
////          return _Thunk;
////        }
////
////        public Method getMethod() {
////          return _get;
////        }
////
////        public int getReservedLocals() {
////          return 1; // this
////        }
////
////        public boolean checkForThunks() {
////          return parent.checkForThunks();
////        }
////
////        public boolean guardForThunks() {
////          return parent.guardForThunks();
////        }
////      }
////
////    /* function <nested code>                            
////     * ... -> ... function    
////     *         Effects the generation of a function class at compile-time. 
////     *         Emits bytecode that creates an instance of that class.
////     *         Generated code inherits the enclosing environment.
////     */
////    public static class FunctionGenerator extends CallableGenerator
////      {
////        public FunctionGenerator( String name, int arity, CallableGenerator parent ) {
////          super(name, parent);
////          if (arity < Function.MIN_ARITY || arity > Function.MAX_ARITY)
////              throw new IllegalArgumentException(
////                        "Function arity must be in bounds "
////                            + Function.MIN_ARITY + " <= n <= "
////                            + Function.MAX_ARITY);
////
////          this.arity = arity;
////        }
////
////        public Type getSuperClass() {
////          return _Function;
////        }
////
////        public Method getMethod() {
////          return _apply[arity];
////        }
////
////        public int getReservedLocals() {
////          return 1 + arity; // this + arg ...
////        }
////
////        public boolean checkForThunks() {
////          return parent == null ? false : parent.checkForThunks();
////        }
////
////        public boolean guardForThunks() {
////          return parent == null ? false : parent.guardForThunks();
////        }
////
////        private int arity;
////      }
////
////    public static class ModuleGenerator extends CallableGenerator
////      {
////        public ModuleGenerator( String name ) {
////          super(name, null);
////          this.moduleName = name;
////        }
////
////        public Type getSuperClass() {
////          return _Module;
////        }
////
////        public Method getMethod() {
////          return _get;
////        }
////
////        public int getReservedLocals() {
////          return 0;
////        }
////
////        public boolean checkForThunks() {
////          return false;
////        }
////
////        public boolean guardForThunks() {
////          return false;
////        }
////
////        public void addImport( String name ) {
////          // TODO
////        }
////
////        public void emit( GeneratorAdapter g ) {
////          throw new UnsupportedOperationException("Can not emit modules.");
////        }
////
////        private final String moduleName;
////      }
////
////    public static class FormGenerator extends FunctionGenerator
////      {
////        public FormGenerator( String name, int arity, CallableGenerator encl ) {
////          super(name, arity, encl);
////        }
////
////        public boolean guardForThunks() {
////          return true;
////        }
////      }
////
////
////
////    static final Type     _Callable            = Type.getType(Callable.class);
////    static final Method   _define              = Method
////                                                   .getMethod("Value define(Symbol, Value)");
////    static final Method   _lookup              = Method.getMethod("Value lookup(Symbol)");
////    static final Type     _Thunk               = Type.getType(Thunk.class);
////    static final Method   _get                 = Method.getMethod("Value get()");
////    static final Type     _Function            = Type.getType(Function.class);
////    static final Type     _Module              = Type.getType(Module.class);
////    static final Type     _InvocationException = Type.getType(InvocationException.class);
////
////    static final Method[] _apply               = new Method[Function.MAX_ARITY + 1];
////    static {
////      for (int i = Function.MIN_ARITY; i <= Function.MAX_ARITY; ++i) {
////        String sign = "Value apply(";
////        if (i > 0)
////          ;
////        sign += "Value";
////        for (int j = 0; j < (i - 1); ++j)
////          sign += ",Value";
////        sign += ")";
////
////        _apply[i] = Method.getMethod(sign);
////      }
////    }
////
////    //    public interface BranchingEmitter extends Emitter {}
////    //
////    //    public static class IfEmitter implements BranchingEmitter {
////    //        public void emit(CallableGen enc, GeneratorAdapter g) {
////    //            // TODO Auto-generated method stub
////    //        }
////    //    }
////    //
////    //    public static class MatchEmitter implements BranchingEmitter {
////    //        public void emit(CallableGen enc, GeneratorAdapter g) {
////    //            // TODO Auto-generated method stub
////    //        }
////    //    }
////
////
////    // Simple emitters
////
////    /*
////     * store index   
////     * ... value -> ...    
////     *         Pops (stores) a local variable.
////     */
////    static class StoreEmitter extends AbstractEmitter
////      {
////        public StoreEmitter( int i ) {
////          this.index = i;
////        }
////
////        int index;
////
////        public int getFramesPushed() {
////          return -1;
////        }
////
////        public void emit( GeneratorAdapter g ) {
////          g.storeLocal(index);
////        }
////      }
////
////    /* fetch index
////     * ... -> ... value
////     *         Pushes (fetches) a local variable.
////     */
////    static class LoadEmitter extends AbstractEmitter
////      {
////        public LoadEmitter( int index ) {
////          this.index = index;
////        }
////
////        int index;
////
////        public int getFramesPushed() {
////          return 1;
////        }
////
////        public void emit( GeneratorAdapter g ) {
////          g.loadLocal(index);
////        }
////      }
////
////    /* fetchGuarded index
////     * ... -> ... value
////     *         Like fetch, but inserts forcing thunk expansion.
////     */
////    static class LoadGuardedEmitter extends LoadEmitter
////      {
////        public LoadGuardedEmitter( int index ) {
////          super(index);
////        }
////
////        public void emit( GeneratorAdapter g ) {
////          g.loadLocal(index); // -> .. thunk
////          g.invokeVirtual(_Thunk, _get); // -> .. value
////        }
////      }
////
////    /* fetchChecked index
////     * ... -> ... value
////     *         Like fetch, but inserts careful thunk expansion.
////     */
////    static class LoadCheckedEmitter extends LoadEmitter
////      {
////        public LoadCheckedEmitter( int index ) {
////          super(index);
////        }
////
////        public void emit( GeneratorAdapter g ) {
////          Label jump = new Label();
////          g.loadLocal(index); // -> .. thunk?
////          g.dup(); // -> .. thunk? thunk?
////          g.instanceOf(_Thunk); // -> .. thunk? res            
////          g.ifZCmp(GeneratorAdapter.EQ, jump); // if 0 jump
////          g.invokeVirtual(_Thunk, _get); // -> .. res
////          g.mark(jump); // -> .. notthunk
////        }
////      }
////
////    static class PushEnvEmitter extends AbstractEmitter
////      {
////        public int getFramesPushed() {
////          return 0;
////        }
////
////        public void emit( GeneratorAdapter g ) {
////          // TODO
////        }
////      }
////
////    static class PopEnvEmitter extends AbstractEmitter
////      {
////        public int getFramesPushed() {
////          return 0;
////        }
////
////        public void emit( GeneratorAdapter g ) {
////          // TODO
////        }
////      }
////
////    /* define 
////     * ... symbol value -> ...    
////     *         Pushes (fetches) a variable from the current lexical environment.
////     */
////    static class DefineEmitter extends AbstractEmitter
////      {
////        public int getFramesPushed() {
////          return -2;
////        }
////
////        public void emit( GeneratorAdapter g ) {
////          g.loadThis(); // -> .. sym val this
////          g.dupX2(); // -> .. this sym val this 
////          g.pop(); // -> .. this sym val
////          g.invokeVirtual(_Callable, _define);
////        }
////      }
////
////    /* lookup
////     * ... symbol -> ... value    
////     *         Pops (stores) a variable to the current lexical environment.
////     */
////    static class LookupEmitter extends AbstractEmitter
////      {
////        public int getFramesPushed() {
////          return -1 + 1;
////        }
////
////        public void emit( GeneratorAdapter g ) {
////          g.loadThis();
////          g.swap(); // .. this sym
////          g.invokeVirtual(_Callable, _lookup);
////        }
////      }
////
////    /* lookupGuarded index
////     * ... symbol -> ... value    
////     *         Like lookup, but inserts forcing thunk expansion.
////     */
////    static class LookupGuardedEmitter extends LookupEmitter
////      {
////        public void emit( GeneratorAdapter g ) {
////          g.loadThis();
////          g.swap();
////          g.invokeVirtual(_Callable, _lookup);
////          g.invokeVirtual(_Thunk, _get); // -> .. value
////        }
////      }
////
////    /* lookupChecked index
////     * ... symbol -> ... value    
////     *         Like lookup, but inserts careful thunk expansion.
////     */
////    static class LookupCheckedEmitter extends LookupEmitter
////      {
////        public void emit( GeneratorAdapter g ) {
////          Label jump = new Label();
////          g.loadThis();
////          g.swap();
////          g.invokeVirtual(_Callable, _lookup);
////          g.dup(); // -> .. thunk? thunk?
////          g.instanceOf(_Thunk); // -> .. thunk? res            
////          g.ifZCmp(GeneratorAdapter.EQ, jump); // if 0 jump
////          g.invokeVirtual(_Thunk, _get); // -> .. res
////          g.mark(jump); // -> .. notthunk
////        }
////      }
////
////
////
////    /* invoke arity 
////     * ... fn a1 [... aN] -> ... value
////     *  where N is arity
////     *         Invokes a function.
////     *         If given too few arguments, return a partially applied function.
////     *         If given too many arguments, return the application (((f aN) aN+1) ... aN+i).
////     */
////    static class InvokeEmitter extends AbstractEmitter
////      {
////        public InvokeEmitter( int arity ) {
////          this.arity = arity;
////        }
////
////        int arity;
////
////        public int getFramesPushed() {
////          return - (arity + 1) + 1;
////        }
////
////        public void emit( GeneratorAdapter g ) {
////          // TODO isn't it better if everything was pushed backwards?
////
////          // get fn on top
////          // check actual arity vs declared arity
////          // it correct invoke
////          // if too small return partial application
////          // if to big
////          // if instanceof RestArgFunction
////          // push array containing extra args
////          // invoke
////          // else
////          // invoke
////          // apply in turn
////        }
////      }
////
////    /* invokeInverse arity 
////     * ... fn a1 [... aN] -> ... value
////     *  where N is arity
////     *         Invokes the inverse of a bijective function.
////     *         Used for destructuring etc.
////     */
////    static class InvokeInverseEmitter extends InvokeEmitter
////      {
////        public InvokeInverseEmitter( int arity ) {
////          super(arity);
////        }
////      }
////
////    static class TypeTagEmitter extends AbstractEmitter
////      {
////        public int getFramesPushed() {
////          return -2;
////        }
////
////        public void emit( GeneratorAdapter g ) {
////        }
////      }
////
////    static class TypeCheckEmitter extends AbstractEmitter
////      {
////        public int getFramesPushed() {
////          return -2 + 1;
////        }
////
////        public void emit( GeneratorAdapter g ) {
////        }
////      }
////
////    static class JumpEmitter extends AbstractEmitter
////      {
////        public int getFramesPushed() {
////          return 0;
////        }
////
////        public void emit( GeneratorAdapter g ) {
////        }
////      }
////
////    static class ReturnEmitter extends AbstractEmitter
////      {
////        public int getFramesPushed() {
////          return -1;
////        }
////
////        public void emit( GeneratorAdapter g ) {
////        }
////      }
////
////
////    // For use with the Tailable function gen in general TCO impl
////    //    public static class InvokeTailEmitter extends InvokeEmitter {
////    //        public InvokeTailEmitter(int arity) { super(arity); }
////    //    
////    //        public void emit(GeneratorAdapter g) {
////    //            super.emit(g);
////    //            // TODO apply mini interpreter technique here
////    //        }
////    //    }
////
//    private boolean  localTailCallOpt;
//
//    private boolean  generalTailCallOpt;
//
//    private boolean  enableForms;
//
//    private String[] specialForms;
////
////
////
////    public static void main( String[] args ) {
////      //        FunctionGen f = new FunctionGen("test", 1, null);
////      //        f.addLoad(1);
////      //        f.addLoad(2);
////      //        f.addLoad(3);
////      //        CallableGen f2 = f.addFunction(10); {
////      //            f2.addLoad(2);            
////      //        }
////      //        f.addStore();
////      //        f.addStore();
////      //        f.addStore();
////      //        f.addReturn();
////      //        
////      //        f.verifyStack();
////      //        f2.verifyStack();
////      //        f.dumpEmitters();
////
////    }
//  }
