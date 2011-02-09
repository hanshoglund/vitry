package vitry.runtime.struct;



/**
 * A SequenceIterator that remembers where it started.
 */
public class RewindableSequenceIterator<T> extends SequenceIterator<T>
    {
        private final Sequence<T> start;

        public RewindableSequenceIterator(Sequence<T> seq) {
            super(seq);
            this.start = seq;
        }
        
        public RewindableSequenceIterator(SequenceIterator<T> it) {
            super(it.seq);
            this.start = it.seq;
        }
        
        public void rewind() {
            this.seq = start;
        }
        
        /**
         * Returns  all elements leeding up to the current sequence
         * from the starting point.
         */
        public Sequence<T> preceding() {
            return Sequences.until(start, seq);
        }
    }
