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

import java.util.Iterator;

import vitry.runtime.misc.HashUtil;
import vitry.runtime.misc.MiscUtil;
import vitry.runtime.seq.Seq;
import vitry.runtime.seq.SeqIterator;


/**
 * A compound value, representing tuples as well as product types.
 * 
 * We disallow nullary and unary instances, as () and (x)
 * are represented by the Unit class and the class of x respectively. Thus
 * instances of this interface represent n-tuples where n < 1.
 * 
 * TODO should Unit extend Product?
 * 
 * Invariants:
 *   - p.first() != null
 *   - p.second() != null
 * 
 */
public interface Product extends Pattern, Seq<Pattern>
    {
        public Pattern first();
        public Pattern second();
    }


