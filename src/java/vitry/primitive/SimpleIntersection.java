package vitry.primitive;

import java.util.Iterator;


public class SimpleIntersection extends AbstractIntersection
    {
        private Pattern[] elements;
        private int offset;

        public SimpleIntersection(Object... elements) {
            this(PrimitiveValue.wrap(elements));
        }        
        
        public SimpleIntersection(Pattern... elements) {
            this(elements, 0);
        }
        
        private SimpleIntersection(Pattern[] elements, int offset) {
            if (offset >= elements.length) throw new IllegalArgumentException();
            this.elements = elements;
            this.offset = offset;
        }
        
        public Iterator<Pattern> iterator() {
            return new ArrayIterator<Pattern>(elements);
        }

        public Pattern head() {
            return elements[offset];
        }

        public Seq<Pattern> tail() {
            if (offset + 1 >= elements.length) return null;
            return new SimpleIntersection(elements, offset + 1);
        }
    }
