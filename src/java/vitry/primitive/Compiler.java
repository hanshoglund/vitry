package vitry.primitive;

import java.util.LinkedList;
import java.util.List;

import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;

import vitry.primitive.expr.Apply;
import vitry.primitive.expr.Do;
import vitry.primitive.expr.Fn;
import vitry.primitive.expr.If;
import vitry.primitive.expr.Let;
import vitry.primitive.expr.Loop;
import vitry.primitive.expr.Match;
import vitry.primitive.expr.Module;
import vitry.primitive.expr.Recur;
import vitry.primitive.expr.TypeExpr;
import vitry.primitive.expr.Where;

/**
 * General workflow:
 *  1) External resources (i.e. the runtime) calls eval or compile methods
 *     passing language expressions
 *     
 *  2) A class receiver object is manufactured (or it has been passed).
 *  
 *  3) A callable instruction object is manufactured.
 *  
 *  4) Its compile() method is invoked, forcing compilation.
 *  
 *  5) Any number of compiled units (classes) is passed to the receiver.
 *     The generated classes must all be visible from each other's class loaders
 *     as must the vitry.primitive package.
 *     
 *  6) If an eval method was invoked, a dynamic classloader is created and
 *     the top-level callable object evaluated.
 *     
 *     
 * How-to:
 * 
 *  Add primitive support?
 *      Expr level
 *          Assert safe type hints are available in certain kinds of exprs
 *      Backend level    
 *          Assert other instructions can handle primitives safely
 *          Replace invoke instructions with something in the line of "primitiveInvoke"
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
public class Compiler {
    
    /**
     * Stateless, apart from "miscellaneous" configurations, i.e. flags.
     */
    public Compiler(){}
    

    public interface ClassReceiver {
        public void receiveClass(String name, byte[] bytecode);
    }

    // Intermediate representation
    
    public void compile(Module e) {
    }
    public void compile(Fn e) {
    }
    public void compile(Apply e) {
    }
    public void compile(Do e) {
    }
    public void compile(If e) {
    }
    public void compile(Let e) {
    }
    public void compile(Loop e) {
    }
    public void compile(Match e) {
    }
    public void compile(Recur e) {
    }
    public void compile(TypeExpr e) {
    }
    public void compile(Where e) {
    }


    /**
     * Represents instructions format, i.e. stateless entities that work on
     * stack elements.
     * 
     * Subclasses typically take constructor parameters for information known
     * at compile time, such as arity, identifiers etc.
     */
    public static interface Instruction {
        abstract public void emit(GeneratorAdapter g);
    }

    /**
     * Represents instructions that generates callable entities. These
     * encapsulate a list of instructions as well as information on
     * accessible local variables, labels etc.
     * 
     * Each instance implicitly generate a single JVM class, as well as
     * instructions to load the generated class (of which is a subclass of 
     * vitry.primitive.Callable).
     */
    abstract public static class CallableInstruction implements Instruction {

        public CallableInstruction()
        {
            this.instrs = new LinkedList<Instruction>();
        }

        public CallableInstruction(Iterable<? extends Instruction> instrns)
        {
            this.instrs = new LinkedList<Instruction>(instrs);
        }

        public CallableInstruction add(Instruction i) {
            if (compilationStarted)
                throw new IllegalStateException("Can not modify instruction"
                        + "after start of compilation. Make a new instruction"
                        + "instead");
            instrs.add(i);
            return this;
        }
        
        
        public void addStore(byte index) {
            add(new StoreInstr(index));
        }

        public void addFetch(byte index) {
            add(new FetchInstr(index));
        }

        public void addFetchGuarded(byte index) {
            add(new FetchGuardedInstr(index));
        }

        public void addFetchChecked(byte index) {
            add(new FetchCheckedInstr(index));
        }

        public void addDefine() {
            add(new DefineInstr());
        }

        public void addLookup() {
            add(new LookUpInstr());
        }

        public void addInvoke(int arity) {
            add(new InvokeInstr(arity));
        }

        public CallableInstruction addThunk() {
            return null; // TODO
        }

        public CallableInstruction addFunction() {
            return null; // TODO
        }

        // public abstract void prelude();
        // public abstract void postlude();

        @Override
        public void emit(GeneratorAdapter g) {
            // push this
            // inv Callable.makeChildEnvironent
            // new
        }

        public byte[] compile(ClassReceiver recv) {
            // emit prelude
            // emit instructions
            // if one is callable
            // call compile and store result elsewhere
            // call emit on it etc
            // emit postlude
            return null; // TODO
        }

        protected List<Instruction> instrs;
        protected String name;
        protected boolean guarded = false;
        protected boolean checked = false;

        private boolean compilationStarted = false;
        protected int locals;
    }

    /*
     * store index   
     * ... value -> ...    
     *         Pops (stores) a local variable.
     */
    public static class StoreInstr implements Instruction {
        public StoreInstr(byte index)
        {
            this.index = index;
        }

        private byte index;

        @Override
        public void emit(GeneratorAdapter g) {
            g.storeLocal(index);            
        }
    }

              
    /* fetch index
     * ... -> ... value
     *         Pushes (fetches) a local variable.
     */    
    public static class FetchInstr implements Instruction {
        public FetchInstr(byte index)
        {
            this.index = index;
        }

        protected byte index;

        @Override
        public void emit(GeneratorAdapter g) {
            g.loadLocal(index);
        }
    }

                                                 
    /* fetchGuarded index
     * ... -> ... value
     *         Like fetch, but inserts forcing thunk expansion.
     */
    public static class FetchGuardedInstr extends FetchInstr {
        public FetchGuardedInstr(byte index)
        {
            super(index);
        }

        @Override
        public void emit(GeneratorAdapter g) {
            g.loadLocal(index);             // -> .. thunk
            g.invokeVirtual(_Thunk, _get);  // -> .. value
        }

        static final Type _Thunk = Type.getType(Thunk.class);
        static final Method _get = Method.getMethod("Value get()");
    }
    
      
    /* fetchChecked index
     * ... -> ... value
     *         Like fetch, but inserts careful thunk expansion.
     */
    public static class FetchCheckedInstr extends FetchGuardedInstr {
        public FetchCheckedInstr(byte index)
        {
            super(index);
        }

        @Override
        public void emit(GeneratorAdapter g) {
            Label jump = new Label();
            
            g.loadLocal(index);                  // -> .. thunk?
            g.dup();                             // -> .. thunk? thunk?
            g.instanceOf(_Thunk);                // -> .. thunk? res            
            g.ifZCmp(GeneratorAdapter.EQ, jump); // if 0 jump
            g.invokeVirtual(_Thunk, _get);       // -> .. res
            g.mark(jump);
                                                 // -> .. notthunk
        }
    }
    
      
    /* define 
     * ... symbol value -> ...    
     *         Pushes (fetches) a variable from the current lexical environment.
     */
    public static class DefineInstr implements Instruction {
        
        @Override
        public void emit(GeneratorAdapter g) {
                            //    .. sym val
            g.loadThis();   // -> .. sym val this
            g.dupX2();      // -> .. this sym val this 
            g.pop();        // -> .. this sym val
            g.invokeVirtual(_Callable, _define);            
        }
        
        static final Type _Callable = Type.getType(Callable.class);
        static final Method _define = Method.getMethod("define(Symbol, Value)");
    }
    
              
    /* lookup
     * ... symbol -> ... value    
     *         Pops (stores) a variable to the current lexical environment.
     */
    public static class LookUpInstr implements Instruction {

        @Override
        public void emit(GeneratorAdapter g) {
            g.loadThis();
            g.swap();       // .. this sym
            g.invokeVirtual(_Callable, _lookup);
        }
        
        static final Type _Callable = Type.getType(Callable.class);
        static final Method _lookup = Method.getMethod("lookup(Symbol)");
    }
    
                                                                         
    /* invoke arity 
     * ... f a1 [... aN] -> ... value
     *         Invokes a function.
     *         If given too few arguments, return a partially applied function.
     *         If given too many arguments, return the application (((f aN) aN+1) ... aN+i).
     */
    public static class InvokeInstr implements Instruction {
        public InvokeInstr(int arity)
        {
            this.arity = arity;
        }
    
        private int arity;
    
        @Override
        public void emit(GeneratorAdapter g) {
            // TODO push fn
            // store arity
        }
    }
