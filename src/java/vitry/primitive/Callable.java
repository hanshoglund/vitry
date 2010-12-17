package vitry.primitive;

abstract public class Callable extends Atom
    {

        public Callable() {
            this.env = new HashEnv<Symbol, Object>();
        }

        public Callable(Callable encl) {
            this(encl.env);
        }

        public Callable(Env<Symbol, Object> env) {
            this.env = env;
        }

        Env<Symbol, Object> env;
    }
