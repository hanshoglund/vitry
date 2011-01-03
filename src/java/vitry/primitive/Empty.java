package vitry.primitive;


public class Empty extends AbstractCompoundPattern implements Value, Set
    {
        private Empty() {}

        private static Empty instance = new Empty();

        public static Empty getInstance() {
            return instance;
        }
        
        public boolean eqFor(Value o) {
            return o == this;
        }

        public boolean matchFor(Pattern p) {
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
