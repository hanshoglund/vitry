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

public final class Unit extends Atom implements Product
    {
        private Unit() {}

        private static Unit instance = new Unit();

        public static Unit getInstance() {
            return instance;
        }

        public boolean eq(Atom o) {
            return o == this;
        }

        public String toString() {
            return "()";
        }
        
        public Product first() {
            throw new RuntimeException("() has no members");
        }
        
        public Product second() {
            throw new RuntimeException("() has no members");
        }
        
        public Pattern head() {
            throw new RuntimeException("Attempted to read head of ()");
        }

        public Seq<Pattern> tail() {
            throw new RuntimeException("Attempted sequencing over ()");
        }

        public Iterator<Pattern> iterator() {
            throw new RuntimeException("Attempted sequencing over ()");
        }
    }
