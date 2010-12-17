package vitry.primitive;

/**
 *
 */
public interface Evaluator
    {
        public Value eval(Expr e) throws Exception;

        public Value eval(Expr e, ClassLoader linkWith) throws Exception;
    }
