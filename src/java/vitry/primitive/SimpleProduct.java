package vitry.primitive;

import java.util.Iterator;


public class SimpleProduct extends AbstractProduct
    {
        Seq<Pattern> elements;

        public SimpleProduct(Object... elements) {
            this.elements = Native.wrap(new ArraySeq<Object>(elements));
        }

        public SimpleProduct(Pattern... elements) {
            this.elements = new ArraySeq<Pattern>(elements);
        }

        public Iterator<Pattern> iterator() {
            return elements.iterator();
        }

        public Pattern head() {
            return elements.head();
        }

        public Seq<Pattern> tail() {
            return elements.tail();
        }
        
        
//        private Pattern[] elements;
//        private int offset;
//
//        public SimpleProduct(Object... elements) {
//            this(PrimitiveValue.wrap(elements));
//        }        
//        
//        public SimpleProduct(Pattern... elements) {
//            this(elements, 0);
//        }
//        
//        private SimpleProduct(Pattern[] elements, int offset) {
//            if (offset >= elements.length) throw new IllegalArgumentException();
//            this.elements = elements;
//            this.offset = offset;
//        }
//
//        public Iterator<Pattern> iterator() {
//            return new ArrayIterator<Pattern>(elements);
//        }
//
//        public Pattern head() {
//            return elements[offset];
//        }
//
//        public Seq<Pattern> tail() {
//            if (offset + 1 >= elements.length) return null;
//            return new SimpleProduct(elements, offset + 1);
//        }
    }
