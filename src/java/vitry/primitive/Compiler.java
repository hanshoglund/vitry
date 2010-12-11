package vitry.primitive;

import java.util.LinkedList;
import java.util.List;

import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;

import vitry.primitive.expr.Apply;
import vitry.primitive.expr.Fn;
import vitry.primitive.expr.If;
import vitry.primitive.expr.Let;
import vitry.primitive.expr.Match;
import vitry.primitive.expr.Module;
import vitry.primitive.expr.TypeExpr;

/**
 * General workflow:
 * 
 *  1) Runtime calls eval or compile method
 *  2) A ClassReceiver object is manufactured (if it has not been passed).
 *  3) A ClassGen object is manufactured.
 *  4) Its genClasses() method is invoked.
 *  5) Any number of compiled units (classes) is passed to the receiver.
 *     The generated classes must all be visible from each other's class loaders
 *     as must the vitry.primitive package.
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
    
    public Compiler(){}

    public Compiler(boolean localTailCallOpt, boolean generalTailCallOpt,
            String[] specialForms)
    {
        this.localTailCallOpt = localTailCallOpt;
        this.generalTailCallOpt = generalTailCallOpt;
        this.specialForms = specialForms;
    }                   
    
    /** Perform general TCO (using trampolines) */
    protected boolean localTailCallOpt   = false;

    /** Perform local TCO (using Baker's trick) */
    protected boolean generalTailCallOpt = false;

    protected String[] specialForms = { "where", "do", "loop", "recur" };
    

    
    
    @Override
    public Value eval(Expr e) throws Exception {
        ClassLoader dynClassLoader = null; // TODO
        return eval(e, dynClassLoader);
    }

    @Override
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
    
    
    
    public ClassGen compile(Module e) {
        // transform imports to assignments
        // transform top-level type declarations to assignments
        // transform top-level value declarations to assignments
        // transform top-level fn declarations to assignments
        // transform top-level implicits to assignments
        
        return null; // TODO
    }

    public ClassGen compile(Fn e) {
        // create FunctionGen
        // pass parameter info
        // lazy, TCO info?
        // compile and pass subexprs
        
        return null; // TODO
    }
    
    public Emitter compile(Let e) {
        return null; // TODO
    }

//    public Emitter compile(Where e) {
//        // transform to where
//        return null; // TODO
//    }

    public Emitter compile(Apply e) {
        return null; // TODO
    }

    public Emitter compile(TypeExpr e) {
        return null; // TODO
    }

//    public Emitter compile(Do e) {
//        // create SeqEmitter
//        // compile and pass subexprs
//        return null; // TODO
//    }

    public BranchingEmitter compile(If e) {
        // create IfEmitter
        // compile and pass subexprs
        return null; // TODO
    }

