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

import vitry.runtime.util.*;


/**
 * Pattern matching all of its elements.
 */
abstract public class Intersection extends InclusionPattern
{

    @Override
    public boolean match(Object o)
    {
        if (o instanceof Pattern)
            throw new IllegalArgumentException();
        for (Pattern x : this)
            if (!x.match(o))
                return false;
        return true;
    }

    @Override
    public boolean match(Atom a)
    {
        for (Pattern x : this)
            if (!x.match(a))
                return false;
        return true;
    }

    @Override
    public boolean match(Tagged p)
    {
        for (Pattern x : this)
            if (!x.match(p))
                return false;
        return true;
    }

    @Override
    public boolean match(Product a)
    {
        for (Pattern x : this)
            if (!x.match(a))
                return false;
        return true;
    }

    @Override
    public boolean match(List a)
    {
        for (Pattern x : this)
            if (!x.match(a))
                return false;
        return true;
    }

    @Override
    public boolean match(Intersection a)
    {
        for (Pattern x : this)
            if (!x.match(a))
                return false;
        return true;
    }

    public boolean eqFor(Pattern p)
    {
        return p.eq(this);
    }

    public boolean matchFor(Pattern p)
    {
        return p.match(this);
    }

    // Java stuff

    public String toString()
    {
        return Strings.join(this, "", " & ", "");
    }
}