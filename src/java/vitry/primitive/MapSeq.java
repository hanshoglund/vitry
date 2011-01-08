package vitry.primitive;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Lazy map implementation.
 */
public class MapSeq<A,B> implements Seq<B>
    {
        private final Function fn;
        private final Seq<A> input;

        public MapSeq(Function fn, Seq<A> input) {
            Util.checkNull(fn, input);
            Util.checkArity(fn, 1);
            this.fn = fn;
            this.input = input;
        }

        public Iterator<B> iterator() {
            return new MapIterator<B>(fn, input.iterator());
        }

        public B head() {
            A head = input.head();
            if (head == null) return null;
            try {
                return (B) fn.apply(head);
            } catch (Exception e) {
            }
            throw new RuntimeException(
                    "MapIterator faild to convert value " 
                    + head + " using " + fn);
        }

        public Seq<B> tail() {
            Seq<A> tail = input.tail();
            return (tail == null) ? null : new MapSeq<A, B>(fn, tail);
        }
    }

class MapIterator<T> implements Iterator<T> {
        
    private Applicable fn;
    private Iterator<?> input;

    public MapIterator(Function fn, Iterator<?> input) {
        Util.checkArity(fn, 1);
        this.fn = fn;
        this.input = input;
    }

    public boolean hasNext() {
        return input.hasNext();
    }

    public T next() {
        Object next = input.next();
        try {
            return (T) fn.apply(next);
        } catch (NoSuchElementException e) {
            throw e;
        } catch (Exception e) {
        }
        throw new RuntimeException(
                "MapIterator faild to convert value " 
                + next + " using " + fn);
    }

    public void remove() {
        throw new UnsupportedOperationException("Can not remove from a MapIterator");
    }
        
}