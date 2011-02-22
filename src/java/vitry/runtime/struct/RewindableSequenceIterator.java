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
package vitry.runtime.struct;

/**
 * A SequenceIterator that remembers its starting point.
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
