package vitry.primitive;

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

    public static class IR_Instruction {
    }

    abstract public static class IR_Callable extends IR_Instruction {
    }

    public static class IR_PushLocal extends IR_Instruction {
    }

    public static class IR_PopLocal extends IR_Instruction {
    }

    public static class IR_PushEnvironment extends IR_Instruction {
    }

    public static class IR_PopEnvironment extends IR_Instruction {
    }

    public static class IR_Thunk extends IR_Callable {
    }

    public static class IR_Fn extends IR_Callable {
    }

    public static class IR_NormalFn extends IR_Callable {
    }

    public static class IR_Invoke extends IR_Instruction {
    }

    public static class IR_Label extends IR_Instruction {
    }

    public static class IR_If extends IR_Instruction {
    }

    public static class IR_Match extends IR_Instruction {
    }

}
