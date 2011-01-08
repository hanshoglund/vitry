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

/**
 * Basic sequence abstraction.
 * 
 *   - We implement this on all sequential language types, such as products,
 *     compound patterns and lists to support efficient conversions. 
 *   - May be lazy.
 *   - Extends iterable to support efficient traversal of non-linked structures.
 *   - The empty sequence is represented by `null`
 * 
 * Implement:
 * 
 *   - head/tail, iterator or both
 *   
 */
public interface Seq<T> extends Iterable<T>
    {
        /*
         * Returns the first element of this seq.
         * This class should generally not return null, except if the actual
         * sequence has to contain null references.
         */
        T head();

        /**
         * Returns all other elements of this sequence or null if there
         * are none.
         */
        Seq<T> tail();
    }
