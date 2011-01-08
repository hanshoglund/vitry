package vitry.primitive;

import java.util.Iterator;


public class ArraySeq<T> implements Seq<T>
    {
        private final T[] elements;

        private final int offset;

        public ArraySeq(T... elements) {
            this(elements, 0);
        }

        public ArraySeq(T[] elements, int offset) {
            if (offset >= elements.length) throw new IllegalArgumentException();
            this.elements = elements;
            this.offset = offset;
        }
        
        private ArraySeq(T[] elements, int offset, int dummy) {
            if (offset >= elements.length) throw new IllegalArgumentException();
            this.elements = elements;
            this.offset = offset;
        }

        public Iterator<T> iterator() {
            return new ArrayIterator<T>(elements);
        }

        public T head() {
            return elements[offset];
        }

        public Seq<T> tail() {
            if (offset + 1 >= elements.length) return null;
            return new ArraySeq<T>(elements, offset + 1, NO_CHECK);
        }
        
        private static final int NO_CHECK = 0;
    }
