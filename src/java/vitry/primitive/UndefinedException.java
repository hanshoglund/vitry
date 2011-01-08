package vitry.primitive;

public class UndefinedException extends RuntimeException
    {
        private Object key;

        private Environment<?,?> env;

        public UndefinedException(Object key, Environment<?, ?> env) {
            super("Could not find key " + key + " in " + env);
            this.key = key;
            this.env = env;
        }

        public Object getKey() {
            return key;
        }

        public Environment<?,?> getEnv() {
            return env;
        }

        public static long getSerialversionuid() {
            return serialVersionUID;
        }


        private static final long serialVersionUID = -8154071457798846190L;
    }
