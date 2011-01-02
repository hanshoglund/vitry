package vitry.primitive;

/**
 * The | type.
 */
public interface Union extends Value, Pattern
    {
    }


abstract class AbstractUnion extends CompoundPattern implements Union
    {
        public boolean match(Object a) {
            for (Pattern x : this)
                if (x.match(a)) return true;
            return false;
        }

        public boolean match(Product a) {
            for (Pattern x : this)
                if (x.match(a)) return true;
            return false;
        }
        
        public boolean matchedBy(Pattern p) {
            return p.match(this);
        }
    }