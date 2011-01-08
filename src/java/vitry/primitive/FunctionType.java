package vitry.primitive;

public interface FunctionType extends Pattern
    {
        Pattern codomain();

        Pattern domain();
    }


class FunctionTypeImpl extends BasePattern implements FunctionType
    {

        private final Pattern codomain;

        private final Pattern domain;

        public FunctionTypeImpl(Pattern codomain, Pattern domain) {
            this.codomain = codomain;
            this.domain = domain;
        }

        public Pattern codomain() {
            return this.codomain;
        }

        public Pattern domain() {
            return this.domain;
        }

        public boolean eq(FunctionType o) {
            return (o == this) || o.codomain().eqFor(this.codomain)
                && o.domain().eqFor(this.domain);
        }

        public boolean match(Atom o) {
            // We have to cast, as Function is not in the main visitor
            return (o instanceof Function) && ((Function) o).type.eq(this);
        }

        public boolean match(FunctionType p) {
            return (p == this) || (p.codomain().matchFor(this.codomain) 
                        && p.domain().matchFor(this.domain));
        }

        public boolean matchFor(Pattern p) {
            return p.match(this);
        }

        public boolean eqFor(Value o) {
            return o.eq(this);
        }
        
        public String toString() {
            return ("" + codomain + " -> " + domain);
        }
        
        public int hashCode() {
            int hash = this.getClass().hashCode();
            hash = Util.hash(hash, codomain);
            hash = Util.hash(hash, domain);
            return hash;
        }
    }