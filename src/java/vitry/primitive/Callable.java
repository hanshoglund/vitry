package vitry.primitive;

abstract public class Callable extends Atom
    {

        public Callable() {
            this.env = new HashEnvironment<Symbol, Object>();
        }

        public Callable(Callable encl) {
            this(encl.env);
        }

        public Callable(Environment<Symbol, Object> env) {
            this.env = env;
        }

        final Environment<Symbol, Object> env;
    }
