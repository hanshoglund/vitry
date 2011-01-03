package vitry.primitive;

import java.util.Iterator;


public abstract class AbstractCompoundPattern extends AbstractPattern implements
        CompoundPattern
    {
        public boolean eq(Set o) {
            return this.match(o) && this.matchFor(o);
        }

        public boolean eq(Union o) {
            return this.match(o) && this.matchFor(o);
        }

        public boolean eq(Intersection o) {
            return this.match(o) && this.matchFor(o);
        }

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

            if (o instanceof Set) return this.eq((Set) o);
            if (o instanceof Union) return this.eq((Union) o);
            if (o instanceof Intersection) return this.eq((Intersection) o);
            return false;
        }

        // TODO hashCode

        public Iterator<Pattern> iterator() {
            return new SeqIterator<Pattern>(this);
        }
    }
