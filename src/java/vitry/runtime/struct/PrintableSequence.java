package vitry.runtime.struct;

import java.util.Iterator;

import vitry.runtime.util.Utils;


/**
 * For debugging. Prints like a product.
 */
public class PrintableSequence<T> extends AbstractSequence<T>
    {
        private Sequence<T> delegee;

        public PrintableSequence(Sequence<T> delegee) {
            this.delegee = delegee;
        }

        public T head() {
            return delegee.head();
        }

        public boolean hasTail() {
            return delegee.hasTail();
        }

        public Sequence<T> cons(T head) {
            return delegee.cons(head);
        }

        public Iterator<T> iterator() {
            return delegee.iterator();
        }

        public Sequence<T> tail() {
            return delegee.tail();
        }
        
        public SequenceIterator<T> sequenceIterator() {
            return delegee.sequenceIterator();
        }

        public String toString() {
            return Utils.join(this, "(", ", ", ")");
        }
    }
