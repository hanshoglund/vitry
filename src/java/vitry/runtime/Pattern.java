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
 * Represents basic matching logic.
 *
 * @author Hans Höglund
 */
public interface Pattern
    {
        boolean eq(Object o);

        boolean eq(Atom o);

        boolean eq(Tagged o);

        boolean eq(Product o);

        boolean eq(Function p);

        boolean eq(AbstractList p);

        boolean eq(Set o);

        boolean eq(Union o);

        boolean eq(Intersection o);

        boolean eq(Type o);

        boolean match(Object o);

        boolean match(Atom o);

        boolean match(Tagged o);

        boolean match(Product p);

        boolean match(Function p);

        boolean match(AbstractList p);

        boolean match(Set p);

        boolean match(Union p);

        boolean match(Intersection p);

        boolean match(Type p);
                           
                           
        // Main dispatchers
        
        boolean eqFor(Pattern o);

        boolean matchFor(Pattern p);
    }
