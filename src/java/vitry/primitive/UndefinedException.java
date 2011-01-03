package vitry.primitive;

public class UndefinedException extends RuntimeException
    {
        public UndefinedException(Object key, Environment<?,?> source) {
            super("Could not find key " + key + " in " + source);
        }

        private static final long serialVersionUID = -8154071457798846190L;
    }
