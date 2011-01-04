package vitry.primitive;

/**
 * The {} value.
 */
public class Empty extends AbstractCompoundPattern implements Value, Set
    {
        private Empty() {}

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
            // FIXME What if someone calls match passing this value directly
            return true;
        }

        public String toString() {
            return "{}";
        }

        public Pattern head() {
            return null;
            // TODO Auto-generated method stub
        }

        public Seq<Pattern> tail() {
            return null;
            // TODO Auto-generated method stub
        }
    }
