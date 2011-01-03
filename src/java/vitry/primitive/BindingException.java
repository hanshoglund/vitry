package vitry.primitive;

public class BindingException extends RuntimeException
    {
        public BindingException(Object key, Environment<?, ?> env) {
            super("Key " + key + " already defined in " + env);
        }

        private static final long serialVersionUID = 472453313488024837L;
    }
