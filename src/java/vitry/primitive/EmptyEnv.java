package vitry.primitive;

public class EmptyEnv extends AbstractEnv<Object, Object>
    {
        private EmptyEnv() {}

        @SuppressWarnings("unchecked")
        public static <K, V> Env<K, V> getInstance() {
            // Casting this instance is always safe, 
            // as no methods return values
            return (Env<K, V>) instance;
        }
        

        public Env<Object, Object> define(Object key, Object val) {
            throw new UnsupportedOperationException();
        }

        public Env<Object, Object> parent() {
            throw new UnsupportedOperationException();
        }

        protected void store(Object key, Object val) {
            throw new UnsupportedOperationException();
        }

        public Object lookup(Object key) {
            throw new UnsupportedOperationException();
        }

        public Object at(Object key) {
            throw new LookupFailedException();
        }


        private static Env<?, ?>  instance         = new EmptyEnv();


        private static final long          serialVersionUID = 4460929197701994252L;
    }
