package vitry.primitive;

public class Empty extends AbstractPattern implements Value
    {
        private Empty() {}

        private static Empty instance = new Empty();

        public static Empty getInstance() {
            return instance;
        }

        public boolean matchFor(Pattern p) {
            return true;
        }

        public String toString() {
            return "{}";
        }
    }
