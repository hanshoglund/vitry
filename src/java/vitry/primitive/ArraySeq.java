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

/**
 * Adapts arrays as Seqs.
 */
public class ArraySeq<T> implements Seq<T>
    {
        private final T[] array;

        private final int offset;

        public ArraySeq(T... elements) {
            this(elements, 0);
        }

        public ArraySeq(T[] elements, int offset) {
            if (offset >= elements.length) throw new IllegalArgumentException();
            this.array = elements;
            this.offset = offset;
        }
        
        private ArraySeq(T[] elements, int offset, int dummy) {
            this.array = elements;
            this.offset = offset;
        }

        public Iterator<T> iterator() {
            return new ArrayIterator<T>(array, offset);
        }

        public T head() {
            return array[offset];
        }

        public Seq<T> tail() {
            if (offset + 1 >= array.length) return null;
            return new ArraySeq<T>(array, offset + 1, NO_CHECK);
        }
        
        private static final int NO_CHECK = 0;

        public Seq<T> cons(T head) {
            return null;
            // TODO Auto-generated method stub
        }
    }