//
//    /* label symbol
//     *         Used for branch statements.
//     */
//    static class IR_Label implements Instruction {
//        public IR_Label(Symbol label)
//        {
//            this.label = label;
//        }
//    
//        private Symbol label;
//    
//        @Override
//        public void emit(GeneratorAdapter g) {
//            // TODO Auto-generated method stub
//        }
//    }
//
//    /* if label
//     * ... v -> ...
//     *         Branch on the given value (vitry false/true).
//     */
//    static class IR_If implements Instruction {
//        public IR_If(Symbol label)
//        {
//            this.label = label;
//        }
//    
//        private Symbol label;
//    
//        @Override
//        public void emit(GeneratorAdapter g) {
//            // TODO Auto-generated method stub
//        }
//    }
//
//    /* ifPred arity label
//     * ... f a1 [... aN] -> ...
//     *         Branch on the given predicate.
//     */
//    static class IR_IfPred implements Instruction {
//        public IR_IfPred(int arity, Symbol label)
//        {
//            this.arity = arity;
//            this.label = label;
//        }
//    
//        private int arity;
//        private Symbol label;
//    
//        @Override
//        public void emit(GeneratorAdapter g) {
//            // TODO Auto-generated method stub
//        }
//    }

    /* thunk <nested code>                      
     * ... -> ... thunk    
     *         Effects the generation of a thunk class at compile-time. 
     *         Emits bytecode that creates an instance of that class.
     *         Generated code inherits the enclosing environment.
     */
    public static class ThunkInstr extends CallableInstruction {

//        @Override
//        public byte[] compile() {
//            return null;
//            // TODO Auto-generated method stub
//        }
    }
       
      
    /* function <nested code>                            
     * ... -> ... function    
     *         Effects the generation of a function class at compile-time. 
     *         Emits bytecode that creates an instance of that class.
     *         Generated code inherits the enclosing environment.
     */    
    public static class FunctionInstr extends CallableInstruction {
//        @Override
//        public byte[] compile() {
//            return null;
//            // TODO Auto-generated method stub
//        }
    }

              
    /* functionGuarded <nested code>
     * ... -> ... function    
     *         Like function, but forces generated code to use fetchGuarded
     *         in place of fetch.
     */    
    public static class FunctionGuardedInstr extends FunctionInstr {
//        @Override
//        public byte[] compile() {
//            return null;
//            // TODO Auto-generated method stub
//        }
    }

      
    /* functionChecked <nested code>
     * ... -> ... function    
     *         Like function, but forces generated code to use fetchChecked
     *         in place of fetch.
     */
    public static class FunctionCheckedInstr extends FunctionInstr {
//        @Override
//        public byte[] compile() {
//            return null;
//            // TODO Auto-generated method stub
//        }
    }


    // TODO switch/match

    // TODO monitors
}
