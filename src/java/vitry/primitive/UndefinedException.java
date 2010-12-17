package vitry.primitive;

public class UndefinedException extends Exception
    {
        public UndefinedException(Object key, Env<?,?> source) {
            super("Could not find key " + key + " in " + source);
        }

        private static final long serialVersionUID = -8154071457798846190L;
    }
