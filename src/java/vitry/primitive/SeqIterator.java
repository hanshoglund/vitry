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
