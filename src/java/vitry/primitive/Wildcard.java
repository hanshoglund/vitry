package vitry.primitive;

/**
 * The ? type.
 */
public class Wildcard extends Atom
    {
        private Wildcard() {
        }

        private static Wildcard instance = new Wildcard();

        public static Wildcard getInstance() {
            return instance;
        }

        public boolean eq(Atom o) {
            return o == this;
        }

        public boolean match(Atom o) {
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

        public String toString() {
            return "?";
        }
    }
