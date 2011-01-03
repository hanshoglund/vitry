package vitry.primitive;

/**
 * Implement:
 *   - provide matchedBy
 *   - (opt) override match
 *   - (opt) provide constructors (Pattern...) and (Seq<Pattern>)
 */
public abstract class AbstractPattern implements Value, Pattern
    {
        public boolean eq(Atom o) {
            return false;
        }

        public boolean eq(Product o) {
            return false;
        }
        
        public boolean eq(Union o) {
            return false;
        }

        public boolean eq(Set o) {
            return false;
        }

        public boolean eq(Intersection o) {
            return false;
        }

        public boolean eq(Type o) {
            return false;
        }

        public boolean eq(FunctionType o) {
            return false;
        }

        public boolean match(Atom o) {
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
