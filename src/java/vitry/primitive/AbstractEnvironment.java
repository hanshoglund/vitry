package vitry.primitive;

/**
 * Implement:
 *   - Provide store/fetch
 *   - (opt) Provide empty and (Env parent) constructors
 */
abstract public class AbstractEnvironment<K, V> implements Environment<K, V>
    {

        public Environment<K, V> define(K key, V val) throws BindingException {
            if (fetch(key) != null) throw new BindingException(key, this);
            store(key, val);
            return this;
        }

        public V lookup(K key) throws UndefinedException {
            V val = fetch(key);

            if (val == null) {
                Environment<K, V> env = this;
                try {
                    do {
                        env = env.parent();
                        val = env.fetch(key);
                    } while (val == null);
                } catch (LookupFailedException e) {
                    throw new UndefinedException(key, this);
                }
            }
            return val;
        }

        abstract public V fetch(K key);

        abstract protected void store(K key, V val);


        @SuppressWarnings("unchecked") 
        public static <K, V> Environment<K, V> getEmptyEnv() {
            if (empty == null) empty = new EmptyEnv();            
            
            // Safe, as the we never return values
            return (Environment<K, V>) empty;
        }


        public static boolean isEmptyEnv(Environment<?,?> env) {
            return env == empty;
        }


        private static Environment<?, ?>  empty;

        private static final long serialVersionUID = 8402893922379900923L;
    }


class EmptyEnv extends AbstractEnvironment<Object, Object>
    {
        EmptyEnv() {
        }

        public Environment<Object, Object> define(Object key, Object val) {
            throw new UnsupportedOperationException();
        }

        public Environment<Object, Object> parent() {
            throw new UnsupportedOperationException();
        }

        protected void store(Object key, Object val) {
            throw new UnsupportedOperationException();
        }

        public Object lookup(Object key) {
            throw new UnsupportedOperationException();
        }

        public Object fetch(Object key) {
            throw new LookupFailedException();
        }

        private static final long serialVersionUID = 4460929197701994252L;
    }


/**
 * Thrown by the empty environment to signal failed lookup.
 */
class LookupFailedException extends RuntimeException
    {
        private static final long serialVersionUID = -6163913997642410031L;
    }
