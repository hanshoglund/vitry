package vitry.primitive;

/**
 * Implement:
 *   - provide matchedBy
 *   - (opt) override match
 *   - (opt) provide constructors (Pattern...) and (Seq<Pattern>)
 */
public abstract class AbstractPattern implements Pattern
    {
        public boolean match(Object o) {
            return false;
        }

        public boolean match(Product p) {
            return false;
        }

        public boolean match(Union p) {
            return false;
        }

        public boolean match(Set p) {
            return false;
        }

        public boolean match(Intersection p) {
            return false;
        }

        public boolean match(Type p) {
            return false;
        }

        public boolean match(FunctionType p) {
            return false;
        }
    }
