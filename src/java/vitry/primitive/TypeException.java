package vitry.primitive;

public class TypeException extends Exception
    {

        public TypeException(Object tag, Value v) {
            super("Can not apply tag " + tag + " to " + v);
        }

        private static final long serialVersionUID = 3634069213260367204L;
    }
