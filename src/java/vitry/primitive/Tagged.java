package vitry.primitive;


public class Tagged extends BasePattern
    {
        public final Value  val;

        public final Object tag;

        public Tagged(Value val, Object tag) {
            this.val = val;
            this.tag = tag;
        }

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
        
        
        // Java stuff
        
        public boolean equals(Object o) {
            if (o instanceof Tagged) return ((Tagged) o).eq(this);
            return false;
        }

        public int hashCode() {
            int hash = this.getClass().hashCode();
            hash = Util.hash(hash, val);
            hash = Util.hash(hash, tag);
            return hash;
        }        
    }
