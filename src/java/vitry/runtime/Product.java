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

import vitry.runtime.struct.Sequence;


/**
 * A compound value.
 *
 * Represents <em>n</em>-ary tuples and <em>n</em>-ary product types where <em>n</em> > 1.
 * This interface is the backbone of the structural type system, so we provide many several
 * implementation possibilities, including Seq, Par and generated classes.
 * 
 * Invariants:
 *   - <code>p.fst() != null</code>
 *   - <code>p.snd() != null</code>
 * 
 */
public interface Product extends Pattern, Sequence<Pattern>, Structible
    {
        public Pattern first();

        public Pattern second();
    }
