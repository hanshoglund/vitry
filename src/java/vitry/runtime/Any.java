package vitry.runtime;

/**
 * The top type, written as <code>_</code>.
 */
public final class Any extends Atom
    {
        Any() {}

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

        public boolean match(SetLike p) {
            return true;
        }

        public boolean match(Intersection p) {
            return true;
        }

        public boolean match(Type p) {
            return true;
        }

        public boolean match(Arrow p) {
            return true;
        }

        public String toString() {
            return "_";
        }
    }