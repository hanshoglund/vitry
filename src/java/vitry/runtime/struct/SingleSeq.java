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
 * A seq containing a single value.
 */
public class SingleSeq<T> extends AbstractSeq<T> implements Countable
    {
        
        private final T obj;
        
        public SingleSeq(T obj) {
            this.obj = obj;
        }

        public T head() {
            return obj;
        }

        public Seq<T> tail() {
            return null;
        }

        public int count() {
            return 1;
        }

        public boolean hasTail() {
            return false;
        }
    }