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


public class IntStack
    {
        public int push(int v) {
            ensureCapacity(v * 2);
            values[++top] = v;
            return v;
        }

        public int pop() {
            if (top < 0) throw new IndexOutOfBoundsException();
            return values[top--];
        }

        public int peek() {
            if (top < 0) throw new IndexOutOfBoundsException();
            return values[top];
        }

        private void ensureCapacity(int size) {
            if (values.length < size) {
                int[] old = values;
                values = new int[size];
                System.arraycopy(old, 0, values, 0, old.length);
            }
        }

        private int[] values = new int[24];

        private int top = -1;
    }