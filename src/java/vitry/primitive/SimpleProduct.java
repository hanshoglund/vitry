package vitry.primitive;

import java.util.Iterator;


public class SimpleProduct extends AbstractProduct
    {
        private Pattern[] elements;
        private int offset;

        public SimpleProduct(Object... elements) {
            this(PrimitiveValue.wrap(elements));
        }        
        
        public SimpleProduct(Pattern... elements) {
            this(elements, 0);
        }
        
        private SimpleProduct(Pattern[] elements, int offset) {
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
            return new SimpleProduct(elements, offset + 1);
        }
    }
