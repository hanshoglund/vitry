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

import vitry.runtime.struct.ConsSeq;
import vitry.runtime.struct.MapSeq;
import vitry.runtime.struct.Seq;


abstract public class AbstractList extends ConstructionPattern
    {

        public Seq<Pattern> cons(Pattern head) {
            return new ConsSeq<Pattern>(head, this);
        }

        public Seq map(Apply fn) {
            return null;
//            return new MapSeq<Pattern, Pattern>(fn, this);
        }

        public Iterator<Pattern> iterator() {
            return null;
            // TODO Auto-generated method stub
        }

        public boolean eqFor(Value o) {
            return false;
            // TODO Auto-generated method stub
        }

        public boolean matchFor(Pattern p) {
            return false;
            // TODO Auto-generated method stub
        }

    }
