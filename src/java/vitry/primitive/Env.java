package vitry.primitive;

/**
 * Invariants:
 *  TODO
 */
public interface Env<K, V>
    {
        public abstract Env<K, V> define(K k, V v);

        public abstract V lookup(Object k);

        public abstract int size();

        public abstract int localSize();

        public abstract boolean isEmpty();
    }