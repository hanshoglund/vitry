package vitry.runtime;

import java.util.Iterator;

import vitry.runtime.struct.MapSequence;
import vitry.runtime.struct.PairSequence;
import vitry.runtime.struct.Sequence;

/**
 * The nil value, written as <code>()</code>.
 */
public final class Nil extends Atom implements Product
    {
        Nil() {}

        public boolean eq(Atom o) {
            return o == this;
        }

        public String toString() {
            return "()";
        }

        public Sequence<Pattern> cons(Pattern head) {
            return new PairSequence<Pattern>(head, this);
        }

        public <U> MapSequence<Pattern, U> map(Apply fn) {
            return new MapSequence<Pattern, U>(fn, this);
        }

        public boolean isDestructible() {
            return false;
        }

        public boolean hasTail() {
            return false;
        }

        // Rest of interface unsupported...

        public Product first() {
            return throwUnsupported();
        }

        public Product second() {
            return throwUnsupported();
        }

        public Pattern head() {
            return throwUnsupported();
        }

        public Sequence<Pattern> tail() {
            return throwUnsupported();
        }

        public Iterator<Pattern> iterator() {
            return throwUnsupported();
        }

        public Sequence<Pattern> destruct() {
            return throwUnsupported();
        }

        public Bijection structor() {
            return throwUnsupported();
        }

        private <T> T throwUnsupported() {
            throw new UnsupportedOperationException("() has no members.");
        }
    }