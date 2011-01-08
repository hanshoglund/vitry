package vitry.primitive;

/**
 * The {} value.
 */
public class Empty extends AbstractCompoundPattern implements Set
    {
        private Empty() {
        }

        private static final Empty instance = new Empty();

        public static Empty getInstance() {
            return instance;
        }

        public boolean eq(Set o) {
            return o == this;
        }

        public boolean eqFor(Value o) {
            return o.eq(this);
        }

        public boolean matchFor(Pattern p) {
            if (p == this) return true;
            return p.matchFor(this);
        }

        public Pattern head() {
            throw new UnsupportedOperationException("{} has no members.");
        }

        public Seq<Pattern> tail() {
            throw new UnsupportedOperationException("{} has no members.");
        }

        public String toString() {
            return "{}";
        }
        
        public int hashCode() {
            return -1;
        }
    }
