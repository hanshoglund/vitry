package vitry.primitive;

public abstract class CompoundPattern extends AbstractPattern
    {        
        public boolean match(Set a) {
            for (Pattern x : a)
                if (!x.matchedBy(this)) return false;
            return true;
        }

        public boolean match(Union a) {
            for (Pattern x : a)
                if (!x.matchedBy(this)) return false;
            return true;
        }

        public boolean match(Intersection a) {
            for (Pattern x : a)
                if (x.matchedBy(this)) return true;
            return false;
        }

        public boolean match(Type p) {
            throw new UnsupportedOperationException("No implementation");
            // TODO
        }

        public boolean match(FunctionType p) {
            throw new UnsupportedOperationException("No implementation");
            // TODO
        }

        public boolean equals(Object o) {
            if (o == this) return true;
            
            if (o instanceof Set) {
                Set x = (Set) o;
                return this.match(x) && this.matchedBy(x);
            }
            if (o instanceof Union) {
                Union x = (Union) o;
                return this.match(x) && this.matchedBy(x);
            }
            if (o instanceof Intersection) {
                Intersection x = (Intersection) o;
                return this.match(x) && this.matchedBy(x);
            }
            return false;
        }
        
        // TODO hashCode
    }
