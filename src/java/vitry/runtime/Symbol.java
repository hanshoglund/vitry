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
 * Standard symbols. Note that Vitry symbols does not have 
 * namespaces, they are simply unique refences accessed by name.
 *
 * @author Hans Hoglund
 */
public class Symbol extends Atom
{

    public static Symbol intern(String name)
    {
        if (symbols.containsKey(name))
            return symbols.get(name);
        else
        {
            Symbol sym = new Symbol(name);
            symbols.put(name, sym);
            return sym;
        }
    }

    // Eq, string and hashCode

    public String toString()
    {
        return name;
    }

    public boolean equals(Object o)
    {
        // return o == this || o.toString() == this.name;
        return o == this;
    }

    public int hashCode()
    {
        if (cachedHashCode == 0)
            cachedHashCode = this.name.hashCode();
        return cachedHashCode;
    }

    private final String name;
    private int cachedHashCode;


    private Symbol(String name) {
        this.name = name;
    }

    /**
     * Global symbol table
     */
    private static Map<String, Symbol> symbols = new HashMap<String, Symbol>();
}
