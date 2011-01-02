package vitry.primitive;

/**
 * The {} type.
 */
public interface Set extends Value, Pattern
    {
    }


abstract class AbstractSet extends CompoundPattern implements Set
    {
        public boolean match(Object a) {
            for (Pattern x : this)
                if (a.equals(x)) return true;
            return false;
        }

        public boolean match(Product a) {
            for (Pattern x : this)
                if (a.equals(x)) return true;
            return false;
        }

        public boolean matchedBy(Pattern p) {
            return p.match(this);
        }
    }
