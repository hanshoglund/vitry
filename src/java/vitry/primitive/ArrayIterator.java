package vitry.primitive;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class ArrayIterator<T> implements Iterator<T>
    {
        private T[] array;

        private int next;

        public ArrayIterator(T[] array) {
            this(array, 0);
        }

        public ArrayIterator(T[] array, int offset) {
            this.array = array;
            this.next = offset;
        }

        public boolean hasNext() {
            return next < array.length;
        }

        public T next() {
            try {
                return array[next++];
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            throw new UnsupportedOperationException("Can not remove from an ArrayIterator");
        }

    }
