package vitry.primitive;

import java.util.LinkedList;

import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;

import vitry.primitive.expr.Apply;
import vitry.primitive.expr.Assign;
import vitry.primitive.expr.Fn;
import vitry.primitive.expr.If;
import vitry.primitive.expr.Left;
import vitry.primitive.expr.Let;
import vitry.primitive.expr.Literal;
import vitry.primitive.expr.Loop;
import vitry.primitive.expr.Match;
import vitry.primitive.expr.Module;
import vitry.primitive.expr.Recur;
import vitry.primitive.expr.TypeExpr;
import vitry.primitive.expr.Where;

/**
 * General workflow:
 * 
 *  1) Runtime calls eval or compile method
 *  2) A ClassReceiver object is manufactured if it has not been passed.
 *  3) A ClassGen object is manufactured.
 *  4) Its generateClasses() method is invoked.
 *  5) Any number of compiled units (classes) is passed to the receiver.
 *  6) If an eval method was invoked, a dynamic classloader is created and
 *     the top-level callable object evaluated.
 *     
 * 
 * To do:
 * 
 *   - Tail calls
 *      See General tail-call elimination at
 *      http://www.gnu.org/software/kawa/internals/complications.html
 *   
 *   - Inlining and other rewrites
 *     
 *     
 * 
 * How-to:
 * 
 *  Add primitive support?
 *      Expr level
 *          Assert safe type hints are available in certain kinds of exprs
 *      Backend level    
 *          Assert other instructions can handle primitives safely
 *          Replace invoke instructions with something in the line of 
 *          "primitiveInvoke"
 *  
 *  Add more expressions?
 *      Add new Expr subclasses and corresponding compile(...) methods.
 *  
 *  Add new backend?
 *      Reimplement Instruction and CallableInstruction
 *      If the result is not JVM classes, use something other than ClassReceiver.
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
    

    public Compiler() {
        this.localTailCallOpt = false;
        this.generalTailCallOpt = false;
        this.specialForms = new String[]{ 
        };
    }

    public Compiler(boolean localTailCallOpt, boolean generalTailCallOpt, String[] specialForms) {
        this.localTailCallOpt   = localTailCallOpt;
        this.generalTailCallOpt = generalTailCallOpt;
        this.specialForms       = specialForms;
    }                   
            

    // Evaluator impl
    
    public Value eval(Expr e) throws Exception {
        // TODO
        ClassLoader dynClassLoader = null;
        return eval(e, dynClassLoader);
    }

    public Value eval(Expr e, ClassLoader linkWith) throws Exception {
        // get dynamic classloader
        // link with runtime
        // link with supplied, if not null

        if (e instanceof Module) {
            // compile and evaluate
        } else {
            // add implicit module
            // compile and evaluate
        }

        return null; // TODO
    }
    
        
    
    public void compile(Expr e, CallableGen encl) {
        if (e instanceof Module)
            compile((Module) e);
        if (e instanceof Fn)
            compile((Fn) e, encl);
        if (e instanceof Let)
            compile((Let) e, encl);
        if (e instanceof Apply)
            compile((Apply) e, encl);
        if (e instanceof TypeExpr)
            compile((TypeExpr) e, encl);
        if (e instanceof If)
            compile((If) e, encl);
        if (e instanceof Match)
            compile((Match) e, encl);
        
        throw new RuntimeException("Unrecognized expression type.");
    }

    public ClassGenerator compile(Module e) {
        return null;
    }

    public ClassGenerator compile(Fn expr, CallableGen to) {
        Left[] params = expr.params;
        int arity = params.length;
        Expr body = expr.body;

        CallableGen f = new FunctionGen(arity, to);

        for (int i = 0; i < arity; i++) {
            compile(params[i], f);
        }

        compile(body, f);
        return f;
    }

    public void compile(Let e, CallableGen to) {
        // as function/thunk?
    }

    public void compile(Where e, CallableGen to) {
        // same as let
    }

    public void compile(Assign e, CallableGen to) {
        // make definition in current environment
    }

    public void compile(Left e, CallableGen to) {
        // TODO How to deconstruct?
    }

    // pushes result
    public void compile(Apply e, CallableGen to) {        
        for (int i = 0; i < e.args.length; i++) {
            compile(e.args[i], to);
        }
    }

    // pushes result
    public void compile(TypeExpr e, CallableGen encl) {
    }

    // pushes result
    public void compile(If e, CallableGen encl) {
    }
    
    // pushes result
    public void compile(Match e, CallableGen encl) {
    }

    public void compile(Loop e, CallableGen encl) {
    }

    public void compile(Recur e, CallableGen encl) {
    }

    public void compile(Literal e, CallableGen encl) {
    }
    
    public interface Emitter {
        void emit(CallableGen enc, GeneratorAdapter g);
    }

    public interface ClassGenerator {
        void createClasses(ClassReceiver recv);
    }

    public interface ClassReceiver {
        public void receiveClass(String name, byte[] bytecode);
    }     
    

    abstract public static class CallableGen implements Emitter, ClassGenerator {
        
        public CallableGen(
                ClassGenerator enclosing, 
                int reservedLocals,
                boolean checkArgs, 
                boolean guardArgs)
        {
            this.enclosing = enclosing;
            this.reservedLocals = reservedLocals;
            this.checkArgs = checkArgs;
            this.guardArgs = guardArgs;
            this.emitters = new LinkedList<Emitter>();
        }

        public CallableGen(
                ClassGenerator enclosing, 
                int reservedLocals,
                boolean checkArgs,
                boolean guardArgs,
                LinkedList<Emitter> emitters)
        {
            this.reservedLocals = reservedLocals;
            this.reservedLocals = reservedLocals;
            this.checkArgs = checkArgs;
            this.guardArgs = guardArgs;
            this.emitters = emitters;
        }

//        public CallableGen(Iterable<? extends Emitter> instrns)
//        {
//            this.emitters = new LinkedList<Emitter>(emitters);
//        }

        public CallableGen add(Emitter i) {
//            if (this.generationStarted)
//                throw new IllegalStateException("Can not modify instruction "
//                        + "after start of compilation. Make a new instruction "
//                        + "instead");
            emitters.add(i);
            return this;
        }

        public void addIf() {
            // TODO
        }

        public void addMatch() {
            // TODO
        }

        public int addStore() {
            int address = reserveLocal();
            add(new StoreEmitter(address));
            return address;
        }

        public void addStore(int index) {
            add(new StoreEmitter(index));
        }

        public void addFetch(int index) {
            if (checkArgs)
                add(new FetchCheckedEmitter(index));
            else if (guardArgs)
                add(new FetchGuardedEmitter(index));
            else
                add(new FetchEmitter(index));
        }

        public void addDefine() {
            add(new DefineEmitter());
        }

        public void addLookup() {
            if (checkArgs)
                add(new LookupCheckedEmitter());
            else if (guardArgs)
                add(new LookupGuardedEmitter());
            else
                add(new LookupEmitter());
        }

        public void addInvoke(int arity) {
            add(new InvokeEmitter(arity));
        }

        public CallableGen addThunk() {
            return null; // TODO
        }

        public CallableGen addFunction() {
            return null; // TODO
        }

        public Emitter getTail() {
            return emitters.getLast();
        }

        public boolean hasTailCall() {
            return getTail() instanceof FunctionGen;
        }

        public ClassGenerator getEnclosing() {
            return enclosing;
        }

        @Override
        abstract public void emit(CallableGen enc, GeneratorAdapter g);
        
        @Override
        abstract public void createClasses(ClassReceiver recv);
                
        public int reserveLocal() {
            return reservedLocals++;
        }
        public void dropLocal() {
            reservedLocals--;
        }

        private ClassGenerator enclosing;
        private int reservedLocals;
        private boolean checkArgs;
        private boolean guardArgs;
        private LinkedList<Emitter> emitters;

    }
    
    
    /* thunk <nested code>                      
     * ... -> ... thunk    
     *         Effects the generation of a thunk class at compile-time. 
     *         Emits bytecode that creates an instance of that class.
     *         Generated code inherits the enclosing environment.
     */
    public static class ThunkGen extends CallableGen {


        public ThunkGen(ClassGenerator enclosing)
        {
            super(enclosing, 1, false, false);
        }

        @Override
        public void emit(CallableGen enc, GeneratorAdapter g) {
            // TODO Auto-generated method stub
        }

        @Override
        public void createClasses(ClassReceiver recv) {
            // TODO Auto-generated method stub
        }
    }

    /* function <nested code>                            
     * ... -> ... function    
     *         Effects the generation of a function class at compile-time. 
     *         Emits bytecode that creates an instance of that class.
     *         Generated code inherits the enclosing environment.
     */    
    public static class FunctionGen extends CallableGen {

        public FunctionGen(int arity, ClassGenerator enclosing)
        {
            super(enclosing, 1, false, false);
            this.arity = arity;
        }
        
        private int arity;

        @Override
        public void emit(CallableGen enc, GeneratorAdapter g) {
            // TODO Auto-generated method stub
        }

        @Override
        public void createClasses(ClassReceiver recv) {
            // TODO Auto-generated method stub
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
    
    static final Type   _Thunk = Type.getType(Thunk.class);
    static final Method _get = Method.getMethod("Value get()");
    
    static final Type   _Callable = Type.getType(Callable.class);
    static final Method _define = Method.getMethod("define(Symbol, Value)");
    static final Method _lookup = Method.getMethod("lookup(Symbol)");
                                                           
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
    public static class StoreEmitter implements Emitter {
        public StoreEmitter(int i)
        {
            this.index = i;
        }
        int index;

        @Override
        public void emit(CallableGen enc, GeneratorAdapter g) {
            g.storeLocal(index);            
        }
    }
              
    /* fetch index
     * ... -> ... value
     *         Pushes (fetches) a local variable.
     */    
    public static class FetchEmitter implements Emitter {
        public FetchEmitter(int index)
        {
            this.index = index;
        }
        int index;

        @Override
        public void emit(CallableGen enc, GeneratorAdapter g) {
            g.loadLocal(index);
        }
    }
                                                 
    /* fetchGuarded index
     * ... -> ... value
     *         Like fetch, but inserts forcing thunk expansion.
     */
    public static class FetchGuardedEmitter extends FetchEmitter {
        public FetchGuardedEmitter(int index)
        {
            super(index);
        }        
        @Override
        public void emit(CallableGen enc, GeneratorAdapter g) {
            g.loadLocal(index);             // -> .. thunk
            g.invokeVirtual(_Thunk, _get);  // -> .. value
        }
    }
      
    /* fetchChecked index
     * ... -> ... value
     *         Like fetch, but inserts careful thunk expansion.
     */
    public static class FetchCheckedEmitter extends FetchEmitter {
        public FetchCheckedEmitter(int index)
        {
            super(index);
        }
        @Override
        public void emit(CallableGen enc, GeneratorAdapter g) {
            Label jump = new Label();
            g.loadLocal(index);                  // -> .. thunk?
            g.dup();                             // -> .. thunk? thunk?
            g.instanceOf(_Thunk);                // -> .. thunk? res            
            g.ifZCmp(GeneratorAdapter.EQ, jump); // if 0 jump
            g.invokeVirtual(_Thunk, _get);       // -> .. res
            g.mark(jump);                        // -> .. notthunk
        }
    }
      
    /* define 
     * ... symbol value -> ...    
     *         Pushes (fetches) a variable from the current lexical environment.
     */
    public static class DefineEmitter implements Emitter {
        @Override
        public void emit(CallableGen encl, GeneratorAdapter g) {
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
    public static class LookupEmitter implements Emitter {
        @Override
        public void emit(CallableGen enc, GeneratorAdapter g) {
            g.loadThis();
            g.swap();       // .. this sym
            g.invokeVirtual(_Callable, _lookup);
        }        
    }
    
    /* lookupGuarded index
     * ... symbol -> ... value    
     *         Like lookup, but inserts forcing thunk expansion.
     */
    public static class LookupGuardedEmitter extends LookupEmitter {      
        @Override
        public void emit(CallableGen enc, GeneratorAdapter g) {
            g.loadThis();
            g.swap();
            g.invokeVirtual(_Callable, _lookup);
            g.invokeVirtual(_Thunk, _get);  // -> .. value
        }
    }
      
    /* lookupChecked index
     * ... -> ... value
     *         Like lookup, but inserts careful thunk expansion.
     */
    public static class LookupCheckedEmitter extends LookupGuardedEmitter {
        @Override
        public void emit(CallableGen enc, GeneratorAdapter g) {
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
     * ... f a1 [... aN] -> ... value
     *         Invokes a function.
     *         If given too few arguments, return a partially applied function.
     *         If given too many arguments, return the application (((f aN) aN+1) ... aN+i).
     */
    public static class InvokeEmitter implements Emitter {
        public InvokeEmitter(int arity)
        {
            this.arity = arity;
        }
        int arity;
    
        @Override
        public void emit(CallableGen enc, GeneratorAdapter g) {
            // TODO push fn
            // store arity
        }
    }
    
    public static class InvokeTailEmitter extends InvokeEmitter {
        /**
         * @param arity
         */
        public InvokeTailEmitter(int arity)
        {
            super(arity);
            // TODO Auto-generated constructor stub
        }
    
        @Override
        public void emit(CallableGen enc, GeneratorAdapter g) {
            // TODO Auto-generated method stub
        }
        
    }

    private boolean localTailCallOpt;

    private boolean generalTailCallOpt;

    private String[] specialForms;
}
