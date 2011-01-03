package vitry.primitive;

import java.util.Iterator;

public abstract class AbstractCompoundPattern extends AbstractPattern implements CompoundPattern
    {        
        public boolean match(Set a) {
            for (Pattern x : a)
                if (!x.matchFor(this)) return false;
            return true;
        }

        public boolean match(Union a) {
            for (Pattern x : a)
                if (!x.matchFor(this)) return false;
            return true;
        }

        public boolean match(Intersection a) {
            for (Pattern x : a)
                if (x.matchFor(this)) return true;
            return false;
        }

        public boolean match(Type p) {
            return false;
            // TODO
        }

        public boolean match(FunctionType p) {
            return false;
            // TODO
        }

        public boolean equals(Object o) {
            if (o == this) return true;
            
            if (o instanceof Set) {
                Set x = (Set) o;
                return this.match(x) && this.matchFor(x);
            }
            if (o instanceof Union) {
                Union x = (Union) o;
                return this.match(x) && this.matchFor(x);
            }
            if (o instanceof Intersection) {
                Intersection x = (Intersection) o;
                return this.match(x) && this.matchFor(x);
            }
            return false;
        }
        
        // TODO hashCode
        
        public Iterator<Pattern> iterator() {
            return new SeqIterator<Pattern>(this);
        }
    }
