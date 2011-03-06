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


/**
 * Basic atomic value.
 */
abstract public class Atom extends BasePattern
{
    @Override
    public boolean eq(Atom o)
    {
        return this.equals(o);
    }

    @Override
    public boolean match(Atom o)
    {
        return this.eq(o);
    }

    public boolean eqFor(Pattern o)
    {
        return o.eq(this);
    }

    public boolean matchFor(Pattern p)
    {
        return p.match(this);
    }


    // Java stuff

    public boolean equals(Object o)
    {
        if (o == this)
            return true;
        if (o instanceof Atom)
            return eq((Atom) o);
        return false;
    }
}
