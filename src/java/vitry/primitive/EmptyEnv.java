package vitry.primitive;

/**
 *
 */
public class EmptyEnv extends AbstractEnv<Object, Object>
    {
        private EmptyEnv() {
        }

        public Env<Object, Object> define(Object key, Object val) {
            throw new UnsupportedOperationException();
        }

        public Env<Object, Object> parent() {
            throw new UnsupportedOperationException();
        }

        protected void put(Object key, Object val) {
            throw new UnsupportedOperationException();
        }

        public Object lookup(Object key) {
            throw new UnsupportedOperationException();
        }

        public Object at(Object key) {
            throw new LookupFailedException();
        }

        public static Env getInstance() {
            return instance;
        }

        private static Env        instance         = new EmptyEnv();

        private static final long serialVersionUID = 4460929197701994252L;
    }
