package vitry.primitive;

/**
 * The -> type.
 */
public interface FunctionType extends Value, Pattern
    {
        Pattern codomain();

        Pattern domain();
    }


class FunctionTypeImpl extends AbstractPattern implements FunctionType
    {

        private Pattern codomain;

        private Pattern domain;

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

        public boolean match(FunctionType p) {
            return false;
        }

        public boolean matchFor(Pattern p) {
            return p.match(this);
        }
    }