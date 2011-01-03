package vitry.primitive;

/**
 * The & type.
 */
public interface Intersection extends Value, CompoundPattern
    {
    }


abstract class AbstractIntersection extends AbstractCompoundPattern implements Intersection
    {
        public boolean match(Atom a) {
            for (Pattern x : this)
                if (!x.match(a)) return false;
            return true;
        }

        public boolean match(Product a) {
            for (Pattern x : this)
                if (!x.match(a)) return false;
            return true;
        }
        
        public boolean match(Intersection a) {
            for (Pattern x : this)
                if (!x.match(a)) return false;
            return true;
        }
        
        public boolean eqFor(Value p) {
            return p.eq(this);
        }
        
        public boolean matchFor(Pattern p) {
            return p.match(this);
        }
        
        public String toString() {
            return Util.join(this, "(", " & ", ")");
        }
    }