package vitry.primitive;

abstract public class AbstractEnv<K, V> implements Env<K, V>
    {

        public Env<K, V> define(K key, V val) throws BindingException {
            if (at(key) != null) throw new BindingException(key, this);
            put(key, val);
            return this;
        }

        public V lookup(K key) throws UndefinedException {
            V val = at(key);

            if (val == null) {
                Env<K, V> env = this;
                try {
                    do {
                        env = env.parent();
                        val = env.at(key);
                    } while (val == null);
                } catch (LookupFailedException e) {
                    throw new UndefinedException(key, this);
                }
            }
            return val;
        }

        abstract protected void put(K key, V val);

        abstract public V at(Object key);

        private static final long serialVersionUID = 8402893922379900923L;
    }

/**
 * Thrown by empty to signal failed lookup.
 */
class LookupFailedException extends RuntimeException
    {

        private static final long serialVersionUID = -6163913997642410031L;
    }
