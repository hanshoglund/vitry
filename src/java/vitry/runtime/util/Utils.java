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
package vitry.runtime.util;

import vitry.runtime.Symbol;

public class Utils
{
    
    private Utils(){}

    public static Symbol maybeIntern(Object s) {
        if (s instanceof Symbol) return (Symbol) s;
        return Symbol.intern((String) s);
    }

    public static <U> U unsafe(Object val)
    {
        @SuppressWarnings("unchecked")
        U casted = (U) val;
        return casted;
    }

    public static <T> void nothing(T val)
    {
        return;
    }

    public static <T> T assertFalse()
    {
        return assertFalse("");
    }

    public static <T> T assertFalse(String msg)
    {
        throw new AssertionError(msg);
    }

    public static int hash(int seed, int val)
    {
        return (seed * 65050 + val) % 2044508069;
    }

    public static int hash(int seed, Object val)
    {
        return hash(seed, val.hashCode());
    }

    public static int hash(int seed, Iterable<?> vals)
    {
        int hash = seed;
        for (Object v : vals)
            hash = hash(hash, v);
        return hash;
    }

}
