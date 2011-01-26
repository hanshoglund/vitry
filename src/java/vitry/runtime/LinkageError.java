package vitry.runtime;

public class LinkageError extends VitryError
    {
        private LinkageError(String string, Throwable cause) {
            super(string, cause);
        }

        private LinkageError(String string) {
            super(string);
        }

        private static final long serialVersionUID = -3575441316543897521L;

    }
