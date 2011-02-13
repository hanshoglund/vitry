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
package vitry.runtime.util;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class ArrayIterator<T> implements Iterator<T>
    {
        private final T[] array;

        private int next;

        public ArrayIterator(T[] array) {
            this(array, 0);
        }

        public ArrayIterator(T[] array, int offset) {
            this.array = array;
            this.next = offset;
        }

        public boolean hasNext() {
            return next < array.length;
        }

        public T next() {
            try {
                return array[next++];
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            throw new UnsupportedOperationException("Can not remove from array");
        }
    }
