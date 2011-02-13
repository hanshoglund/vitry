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

import java.util.Iterator;

import vitry.runtime.Function;


abstract public class AbstractSequence<T> implements Sequence<T>
    {

        public Iterator<T> iterator() {
            return new SequenceIterator<T>(this);
        }

        public SequenceIterator<T> sequenceIterator() {
            return new SequenceIterator<T>(this);
        }
        
        public boolean hasTail() {
            return this.tail() == null;
        }

        public Sequence<T> cons(T head) {
            return new Pair<T>(head, this);
        }

        public <U> Sequence<U> map(Function fn) {
            return new MapSequence<T, U>(fn, this);
        }
        
        
        // DEBUG
        public String toString() {
            return Sequences.printable(this).toString();
        }
    }
