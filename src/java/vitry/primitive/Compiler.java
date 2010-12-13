package vitry.primitive;

import java.util.LinkedList;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

import vitry.primitive.expr.*;

/**
 * Compiles expressions to classes.
 * Implements Evaluator by compiling and loading objects dynamically.
 * 
 * See ClassGenerator and ClassReceiver for general API
 *     
 * 
 * To do:
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
public class Compiler implements Evaluator {

    public Compiler()
    {
        this.localTailCallOpt = false;
        this.generalTailCallOpt = false;
        this.enableForms = false;
        this.specialForms = new String[0];
    }
    

    public Compiler(boolean localTailCallOpt, boolean generalTailCallOpt,
            boolean enableForms, String[] specialForms)
    {
        this.localTailCallOpt = localTailCallOpt;
        this.generalTailCallOpt = generalTailCallOpt;
        this.enableForms = enableForms;
        this.specialForms = specialForms;
    }


    public interface ClassReceiver {
        /**
         * Called whenever a class has been generated.
         */
        public void receiveClass(String name, byte[] bytecode);
    }

    public interface ClassGenerator extends Emitter {
        /**
         * Force generation of compiled classes.
         */
        void createClasses(ClassReceiver recv);
    }

    public Value eval(Expr expr) throws Exception {
        return eval(expr, null);
    }

    public Value eval(Expr expr, ClassLoader link) throws Exception {
        // get dynamic classloader
        // link with runtime
        // link with supplied, if not null

        if (expr instanceof ModuleExpr) {
            // compile and evaluate
        } else {
            // add implicit module
            // compile and evaluate
        }

        return null; // TODO
    }

    public ClassGenerator compile(Fn expr) {
        return compile(expr, null);
    }

    public ClassGenerator compile(ModuleExpr expr) {
        return compile(expr, null);
    }

    void compile(Expr expr, CallableGen ctxt) {
        compile(expr, ctxt, false);
    }

    void compile(Expr expr, CallableGen ctxt, boolean leftSide) {
        if (expr instanceof ModuleExpr)
            compile((ModuleExpr) expr, null);
        if (expr instanceof Fn)
            compile((Fn) expr, ctxt);
        if (expr instanceof Let)
            compile((Let) expr, ctxt);
        if (expr instanceof Where)
            compile((Where) expr, ctxt);
        if (expr instanceof Assign)
            compile((Assign) expr, ctxt);
        if (expr instanceof Left)
            compile((Left) expr, ctxt);
        if (expr instanceof Apply)
            compile((Apply) expr, ctxt, leftSide);
        if (expr instanceof TypeExpr)
            compile((TypeExpr) expr, ctxt, leftSide);
        if (expr instanceof If)
            compile((If) expr, ctxt);
        if (expr instanceof Match)
            compile((Match) expr, ctxt);
        if (expr instanceof Loop)
            compile((Loop) expr, ctxt);
        if (expr instanceof Recur)
            compile((Recur) expr, ctxt);
        if (expr instanceof Literal)
            compile((Literal) expr, ctxt, leftSide);

        throw new RuntimeException("Invalid expression type.");
    }

    ClassGenerator compile(ModuleExpr expr, CallableGen _) {
        ModuleGen module = new ModuleGen(expr.name);

        for (String name : expr.imports)
            module.addImport(name);
        for (Assign assign : expr.assigns)
            compile(assign, module);

        return module;
    }

    ClassGenerator compile(Fn expr, CallableGen ctxt) {
        int arity = expr.params.length;
        CallableGen func;
        if (ctxt == null)
            func = new FunctionGen(VitryRuntime.getAnonymousFnName(), arity, ctxt);
        else
            func = ctxt.addFunction(arity);

        for (int i = 0; i < arity; i++)
            func.addLoad(i + 1);

        // Arguments are now on stack
        // We restart from here during tail calls etc
        func.setRecursionPoint();

        for (int i = 0; i < arity; i++)
            compile(expr.params[i], func);

        compile(expr.body, func);
        return func;
    }

    void compile(Let expr, CallableGen ctxt) {
        ctxt.addPushEnv();
        for (Assign assign : expr.assigns)
            compile(assign, ctxt);
        compile(expr.body, ctxt);
        ctxt.addPopEnv();
    }

    void compile(Where expr, CallableGen ctxt) {
        ctxt.addPushEnv();
        for (Assign assign : expr.assigns)
            compile(assign, ctxt);
        compile(expr.body, ctxt);
        ctxt.addPopEnv();
    }

    void compile(Assign expr, CallableGen ctxt) {
        compile(expr.right, ctxt);
        compile(expr.left, ctxt);
    }

    void compile(Left expr, CallableGen ctxt) {
        compile(expr, ctxt, true);
    }

    void compile(Apply expr, CallableGen ctxt, boolean leftSide) {
        int arity = expr.args.length;

        compile(expr.f, ctxt, leftSide);
        for (Expr arg : expr.args)
            compile(arg, ctxt, leftSide);

        if (leftSide)
            ctxt.addInvokeInverse(arity);
        else
            ctxt.addInvoke(arity);
    }

    void compile(TypeExpr expr, CallableGen ctxt, boolean leftSide) {
        compile(expr.value, ctxt, leftSide);
        compile(expr.type, ctxt, leftSide);
        if (leftSide)
            ctxt.addTypeCheck(); // XXX How to esc from this in match statements?
        else
            ctxt.addTypeTag();
    }

    void compile(If expr, CallableGen ctxt) {
        compile(expr.cond, ctxt);
        // TODO branch
        compile(expr.alt1, ctxt);
        compile(expr.alt2, ctxt);
    }

    void compile(Match expr, CallableGen ctxt) {
    }

    void compile(Loop expr, CallableGen ctxt) {
        ctxt.addPushEnv();
        for (Assign assign : expr.assigns)
            compile(assign.right, ctxt);

        ctxt.setRecursionPoint();
        
        for (Assign assign : expr.assigns)
            compile(assign.left, ctxt);
        
        compile(expr.body, ctxt);
        ctxt.addPopEnv();
    }

    void compile(Recur expr, CallableGen ctxt) {
        for (Expr arg : expr.args)
            compile(arg, ctxt);
        ctxt.addRecur();
    }

    void compile(Literal expr, CallableGen ctxt, boolean leftSide) {
        if (leftSide)
            ;
        else
            ;
    }
    
    // TODO str, float, num
    
    
    /**
     * Marks classes that generate code.
     */
    interface Emitter {}
    
    /**
     * Marks classes that generate JVM bytecode.
     */
    interface ByteCodeEmitter extends Emitter {
        void emit(GeneratorAdapter g);        

        /** The number of stack elements pushed (positive) or consumed (negative). */
        int getStackElementsPushed();
    }

    /**
     * Handles generation of callable entities (classes, modules, thunks).
     * 
     * Generates one class for itself and one for each nested callable entity.
     * Emits code that loads this entity (except for modules).
     */
    abstract static class CallableGen implements ByteCodeEmitter, ClassGenerator {

        public CallableGen(String name, CallableGen parent)
        {
            this.parent = parent;
            this.emitters = new LinkedList<ByteCodeEmitter>();
        }

        public CallableGen(String name, CallableGen parent, LinkedList<ByteCodeEmitter> emitters)
        {
            this.parent = parent;
            this.emitters = emitters;
        }


        public CallableGen add(ByteCodeEmitter i) {
//            if (this.generationStarted)
//                throw new IllegalStateException("Can not modify instruction "
//                        + "after start of compilation. Make a new instruction "
//                        + "instead");
            emitters.add(i);
            return this;
        }

        public int addStore() {
            int address = reserveLocal();
            add(new StoreEmitter(address));
            return address;
        }

        public void addStore(int index) {
            add(new StoreEmitter(index));
        }

        public void addLoad(int index) {
            if (checkForThunks())
                add(new LoadCheckedEmitter(index));
            else if (guardForThunks())
                add(new LoadGuardedEmitter(index));
            else
                add(new LoadEmitter(index));
        }
        
        public void addPushEnv() {
            add(new PushEnvEmitter());
        }

        public void addPopEnv() {
            add(new PopEnvEmitter());
        }

        public void addDefine() {
            add(new DefineEmitter());
        }

        public void addLookup() {
            if (checkForThunks())
                add(new LookupCheckedEmitter());
            else if (guardForThunks())
                add(new LookupGuardedEmitter());
            else
                add(new LookupEmitter());
        }

        public void addInvoke(int arity) {
            // TODO
        }

        public void addInvokeInverse(int arity) {
            // TODO
        }

        public void addTypeTag() {
            // TODO
        }

        public void addTypeCheck() {
            // TODO
        }

        public void addRecur() {
            // TODO
        }

        public CallableGen addThunk() {
            String name = this.name + "$thunk" + (anonymousThunks++);
            return new ThunkGen(name, this);
        }

        public CallableGen addFunction(int arity) {
            String name = this.name + "$fn" + (anonymousFns++);
            return new FunctionGen(name, arity, this);
        }
        
        public String getName() {
            return name;
        }

        public ClassGenerator getEnclosing() {
            return parent;
        }

        public Emitter getTail() {
            return emitters.getLast();
        }

        public boolean hasTailCall() {
            return getTail() instanceof FunctionGen;
        }

        public int reserveLocal() {
            return reservedLocals++;
        }

        public void setRecursionPoint() {
            // TODO Auto-generated method stub
        }

        /**
         * Throws an exception if the current sequence of instructions in
         * the generated method does not leave exactly one object on the
         * stack. 
         */
        public void verifyStackLength() {
            int length = 0;
            for (ByteCodeEmitter emitter : this.emitters)
                length += emitter.getStackElementsPushed();
            if (length != 1) throw new IllegalStateException("Corrupt stack " +
            		"allocation in " + name);
        }

        public int getStackElementsPushed() {
            return 1;
        }
        
        public void emit(GeneratorAdapter g) {
            // TODO copy environment
            g.newInstance(Type.getType(this.name));
        }
        
        public void createClasses(ClassReceiver recv) {            
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
            
            int version = 0;
            int access = Opcodes.ACC_PUBLIC;
            String superName = superClass().getInternalName();
            cw.visit(version, access, this.name, null, superName, null);
            
            Method m = generatedMethod();
            GeneratorAdapter mg = new GeneratorAdapter(Opcodes.ACC_PUBLIC, m , null, null, cw);

            for (ByteCodeEmitter emitter : this.emitters) {
                emitter.emit(mg);            
                if (emitter instanceof ClassGenerator)
                    ((ClassGenerator) emitter).createClasses(recv);
            }
            mg.endMethod();
            cw.visitEnd();
            
            recv.receiveClass(this.name, cw.toByteArray());
        }
        
        /** The number of locals to reserve for arguments etc */
        abstract protected int preReservedLocals();

        /** Inserts thunk checks or guards after lookup and fetch instructions */
        abstract protected boolean checkForThunks();
        abstract protected boolean guardForThunks();

        /** Description of method to override */
        abstract public Type   superClass();
        abstract public Method generatedMethod();

        String name;
        CallableGen parent;
        int reservedLocals = preReservedLocals();
        int anonymousThunks = 0;
        int anonymousFns = 0;
        LinkedList<ByteCodeEmitter> emitters;
    }
    
    
    /* thunk <nested code>                      
     * ... -> ... thunk    
     *         Effects the generation of a thunk class at compile-time. 
     *         Emits bytecode that creates an instance of that class.
     *         Generated code inherits the enclosing environment.
     */
    static class ThunkGen extends CallableGen {

        public ThunkGen(String name, CallableGen parent)
        {
            super(name, parent);
        }

        public int getStackElementsPushed() {
            return 1;
        }

        public int preReservedLocals() {
            return 1; // this
        }

        public boolean checkForThunks() {
            return parent.checkForThunks();
        }

        public boolean guardForThunks() {
            return parent.guardForThunks();
        }
        
        public Type superClass() {
            return _Thunk;
        }

        public Method generatedMethod() {
            return _get;
        }
    }

    /* function <nested code>                            
     * ... -> ... function    
     *         Effects the generation of a function class at compile-time. 
     *         Emits bytecode that creates an instance of that class.
     *         Generated code inherits the enclosing environment.
     */    
    static class FunctionGen extends CallableGen {

        public FunctionGen(String name, int arity, CallableGen parent)
        {
            super(name, parent);
            if (arity < Function.MIN_ARITY || arity > Function.MAX_ARITY)
                throw new IllegalArgumentException(
                        "Function arity must be in bounds " 
                        + Function.MIN_ARITY + "-"
                        + Function.MAX_ARITY);
            
            this.arity = arity;
        }
        
        public int getStackElementsPushed() {
            return 1; // pushing genrated fn, not invocation
        }

        public int preReservedLocals() {
            return 1 + arity; // this + arg ...
        }

        public boolean checkForThunks() {
            return parent.checkForThunks();
        }

        public boolean guardForThunks() {
            return parent.guardForThunks();
        }
        
        public Type superClass() {
            return _Function;
        }

        public Method generatedMethod() {
            return _apply[arity];
        }
        
        private int arity;
    }
    
    static class ModuleGen extends CallableGen {
        /**
         * @param parent
         */
        public ModuleGen(String name)
        {
            super(name, null);
            this.name = name;
        }

        /**
         * @param name2
         */
        public void addImport(String name2) {
            // TODO Auto-generated method stub
        }

        public int getStackElementsPushed() {
            return 0;
        }

        public int preReservedLocals() {
            return 0;
        }

        public boolean checkForThunks() {
            return false;
        }

        public boolean guardForThunks() {
            return false;
        }

        private final String name;

        public Type superClass() {
            return _Module;
        }
        
        public Method generatedMethod() {
            return _get;
        }     
    }
    
    static class FormGen extends FunctionGen {

        public FormGen(String name, int arity, CallableGen encl)
        {
            super(name, arity, encl);
        }
        
        public boolean guardForThunks() {
            return true;
        }
    }


