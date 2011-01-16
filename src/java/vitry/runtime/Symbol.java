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

import java.util.HashMap;
import java.util.Map;

/**
 * Named, unique entities.
 * 
 * Invariants:
 * 
 *   - Symbol.generate(S) = Symbol.generate(S) where S is any string
 * 
 * TODO
 * 
 *   - Change impl to use interned strings!
 * 
 * @author hans
 */
public class Symbol extends Atom
    {

        public static Symbol intern(String name) {
            if (table.containsKey(name)) return table.get(name);
            else {
                Symbol sym = new Symbol(name);
                table.put(name, sym);
                return sym;
            }
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            // return o == this || o.toString() == this.name;
            return o == this;
        }

        @Override
        public int hashCode() {
            if (cachedHashCode == 0)
                cachedHashCode = this.name.hashCode();
            return cachedHashCode;
        }

        private final String               name;
        private int                        cachedHashCode;


        private static Map<String, Symbol> table             = new HashMap<String, Symbol>();

        private Symbol(String name) {
            this.name = name;
        }
    }
