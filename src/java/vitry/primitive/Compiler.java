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

    static class IR {
    }

    static class IR_Callable extends IR {
    }

    static class IR_PushLocal extends IR {
    }

    static class IR_PopLocal extends IR {
    }

    static class IR_PushShared extends IR {
    }

    static class IR_PopShared extends IR {
    }

    static class IR_Thunk extends IR_Callable {
    }

    static class IR_Fn extends IR_Callable {
    }

    static class IR_NormalFn extends IR_Callable {
    }

    static class IR_Invoke extends IR {
    }

    static class IR_Label extends IR {
    }

    static class IR_Goto extends IR {
    }

    static class IR_If extends IR {
    }

    static class IR_Match extends IR {
    }

}
