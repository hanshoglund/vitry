package vitry.primitive;

import java.util.LinkedList;
import java.util.List;

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
 *  1) External resources (i.e. the runtime) calls static eval or compile methods
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
    
    /**
     * Emits a sequence of JVM instructions.
     * 
     * Subclasses typically take constructor parameters for information known
     * at compile time, such as arity, identifiers etc.
     * 
     * Implementations override the emit method.
     */
    public static abstract class Instruction {
        abstract protected void emitJVMBytecode(GeneratorAdapter g);
    }

    /**
         * Emits JVM instructions that load a generated unit (i.e. a the bytecode 
         * of a class).
         */
        abstract public static class CallableInstruction extends Instruction {
    
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
    
            public byte[] compile() {
                // emit prelude
                // emit instructions
                //      if one is callable 
                //      call compile and store result elsewhere
                //      call emit on it etc
                // emit postlude
                return null; // TODO
            }
            
    //        public abstract void prelude();
    //        public abstract void postlude();
    
            @Override
            protected void emitJVMBytecode(GeneratorAdapter g) {
                // push this
                // inv Callable.makeChildEnvironent
                // new
            }
    
            private   boolean compilationStarted = false;
            protected Type type;
            protected List<Instruction> instrs;
            protected int locals;
        }

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
    
    
    public static Instruction createStore(byte index) {
        return new IR_Store(index);
    }

    public static Instruction createFetch(byte index) {
        return new IR_Fetch(index);
    }

    public static Instruction createFetchGuarded(byte index) {
        return new IR_FetchGuarded(index);
    }

    public static Instruction createFetchChecked(byte index) {
        return new IR_FetchChecked(index);
    }

    public static Instruction createDefine() {
        return new IR_Define();
    }

    public static Instruction createLookup() {
        return new IR_LookUp();
    }

    public static Instruction createInvoke(int arity) {
        return new IR_Invoke(arity);
    }

    public static CallableInstruction createThunk() {
        return null; // TODO
    }

    public static CallableInstruction createFunction() {
        return null; // TODO
    }
    

    /*
     * store index   
     * ... value -> ...    
     *         Pops (stores) a local variable.
     */
    static class IR_Store extends Instruction {
        public IR_Store(byte index)
        {
            this.index = index;
        }

        private byte index;

        @Override
        public void emitJVMBytecode(GeneratorAdapter g) {
            g.storeLocal(index);            
        }
    }

              
    /* fetch index
     * ... -> ... value
     *         Pushes (fetches) a local variable.
     */    
    static class IR_Fetch extends Instruction {
        public IR_Fetch(byte index)
        {
            this.index = index;
        }

        protected byte index;

        @Override
        public void emitJVMBytecode(GeneratorAdapter g) {
            g.loadLocal(index);
        }
    }

                                                 
    /* fetchGuarded index
     * ... -> ... value
     *         Like fetch, but inserts required thunk expansion.
     */
    static class IR_FetchGuarded extends IR_Fetch {
        public IR_FetchGuarded(byte index)
        {
            super(index);
        }

        @Override
        public void emitJVMBytecode(GeneratorAdapter g) {
            g.loadLocal(index);
            g.invokeVirtual(thunk, get);
        }

        protected static final Type thunk = Type.getType(Thunk.class);
        protected static final Method get = Method.getMethod("Value get()");
    }
    
      
    /* fetchChecked index
     * ... -> ... value
     *         Like fetch, but inserts optional thunk expansion.
     */
    static class IR_FetchChecked extends IR_FetchGuarded {
        public IR_FetchChecked(byte index)
        {
            super(index);
        }

        @Override
        public void emitJVMBytecode(GeneratorAdapter g) {
            g.loadLocal(index);
            g.dup();
            g.instanceOf(thunk);
            // TODO branch
            g.invokeVirtual(thunk, get);
        }
    }
    
      
    /* define 
     * ... symbol value -> ...    
     *         Pushes (fetches) a variable from the current lexical environment.
     */
    static class IR_Define extends Instruction {
        
        @Override
        public void emitJVMBytecode(GeneratorAdapter g) {
            // symbol value on the stack
            // push this
            // manipulate stack so we have [this symbol value]
            // inv Callable.define
        }
    }
    
              
    /* lookup
     * ... symbol -> ... value    
     *         Pops (stores) a variable to the current lexical environment.
     */
    static class IR_LookUp extends Instruction {

        @Override
        public void emitJVMBytecode(GeneratorAdapter g) {
            // symbol on the stack
            // push this
            // swap so we have [this symbol]
            // inv Callable.lookup
        }
    }
    
                                                                         
    /* invoke arity 
     * ... f a1 [... aN] -> ... value
     *         Invokes a function.
     *         If given too few arguments, return a partially applied function.
     *         If given too many arguments, return the application (((f aN) aN+1) ... aN+i).
     */
    static class IR_Invoke extends Instruction {
        public IR_Invoke(int arity)
        {
            this.arity = arity;
        }
    
        private int arity;
    
        @Override
        public void emitJVMBytecode(GeneratorAdapter g) {
            // TODO push fn
            // store arity
        }
    }
//
//    /* label symbol
//     *         Used for branch statements.
//     */
//    static class IR_Label extends Instruction {
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
//    static class IR_If extends Instruction {
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
//    static class IR_IfPred extends Instruction {
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
    static class IR_Thunk extends CallableInstruction {

        @Override
        public byte[] compile() {
            return null;
            // TODO Auto-generated method stub
        }
    }
       
      
    /* function <nested code>                            
     * ... -> ... function    
     *         Effects the generation of a function class at compile-time. 
     *         Emits bytecode that creates an instance of that class.
     *         Generated code inherits the enclosing environment.
     */    
    static class IR_Function extends CallableInstruction {
        @Override
        public byte[] compile() {
            return null;
            // TODO Auto-generated method stub
        }
    }

              
    /* functionGuarded <nested code>
     * ... -> ... function    
     *         Like function, but forces generated code to use fetchGuarded
     *         in place of fetch.
     */    
    static class IR_FunctionGuarded extends IR_Function {
        @Override
        public byte[] compile() {
            return null;
            // TODO Auto-generated method stub
        }
    }

      
    /* functionChecked <nested code>
     * ... -> ... function    
     *         Like function, but forces generated code to use fetchChecked
     *         in place of fetch.
     */
    static class IR_FunctionChecked extends IR_Function {
        @Override
        public byte[] compile() {
            return null;
            // TODO Auto-generated method stub
        }
    }


    // TODO switch/match

    // TODO monitors
}
