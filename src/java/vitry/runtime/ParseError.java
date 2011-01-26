package vitry.runtime;

public class ParseError extends VitryError
    {
        private ParseError(String string, Throwable cause) {
            super(string, cause);
        }

        private ParseError(String string) {
            super(string);
        }

        private static final long serialVersionUID = -3575441316543897521L;

    }
