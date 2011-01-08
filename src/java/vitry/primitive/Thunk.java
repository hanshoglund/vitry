package vitry.primitive;

abstract public class Thunk extends Callable
    {

        public Thunk(Environment<Symbol, Object> e) {
            super(e);
        }

        public Value get() throws InvocationException {
            throw new InvocationException("Invalid thunk block.");
        }
    }
