package vitry.primitive;

public class BindingException extends RuntimeException
    {
        private Object key;

        private Object env;

        public BindingException(Object key, Environment<?, ?> env) {
            super("Key " + key + " already defined in " + env);
            this.key = key;
            this.env = env;
        }

        public Object getKey() {
            return key;
        }


        public Object getEnv() {
            return env;
        }

        private static final long serialVersionUID = 472453313488024837L;
    }