//    // TODO
//    public static class TailableFunctionGen extends
//            CallableGen {
//
//        public TailableFunctionGen(CallableGen source)
//        {
//            this.source = source;
//        }
//        
//        private CallableGen source;
//
//        @Override
//        public boolean checkLocals() {
//            return source.checkLocals();
//        }
//
//        @Override
//        public boolean guardLocals() {
//            return source.guardLocals();
//        }
//
//        @Override
//        public int preLoadedLocals() {
//            return source.preLoadedLocals();
//        }
//
//        @Override
//        public void emit(CallableGen enc, GeneratorAdapter g) {
//            // TODO Auto-generated method stub
//        }
//
//        @Override
//        public void generateClasses(ClassReceiver recv) {
//            // TODO Auto-generated method stub
//        }
//    }
//
//    // TODO
//    public static class TrampolineGen extends CallableGen {
//
//        public TrampolineGen(CallableGen source)
//        {
//            this.source = source;
//        }
//
//        private CallableGen source;
//
//        @Override
//        public boolean checkLocals() {
//            return source.checkLocals();
//        }
//
//        @Override
//        public boolean guardLocals() {
//            return source.guardLocals();
//        }
//
//        @Override
//        public int preLoadedLocals() {
//            return source.preLoadedLocals();
//        }
//
//        @Override
//        public void emit(CallableGen enc, GeneratorAdapter g) {
//            // TODO Auto-generated method stub
//        }
//
//        @Override
//        public void generateClasses(ClassReceiver recv) {
//            // TODO Auto-generated method stub
//        }
//    }       
//                         
    static final Type   _Callable           = Type.getType(Callable.class);
    static final Method _define             = Method.getMethod("define(Symbol, Value)");
    static final Method _lookup             = Method.getMethod("lookup(Symbol)");
    static final Type   _Thunk              = Type.getType(Thunk.class);
    static final Method _get                = Method.getMethod("Value get()");
    static final Type   _Function           = Type.getType(Function.class);
    static final Type   _Module             = Type.getType(Module.class);
    static final Type   _InvocationException = Type.getType(InvocationException.class);
    
    static final Method[] _apply            = new Method[Function.MAX_ARITY];
    static {
        for (int i = Function.MIN_ARITY; i <= Function.MAX_ARITY; ++i) {
            String sign = "Value apply(";
            sign += "Value";
            for (int j = 0; j < (i-1); ++j)
                sign += ",Value";
            sign += ")";
            
            _apply[i] = Method.getMethod(sign);
        }
    }
                                                           
