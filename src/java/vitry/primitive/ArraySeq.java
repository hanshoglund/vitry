package vitry.primitive;

import java.util.Iterator;


public class ArraySeq<T> implements Seq<T>
    {
        private T[] elements;

        private int offset;

        public ArraySeq(T... elements) {
            this(elements, 0);
        }

        private ArraySeq(T[] elements, int offset) {
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
            return new ArraySeq<T>(elements, offset + 1);
        }
    }
