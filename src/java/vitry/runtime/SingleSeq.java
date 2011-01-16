package vitry.runtime;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A seq containing a single value.
 */
public class SingleSeq<T> implements Seq<T>
    {
        
        private final T obj;
        
        public SingleSeq(T obj) {
            this.obj = obj;
        }

        public Iterator<T> iterator() {
            return new SingleIterator<T>(obj);
        }

        public T head() {
            return obj;
        }

        public Seq<T> tail() {
            return null;
        }
        
        public Seq<T> cons(T head) {
            return new Cons<T>(head, this);
        }
    }

class SingleIterator<T> implements Iterator<T> {
        
    private final T obj;
    private boolean called = false;

    public SingleIterator(T obj) {
        this.obj = obj;
    }

    public boolean hasNext() {
        return !called;
    }

    public T next() {
        if (called) throw new NoSuchElementException();
        else {
            called = true;
            return obj;            
        }
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }        
}
