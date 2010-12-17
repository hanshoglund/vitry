package vitry.primitive;

import java.util.HashMap;


public class HashEnv<K, V> extends AbstractEnv<K, V>
    {
        public HashEnv() {
            this.parent = EmptyEnv.getInstance();
        }

        public HashEnv(Env<K, V> parent) {
            this.parent = parent;
        }

        public Env<K, V> parent() {
            return parent;
        }

        protected void put(K key, V val) {
            bindings.put(key, val);
        }

        public V at(Object key) {
            return bindings.get(key);
        }

        private Env<K, V>         parent;

        private HashMap<K, V>     bindings         = new HashMap<K, V>();

        private static final long serialVersionUID = -6896184961023443064L;


        public static void main(String[] args) throws BindingException, UndefinedException {
            Env<String, Integer> e = new HashEnv<String, Integer>();
            e.define("Hans", 22);
            
            Env<String, Integer> e2 = new HashEnv<String, Integer>(e);
            e2.define("Hans", 23);

            Env<String, Integer> e3 = new HashEnv<String, Integer>(e);
            e3.define("Hans", 24);
            
            print(e.lookup("Hans"));
            print(e2.lookup("Hans"));
            print(e3.lookup("Hans"));
            print(e.lookup("Hans"));
            print(e2.lookup("Hans"));
            print(e3.lookup("Hans"));
//            e.parent().lookup("fails");
        }
        static void print(Object s) {
            System.out.println(s);
        }
    }
