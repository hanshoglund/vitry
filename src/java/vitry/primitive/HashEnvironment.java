package vitry.primitive;

import java.util.HashMap;

public class HashEnvironment<K, V> extends AbstractEnvironment<K, V>
    {
        public HashEnvironment() {
            this.parent = AbstractEnvironment.<K,V>getEmptyEnv();
        }

        public HashEnvironment(Environment<K, V> parent) {
            this.parent = parent;
        }

        public Environment<K, V> parent() {
            return parent;
        }

        protected void store(K key, V val) {
            bindings.put(key, val);
        }

        public V fetch(K key) {
            return bindings.get(key);
        }

        private Environment<K, V>         parent;

        private HashMap<K, V>     bindings         = new HashMap<K, V>();

        private static final long serialVersionUID = -6896184961023443064L;
    }