//    public interface BranchingEmitter extends Emitter {}
//
//    public static class IfEmitter implements BranchingEmitter {
//        @Override
//        public void emit(CallableGen enc, GeneratorAdapter g) {
//            // TODO Auto-generated method stub
//        }
//    }
//
//    public static class MatchEmitter implements BranchingEmitter {
//        @Override
//        public void emit(CallableGen enc, GeneratorAdapter g) {
//            // TODO Auto-generated method stub
//        }
//    }

    
    // Simple emitters

    /*
     * store index   
     * ... value -> ...    
     *         Pops (stores) a local variable.
     */
    static class StoreEmitter implements ByteCodeEmitter {
        public StoreEmitter(int i) { this.index = i; }
        int index;
        public int getStackElementsPushed() { return -1; }

        public void emit(GeneratorAdapter g) {
            g.storeLocal(index);            
        }
    }
              
    /* fetch index
     * ... -> ... value
     *         Pushes (fetches) a local variable.
     */    
    static class LoadEmitter implements ByteCodeEmitter {
        public LoadEmitter(int index) { this.index = index; }
        int index;
        public int getStackElementsPushed() { return 1; }

        public void emit(GeneratorAdapter g) {
            g.loadLocal(index);
        }
    }
                                                 
    /* fetchGuarded index
     * ... -> ... value
     *         Like fetch, but inserts forcing thunk expansion.
     */
    static class LoadGuardedEmitter extends LoadEmitter {
        public LoadGuardedEmitter(int index) { super(index); }        
        
        public void emit(GeneratorAdapter g) {
            g.loadLocal(index);             // -> .. thunk
            g.invokeVirtual(_Thunk, _get);  // -> .. value
        }
    }
      
    /* fetchChecked index
     * ... -> ... value
     *         Like fetch, but inserts careful thunk expansion.
     */
    static class LoadCheckedEmitter extends LoadEmitter {
        public LoadCheckedEmitter(int index) { super(index); }

        public void emit(GeneratorAdapter g) {
            Label jump = new Label();
            g.loadLocal(index);                  // -> .. thunk?
            g.dup();                             // -> .. thunk? thunk?
            g.instanceOf(_Thunk);                // -> .. thunk? res            
            g.ifZCmp(GeneratorAdapter.EQ, jump); // if 0 jump
            g.invokeVirtual(_Thunk, _get);       // -> .. res
            g.mark(jump);                        // -> .. notthunk
        }
    }
    
    static class PushEnvEmitter implements ByteCodeEmitter {
        public int getStackElementsPushed() { return 0; }

        public void emit(GeneratorAdapter g) {
            // TODO
        }      
    }
    
    static class PopEnvEmitter implements ByteCodeEmitter {
        public int getStackElementsPushed() { return 0; }

        public void emit(GeneratorAdapter g) {
            // TODO
        }      
    }
      
    /* define 
     * ... symbol value -> ...    
     *         Pushes (fetches) a variable from the current lexical environment.
     */
    static class DefineEmitter implements ByteCodeEmitter {
        public int getStackElementsPushed() { return -2; }

        public void emit(GeneratorAdapter g) {
            g.loadThis();   // -> .. sym val this
            g.dupX2();      // -> .. this sym val this 
            g.pop();        // -> .. this sym val
            g.invokeVirtual(_Callable, _define);            
        }        
    }
              
    /* lookup
     * ... symbol -> ... value    
     *         Pops (stores) a variable to the current lexical environment.
     */
    static class LookupEmitter implements ByteCodeEmitter {
        public int getStackElementsPushed() { return 1 - 1; }

        public void emit(GeneratorAdapter g) {
            g.loadThis();
            g.swap();       // .. this sym
            g.invokeVirtual(_Callable, _lookup);
        }        
    }
    
    /* lookupGuarded index
     * ... symbol -> ... value    
     *         Like lookup, but inserts forcing thunk expansion.
     */
    static class LookupGuardedEmitter extends LookupEmitter {      
        public void emit(GeneratorAdapter g) {
            g.loadThis();
            g.swap();
            g.invokeVirtual(_Callable, _lookup);
            g.invokeVirtual(_Thunk, _get);  // -> .. value
        }
    }
      
    /* lookupChecked index
     * ... symbol -> ... value    
     *         Like lookup, but inserts careful thunk expansion.
     */
    static class LookupCheckedEmitter extends LookupEmitter {
        public void emit(GeneratorAdapter g) {
            Label jump = new Label();
            g.loadThis();
            g.swap();
            g.invokeVirtual(_Callable, _lookup);
            g.dup();                             // -> .. thunk? thunk?
            g.instanceOf(_Thunk);                // -> .. thunk? res            
            g.ifZCmp(GeneratorAdapter.EQ, jump); // if 0 jump
            g.invokeVirtual(_Thunk, _get);       // -> .. res
            g.mark(jump);                        // -> .. notthunk
        }
    }
    

                                                                         
    /* invoke arity 
     * ... fn a1 [... aN] -> ... value
     *  where N is arity
     *         Invokes a function.
     *         If given too few arguments, return a partially applied function.
     *         If given too many arguments, return the application (((f aN) aN+1) ... aN+i).
     */
    static class InvokeEmitter implements ByteCodeEmitter {
        public InvokeEmitter(int arity) { this.arity = arity; }
        int arity;
        public int getStackElementsPushed() { return 1 - (arity + 1); }
    
        @Override
        public void emit(GeneratorAdapter g) {
            // TODO isn't it better if everything was pushed backwards?
            
            // get fn on top
            // check actual arity vs declared arity
                // it correct invoke
                // if too small return partial application
                // if to big
                    // if instanceof RestArgFunction
                        // push array containing extra args
                        // invoke
                    // else
                        // invoke
                        // apply in turn
        }
    }
    
    // For use with the Tailable function gen in general TCO impl
//    public static class InvokeTailEmitter extends InvokeEmitter {
//        public InvokeTailEmitter(int arity) { super(arity); }
//    
//        public void emit(GeneratorAdapter g) {
//            super.emit(g);
//            // TODO apply mini interpreter technique here
//        }
//    }

    private boolean localTailCallOpt;

    private boolean generalTailCallOpt;

    private boolean enableForms;
    
    private String[] specialForms;
}
