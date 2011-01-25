package vitry.runtime.struct;

import java.util.Iterator;


/**
 * Adapts seq from an Iterable.
 */
public class IterableSeq<T> extends AbstractSeq<T>
    {
        private Iterable<T> itbl;
        private Iterator<T> it;
        private T head;
        private Seq<T> tail;

        public IterableSeq(Iterable<T> itbl) {
            this.itbl = itbl;
            this.it = itbl.iterator();
        }

        private IterableSeq(Iterable<T> itbl, Iterator<T> it) {
            this.itbl = itbl;
            this.it = it;
        }

        public Iterator<T> iterator() {
            return itbl.iterator();
        }

        public T head() {
            if (head == null) head = it.next();
            return head;
        }

        public Seq<T> tail() {
            // Assure we have taken a value
            if (head == null && it.hasNext()) head = it.next();
            if (!it.hasNext()) return null;
            else {
                if (tail == null)
                    tail = new IterableSeq<T>(itbl, it);
                return tail;
            }
        }
    }
