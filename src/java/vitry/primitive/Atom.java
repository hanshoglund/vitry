package vitry.primitive;

/**
 * Implement:
 *   - Value.eq OR Object.equals
 *   - Object.hashCode
 */
abstract public class Atom extends BasePattern
    {

        public boolean eq(Atom o) {
            return this.equals(o);
        }

        public boolean match(Atom o) {
            return this.eq(o);
        }

        public boolean match(Intersection a) {
            for (Pattern x : a)
                if (x.matchFor(this)) return true;
            return false;
        }

        public boolean eqFor(Value o) {
            return o.eq(this);
        }

        public boolean matchFor(Pattern p) {
            return p.match(this);
        }


        // Java stuff

        public boolean equals(Object o) {
            if (o == this) return true;
            if (o instanceof Atom) return eq((Atom) o);
            return false;
        }
    }
