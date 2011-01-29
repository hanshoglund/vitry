package vitry.runtime;

public class MatchingError extends VitryError
    {

        public MatchingError(Object value) {
            super("No viable alternative for " + value);
        }

        private static final long serialVersionUID = 2898202248351761101L;

    }
