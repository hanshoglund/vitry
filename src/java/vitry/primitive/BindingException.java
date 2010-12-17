package vitry.primitive;


public class BindingException extends Exception
    {
        public BindingException(Object key, Env<?, ?> env) {
            super("Key " + key + " already defined in " + env);
        }

        private static final long serialVersionUID = 472453313488024837L;
    }
