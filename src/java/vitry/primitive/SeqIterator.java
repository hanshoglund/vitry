package vitry.primitive;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class SeqIterator<T> implements Iterator<T>
    {
        private Seq<T> seq;

        public SeqIterator(Seq<T> seq) {
            this.seq = seq;
        }

        public boolean hasNext() {
            return (seq != null) && (seq.head() != null);
        }

        public T next() {
            if (seq == null || seq.head() == null) throw new NoSuchElementException();

            T head = seq.head();
            seq = seq.tail();
            return head;
        }

        public void remove() {
            throw new UnsupportedOperationException("Can not modify a Seq");
        }
    }
