package vitry.primitive;

import java.util.Iterator;

public class SeqIterator<T> implements Iterator<T>
    {
        private Seq<T> seq;

        public SeqIterator(Seq<T> seq) {
            this.seq = seq;
        }

        public boolean hasNext() {
            return seq != null;
        }

        public T next() {
            T head = seq.head();
            seq = seq.tail();
            return head;
        }

        public void remove() {
            throw new UnsupportedOperationException("Can not modify a Seq");
        }
    }
