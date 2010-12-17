package vitry.primitive;

/**
 * Used for destructuring etc.
 */
abstract public class InvertibleFunction extends Function implements
        Invertible<InvertibleFunction>
    {

        public InvertibleFunction(Env<Symbol, Object> e) {
            super(e);
        }

        abstract public InvertibleFunction inverse();
    }
