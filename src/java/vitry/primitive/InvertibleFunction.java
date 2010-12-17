package vitry.primitive;

/**
 * Used for destructuring etc.
 */
abstract public class InvertibleFunction extends Function implements
        Invertible<InvertibleFunction>
    {

        abstract public InvertibleFunction inverse();
    }
