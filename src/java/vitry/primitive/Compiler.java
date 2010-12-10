package vitry.primitive;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;

/**
 * 
 * @author hans
 */
public class Compiler implements Evaluator {

    @Override
    public Value eval(Expr e) {
        return null;
        // TODO Auto-generated method stub
    }
    
    
    
    // Intermediate representation

    /**
     * Expands to a finite set of JVM instructions.
     * 
     * May take parameters to determine exact configuration of emitted code
     * (used for arity, identifiers etc).
     */
    public static abstract class Instruction {
        abstract public void emit(GeneratorAdapter g);
    }

    /**
     * Forces generation of callable units (JVM classes). Typically expands to
     * instructions that load this unit.
     */
    abstract public static class CallableInstruction extends Instruction {
        
        public CallableInstruction() {
            this.instrns = new LinkedList<Instruction>();
        }
        public CallableInstruction(Collection<? extends Instruction> instrns) {
            this();
            this.instrns.addAll(instrns);
        }
        
        protected List<Instruction> instrns;
        
        abstract public byte[] compile();

        public boolean add(Instruction i) {
            return instrns.add(i);
        }

        public boolean addAll(Collection<? extends Instruction> arg0) {
            return instrns.addAll(arg0);
        }

        public boolean addAll(int arg0, Collection<? extends Instruction> arg1) {
            return instrns.addAll(arg0, arg1);
        }

        public ListIterator<? super Instruction> listIterator() {
            return instrns.listIterator();
        }

        public int size() {
            return instrns.size();
        }
    }
                                   

    /*
     * store index   
     * ... value -> ...    
     *         Pops (stores) a local variable.
     */
    public static class IR_Store extends Instruction {
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
    public static class IR_Fetch extends Instruction {
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
    public static class IR_FetchGuarded extends IR_Fetch {
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
    public static class IR_FetchChecked extends IR_Fetch {
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
    public static class IR_Define extends Instruction {
        
        @Override
        public void emit(GeneratorAdapter g) {
            // TODO Auto-generated method stub
        }
    }
    
              
    /* lookup
     * ... symbol -> ... value    
     *         Pops (stores) a variable to the current lexical environment.
     */
    public static class IR_LookUp extends Instruction {

        @Override
        public void emit(GeneratorAdapter g) {
            // TODO Auto-generated method stub
        }
    }
    
                                                                         
    /* thunk <nested code>                      
     * ... -> ... thunk    
     *         Effects the generation of a thunk class at compile-time. 
     *         Emits bytecode that creates an instance of that class.
     *         Generated code inherits the enclosing environment.
     */
    public static class IR_Thunk extends CallableInstruction {

        @Override
        public void emit(GeneratorAdapter g) {
            // TODO Auto-generated method stub
        }

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
    public static class IR_Function extends CallableInstruction {

        @Override
        public void emit(GeneratorAdapter g) {
            // TODO Auto-generated method stub
        }

        @Override
        public byte[] compile() {
            return null;
            // TODO Auto-generated method stub
        }
    }

              
    /* functionGuarded <nested code>
     * ... -> ... function    
     *         Like function, but forces generated code to use fetchGuarded in place of fetch.
     */    
    public static class IR_FunctionGuarded extends IR_Function {

        @Override
        public void emit(GeneratorAdapter g) {
            // TODO Auto-generated method stub
        }

        @Override
        public byte[] compile() {
            return null;
            // TODO Auto-generated method stub
        }
    }

      
    /* functionChecked <nested code>
     * ... -> ... function    
     *         Like function, but forces generated code to use fetchChecked in place of fetch.
     */
    public static class IR_FunctionChecked extends IR_Function {

        @Override
        public void emit(GeneratorAdapter g) {
            // TODO Auto-generated method stub
        }

        @Override
        public byte[] compile() {
            return null;
            // TODO Auto-generated method stub
        }
    }
    
              
    /* invoke arity 
     * ... f a1 [... aN] -> ... value
     *         Invokes a function.
     *         If given too few arguments, return a partially applied function.
     *         If given too many arguments, return the application (((f aN) aN+1) ... aN+i).
     */
    public static class IR_Invoke extends Instruction {
        public IR_Invoke(int arity)
        {
            this.arity = arity;
        }

        private int arity;

        @Override
        public void emit(GeneratorAdapter g) {
            // TODO Auto-generated method stub
        }
    }
    
              
    /* label symbol
     *         Used for branch statements.
     */
    public static class IR_Label extends Instruction {
        public IR_Label(Symbol label)
        {
            this.label = label;
        }

        private Symbol label;

        @Override
        public void emit(GeneratorAdapter g) {
            // TODO Auto-generated method stub
        }
    }
    
      
    /* if label
     * ... v -> ...
     *         Branch on the given value (vitry false/true).
     */
    public static class IR_If extends Instruction {
        public IR_If(Symbol label)
        {
            this.label = label;
        }

        private Symbol label;

        @Override
        public void emit(GeneratorAdapter g) {
            // TODO Auto-generated method stub
        }
    }
    
              
    /* ifPred arity label
     * ... f a1 [... aN] -> ...
     *         Branch on the given predicate.
     */
    public static class IR_IfPred extends Instruction {
        public IR_IfPred(int arity, Symbol label)
        {
            this.arity = arity;
            this.label = label;
        }

        private int arity;
        private Symbol label;

        @Override
        public void emit(GeneratorAdapter g) {
            // TODO Auto-generated method stub
        }
    }


    // TODO switch/match

    // TODO monitors
}
