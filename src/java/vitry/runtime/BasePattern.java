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


abstract class BasePattern implements Pattern
{
    public boolean eq(Object o)
    {
        if (o instanceof Pattern)
            throw new IllegalArgumentException();
        return false;
    }

    public boolean eq(Atom o)
    {
        return false;
    }

    public boolean eq(Tagged o)
    {
        return false;
    }

    public boolean eq(Product o)
    {
        return false;
    }

    public boolean eq(Function o)
    {
        return false;
    }

    public boolean eq(List o)
    {
        return false;
    }

    public boolean eq(Set o)
    {
        return false;
    }

    public boolean eq(Union o)
    {
        return false;
    }

    public boolean eq(Intersection o)
    {
        return false;
    }

    public boolean eq(Type o)
    {
        return false;
    }

    public boolean match(Object o)
    {
        if (o instanceof Pattern)
            throw new IllegalArgumentException();
        return false;
    }

    public boolean match(Atom o)
    {
        return false;
    }

    public boolean match(Tagged p)
    {
        return false;
    }

    public boolean match(Product p)
    {
        return false;
    }

    public boolean match(Function p)
    {
        return false;
    }

    public boolean match(List p)
    {
        return false;
    }

    public boolean match(Set p)
    {
        return false;
    }

    public boolean match(Union p)
    {
        return false;
    }

    public boolean match(Intersection a)
    {
        for (Pattern x : a)
            if (x.matchFor(this))
                return true;
        return false;
    }

    public boolean match(Type p)
    {
        return false;
    }

}
