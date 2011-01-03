package vitry.primitive;

public class Wildcard extends AbstractPattern implements Value
    {
        private Wildcard() {}

        private static Wildcard instance = new Wildcard();

        public static Wildcard getInstance() {
            return instance;
        }
        
        public boolean match(Object o) {
            return true;
        }

        public boolean match(Product p) {
            return true;
        }

        public boolean match(Union p) {
            return true;
        }

        public boolean match(Set p) {
            return true;
        }

        public boolean match(Intersection p) {
            return true;
        }

        public boolean match(Type p) {
            return true;
        }

        public boolean match(FunctionType p) {
            return true;
        }

        public boolean matchFor(Pattern p) {
            return p == this;
        }

        public String toString() {
            return "?";
        }
    }
