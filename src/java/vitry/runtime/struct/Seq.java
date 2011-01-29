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

import vitry.runtime.Apply;


/**
 * Sequence abstraction. The idea is to have a common interface for
 * the core pattern language, as well as for the native list implementations.
 * This means we can adapt one into the in <em>O(1)</em> time.
 *
 * Implement:
 * 
 *   - head/tail and iterator
 *   
 */
public interface Seq<T> extends Iterable<T>
    {
        T head();

        Seq<T> tail();
        
        boolean hasTail();

        Seq<T> cons(T head);

        <U> Seq<U> map(Apply fn);
    }
