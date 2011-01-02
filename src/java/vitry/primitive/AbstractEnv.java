package vitry.primitive;

/**
 * Implement:
 *   - Provide store/fetch
 *   - (opt) Provide empty and (Env parent) constructors
 */
abstract public class AbstractEnv<K, V> implements Env<K, V>
    {

        public Env<K, V> define(K key, V val) throws BindingException {
            if (fetch(key) != null) throw new BindingException(key, this);
            store(key, val);
            return this;
        }

        public V lookup(K key) throws UndefinedException {
            V val = fetch(key);

            if (val == null) {
                Env<K, V> env = this;
                try {
                    // Loop to save stack
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
        public static <K, V> Env<K, V> getEmptyEnv() {
            // Casting this object is always safe, 
            // as the empty environment never return values
            if (empty == null) empty = new EmptyEnv();
            return (Env<K, V>) empty;
        }


        public static boolean isEmptyEnv(Env<?,?> env) {
            return env == empty;
        }


        private static Env<?, ?>  empty;

        private static final long serialVersionUID = 8402893922379900923L;
    }


class EmptyEnv extends AbstractEnv<Object, Object>
    {
        EmptyEnv() {
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
