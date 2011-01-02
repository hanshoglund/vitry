package vitry.primitive;

import java.util.HashMap;


public class HashEnv<K, V> extends AbstractEnv<K, V>
    {
        public HashEnv() {
            this.parent = AbstractEnv.<K,V>getEmptyEnv();
        }

        public HashEnv(Env<K, V> parent) {
            this.parent = parent;
        }

        public Env<K, V> parent() {
            return parent;
        }

        protected void store(K key, V val) {
            bindings.put(key, val);
        }

        public V fetch(K key) {
            return bindings.get(key);
        }

        private Env<K, V>         parent;

        private HashMap<K, V>     bindings         = new HashMap<K, V>();

        private static final long serialVersionUID = -6896184961023443064L;
    }
