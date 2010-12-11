package vitry.primitive;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;

/**
 * 
 * @author hans
 */
public class Compiler implements Evaluator {

    // Receive Expr
    // Perform analysis/optimization
    // Create IR (one CallableExpression)
    // Call compile
    
    @Override
    public Value eval(Expr e) {
        return null;
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
        abstract public void emit(GeneratorAdapter g);
    }

    /**
     * Emits JVM instructions that load a generated unit (i.e. a the bytecode 
     * of a class).
     * 
     * Implementations override the compile method.
     */
    abstract public static class CallableInstruction extends Instruction {

        public CallableInstruction()
        {
            this.instrns = new LinkedList<Instruction>();
        }

        public CallableInstruction(Collection<? extends Instruction> instrns)
        {
            this();
            this.instrns.addAll(instrns);
        }

        public boolean add(Instruction i) {
            return instrns.add(i);
        }

        @Override
        public void emit(GeneratorAdapter g) {
            // push this
            // inv Callable.makeChildEnvironent
            // new
        }

        abstract public byte[] compile();

        protected List<Instruction> instrns;
    }

    public static Instruction instrStore(byte index) {
        return new IR_Store(index);
    }

    public static Instruction instrFetch(byte index) {
        return new IR_Fetch(index);
    }

    public static Instruction instrFetchGuarded(byte index) {
        return new IR_FetchGuarded(index);
    }

    public static Instruction instrFetchChecked(byte index) {
        return new IR_FetchChecked(index);
    }

    public static Instruction instrDefine() {
        return new IR_Define();
    }

    public static Instruction instrLookup() {
        return new IR_LookUp();
    }

    public static Instruction instrInvoke(int arity) {
        return new IR_Invoke(arity);
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
        public void emit(GeneratorAdapter g) {
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
        public void emit(GeneratorAdapter g) {
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
        public void emit(GeneratorAdapter g) {
            g.loadLocal(index);
            g.invokeVirtual(Type.getType(Thunk.class), Method.getMethod("Value get()"));
        }
    }  
    
      
    /* fetchChecked index
     * ... -> ... value
     *         Like fetch, but inserts optional thunk expansion.
     */
    static class IR_FetchChecked extends IR_Fetch {
        public IR_FetchChecked(byte index)
        {
            super(index);
        }

        @Override
        public void emit(GeneratorAdapter g) {
            g.loadLocal(index);
            g.dup();
            g.instanceOf(Type.getType(Thunk.class));
            // TODO branch
            g.invokeVirtual(Type.getType(Thunk.class), Method.getMethod("Value get()"));
        }
    }
    
      
    /* define 
     * ... symbol value -> ...    
     *         Pushes (fetches) a variable from the current lexical environment.
     */
    static class IR_Define extends Instruction {
        
        @Override
        public void emit(GeneratorAdapter g) {
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
        public void emit(GeneratorAdapter g) {
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
        public void emit(GeneratorAdapter g) {
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
