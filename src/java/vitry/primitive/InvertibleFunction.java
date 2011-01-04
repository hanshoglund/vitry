package vitry.primitive;

/**
 * Used for destructuring etc.
 */
abstract public class InvertibleFunction extends Function implements
        Invertible<InvertibleFunction>
    {

        /**
     * @param arity
     * @param type
     */
    public InvertibleFunction(int arity, FunctionType type) {
        super(arity, type);
        // TODO Auto-generated constructor stub
    }

        abstract public InvertibleFunction inverse();
    }
