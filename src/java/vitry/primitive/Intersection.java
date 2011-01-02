package vitry.primitive;

/**
 * The & type.
 */
public interface Intersection extends Value, Pattern
    {
    }


abstract class AbstractIntersection extends CompoundPattern implements Intersection
    {
        public boolean match(Object a) {
            for (Pattern x : this)
                if (!x.match(a)) return false;
            return true;
        }

        public boolean match(Product a) {
            for (Pattern x : this)
                if (!x.match(a)) return false;
            return true;
        }
        
        public boolean matchedBy(Pattern p) {
            return p.match(this);
        }
    }