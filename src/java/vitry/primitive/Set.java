package vitry.primitive;

/**
 * The {} type.
 */
public interface Set extends Value, CompoundPattern
    {
    }


abstract class AbstractSet extends AbstractCompoundPattern implements Set
    {
        public boolean match(Object a) {
            for (Pattern x : this)
                if (a.equals(x) || x.equals(a)) return true;
            return false;
        }

        public boolean match(Product a) {
            for (Pattern x : this)
                if (a.equals(x) || x.equals(a)) return true;
            return false;
        }

        public boolean matchFor(Pattern p) {
            return p.match(this);
        }
        
        public String toString() {
            return Util.join(this, "{", ", ", "}");
        }
    }
