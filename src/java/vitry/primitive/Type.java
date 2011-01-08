package vitry.primitive;

public interface Type extends Pattern
    {
        Pattern pattern();

        Object tag();
        
        Tagged applyTag(Value v) throws TypeException;
    }


class TypeImpl extends BasePattern implements Type
    {
        private final Pattern pattern;
        private final Object tag;
        
        public TypeImpl(Pattern pattern, Object tag) {
            this.pattern = pattern;
            this.tag = tag;
        }

        public Pattern pattern() {
            return pattern;
        }

        public Object tag() {
            return tag;
        }

        public Tagged applyTag(Value v) throws TypeException {
            if (v.matchFor(pattern))
                return new Tagged(v, tag);
            else 
                throw new TypeException(tag, v);
        }

        public boolean eq(Type o) {
            return (this == o) || (pattern.eqFor(o.pattern()) && tag.equals(o.tag()));
        }
        
        public boolean match(Tagged p) {
            return p.tag == tag;
        }

        public boolean match(Type o) {
            return pattern.matchFor(o.pattern()) && tag.equals(o.tag());
        }
        
        public boolean matchFor(Pattern p) {
            return p.match(this);
        }

        public boolean eqFor(Value o) {
            return o.eq(this);
        }
        
        public String toString() {
            return tag.toString();
        }

        public int hashCode() {
            int hash = this.getClass().hashCode();
            hash = Util.hash(hash, pattern);
            hash = Util.hash(hash, tag);
            return hash;
        }

    }
