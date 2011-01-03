package vitry.primitive;


public class SimpleSet extends AbstractSet
    {
        private Pattern[] elements;
        private int offset;

        public SimpleSet(Object... elements) {
            this(PrimitiveValue.wrap(elements));
        }        
        
        public SimpleSet(Pattern... elements) {
            this(elements, 0);
        }
        
        private SimpleSet(Pattern[] elements, int offset) {
            if (offset >= elements.length) throw new IllegalArgumentException();
            this.elements = elements;
            this.offset = offset;
        }
        
        public Pattern head() {
            return elements[offset];
        }

        public Seq<Pattern> tail() {
            if (offset + 1 >= elements.length) return null;
            return new SimpleSet(elements, offset + 1);
        }
    }