//    public BranchingEmitter compile(Loop e) {
//        // create LoopEmitter
//        // emit label
//        // compile and pass subexprs
//        return null; // TODO
//    }
//
//    public BranchingEmitter compile(Recur e) {
//        // obtain recursion point (how?)
//        // compile and pass subexprs
//        return null; // TODO
//    }
    
    public BranchingEmitter compile(Match e) {
        // create MatchEmitter
        // compile and pass subexprs
        return null; // TODO
    }
    
    

    public interface Emitter {
        void emit(CallableGen enc, GeneratorAdapter g);
    }

    public interface ClassGen {
        void genClasses(ClassReceiver recv);
    }

    public interface ClassReceiver {
        public void receiveClass(String name, byte[] bytecode);
    }

    abstract public static class CallableGen implements Emitter, ClassGen {

        public CallableGen()
        {
            this.instrs = new LinkedList<Emitter>();
        }

//        public CallableInstruction(Iterable<? extends Instruction> instrns)
//        {
//            this.instrs = new LinkedList<Instruction>(instrs);
//        }
//
//        public CallableInstruction add(Instruction i) {
//            if (compilationStarted)
//                throw new IllegalStateException("Can not modify instruction "
//                        + "after start of compilation. Make a new instruction "
//                        + "instead");
//            instrs.add(i);
//            return this;
//        }
        
        
//        public void addStore(byte index) {
//            add(new StoreInstr(index));
//        }
//
//        public void addFetch(byte index) {
//            add(new FetchInstr(index));
//        }

//        public void addFetchGuarded(byte index) {
//            add(new FetchGuardedInstr(index));
//        }
//
//        public void addFetchChecked(byte index) {
//            add(new FetchCheckedInstr(index));
//        }

//        public void addDefine() {
//            add(new DefineInstr());
//        }
//
//        public void addLookup() {
//            add(new LookUpInstr());
//        }
//
//        public void addInvoke(int arity) {
//            add(new InvokeInstr(arity));
//        }
//
//        public CallableInstruction addThunk() {
//            return null; // TODO
//        }
//
//        public CallableInstruction addFunction() {
//            return null; // TODO
//        }
//        
        public Emitter getTailPosition() {
            return null; // TODO
        }

        // public abstract void prelude();
        // public abstract void postlude();

        @Override
        public void emit(CallableGen enc, GeneratorAdapter g) {
            // push this
            // inv Callable.makeChildEnvironent
            // new
        }

        @Override
        public void genClasses(ClassReceiver recv) {
            // emit prelude
            // emit instructions
            // if one is callable
            // call compile and store result elsewhere
            // call emit on it etc
            // emit postlude
        }

        protected List<Emitter> instrs;
        protected Type enclosingType;
        protected int locals;
        
        /** Force guarded fetch */
        protected boolean guarded = false;
        /** Force checked fetch */
        protected boolean checked = false;

        private boolean compilationStarted = false;
    }

    /**
    *
    */
    abstract public static class TailCallableGen extends
            CallableGen {
        // Decorator
    }

    /**
     *
     */
    abstract public static class TrampolineGen extends CallableGen {
        // Decorator        
    }
    

    /* thunk <nested code>                      
     * ... -> ... thunk    
     *         Effects the generation of a thunk class at compile-time. 
     *         Emits bytecode that creates an instance of that class.
     *         Generated code inherits the enclosing environment.
     */
    public static class ThunkGen extends CallableGen {
    }

    /* function <nested code>                            
     * ... -> ... function    
     *         Effects the generation of a function class at compile-time. 
     *         Emits bytecode that creates an instance of that class.
     *         Generated code inherits the enclosing environment.
     */    
    public static class FunctionGen extends CallableGen {
    }

    /* functionGuarded <nested code>
     * ... -> ... function    
     *         Like function, but forces generated code to use fetchGuarded
     *         in place of fetch.
     */    
    public static class FunctionGuardedGen extends FunctionGen {
    }

    /* functionChecked <nested code>
     * ... -> ... function    
     *         Like function, but forces generated code to use fetchChecked
     *         in place of fetch.
     */
    public static class FunctionCheckedGen extends FunctionGen {
    }
    
    
    // Branching emitters
    // TODO
    
    abstract public static class BranchingEmitter implements Emitter {
    }
    
    public static class IfEmitter extends BranchingEmitter {

        @Override
        public void emit(CallableGen enc, GeneratorAdapter g) {
            // TODO Auto-generated method stub
        }
    }
    public static class MatchEmitter extends BranchingEmitter {

        @Override
        public void emit(CallableGen enc, GeneratorAdapter g) {
            // TODO Auto-generated method stub
        }
    }

    
    // Simple emitters

    /*
     * store index   
     * ... value -> ...    
     *         Pops (stores) a local variable.
     */
    public static class StoreEmitter implements Emitter {
        public StoreEmitter(byte index)
        {
            this.index = index;
        }
        private byte index;

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
        public FetchEmitter(byte index)
        {
            this.index = index;
        }
        protected byte index;

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
        public FetchGuardedEmitter(byte index)
        {
            super(index);
        }        
        static final Type _Thunk = Type.getType(Thunk.class);
        static final Method _get = Method.getMethod("Value get()");

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
    public static class FetchCheckedEmitter extends FetchGuardedEmitter {
        public FetchCheckedEmitter(byte index)
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
        static final Type _Callable = Type.getType(Callable.class);
        static final Method _define = Method.getMethod("define(Symbol, Value)");
        
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
    public static class LookUpEmitter implements Emitter {
        static final Type _Callable = Type.getType(Callable.class);
        static final Method _lookup = Method.getMethod("lookup(Symbol)");

        @Override
        public void emit(CallableGen enc, GeneratorAdapter g) {
            g.loadThis();
            g.swap();       // .. this sym
            g.invokeVirtual(_Callable, _lookup);
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
    
        private int arity;
    
        @Override
        public void emit(CallableGen enc, GeneratorAdapter g) {
            // TODO push fn
            // store arity
        }
    }
    
    public static class InvokeTailEmitter implements Emitter {

        @Override
        public void emit(CallableGen enc, GeneratorAdapter g) {
            // TODO Auto-generated method stub
        }
        
    }


    // TODO monitors
}
