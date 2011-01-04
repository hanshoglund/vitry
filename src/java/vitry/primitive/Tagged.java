package vitry.primitive;


public class Tagged extends AbstractPattern
    {
        final Value  val;

        final Object tag;

        public Tagged(Value val, Object tag) {
            this.val = val;
            this.tag = tag;
        }

        //        public Value val() {
        //            return val;
        //        }
        //
        //        public Object tag() {
        //            return tag;
        //        }

        public boolean eq(Tagged o) {
            return (this == o) || (val.eqFor(o.val) && tag.equals(o.tag));
        }
        
        public boolean match(Tagged o) {
            return (this == o) || (val.eqFor(o.val) && tag.equals(o.tag));
        }

        public boolean eqFor(Value o) {
            return o.eq(this);
        }

        public boolean matchFor(Pattern p) {
            return p.match(this);
        }

        public String toString() {
            return val.toString();
        }
    }
