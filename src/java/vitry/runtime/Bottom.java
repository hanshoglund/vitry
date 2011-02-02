package vitry.runtime;

import vitry.runtime.struct.Sequence;

/**
 * Implements the empty set, written as <code>{}</code>.
 */
public final class Bottom extends InclusionPattern implements SetLike
    {
        private Bottom() {}

        public static final Bottom instance = new Bottom();

        public boolean eq(SetLike o) {
            return o == this;
        }

        public boolean eqFor(Value o) {
            return o.eq(this);
        }

        public boolean matchFor(Pattern p) {
            if (p == this) return true; // Optimization
            return p.match(this);
        }

        public String toString() {
            return "{}";
        }

        public int hashCode() {
            return -1;
        }

        public boolean hasTail() {
            return false;
        }
        

        public Pattern head() {
            return throwUnsupported();
        }

        public Sequence<Pattern> tail() {
            return throwUnsupported();
        }       
        
        private <T> T throwUnsupported() {
            throw new UnsupportedOperationException("{} has no members.");
        }
    }