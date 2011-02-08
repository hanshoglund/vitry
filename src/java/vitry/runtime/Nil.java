/*
 * Vitry, copyright (C) Hans Hoglund 2011
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * See COPYING.txt for details.
 */
package vitry.runtime;

import java.util.Iterator;

import vitry.runtime.struct.MapSequence;
import vitry.runtime.struct.PairSequence;
import vitry.runtime.struct.Sequence;
import vitry.runtime.struct.SequenceIterator;

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

        public <U> MapSequence<Pattern, U> map(Function fn) {
            return new MapSequence<Pattern, U>(fn, this);
        }

        public boolean isCompound() {
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

        public InvertibleFunction structor() {
            return throwUnsupported();
        }

        public SequenceIterator<Pattern> sequenceIterator() {
            return throwUnsupported();
        }

        private <T> T throwUnsupported() {
            throw new UnsupportedOperationException("() has no members.");
        }
        

    }