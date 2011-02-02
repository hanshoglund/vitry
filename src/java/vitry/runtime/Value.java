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
 * Equality semantics. 
 * 
 * Values can be used at both sides of equality operations and
 * on the left side of match operations, however, they can not be used
 * on the right side of a match operation. Most built-in values will also 
 * implement {@link Pattern}.
 *
 * <code>this.eqFor(x)</code> ↔ <em>this == x</em>
 */
public interface Value
    {
        
        boolean eq(Object o);

        boolean eq(Atom o);
        
        boolean eq(Tagged o);

        boolean eq(Product o);
        
        boolean eq(Union o);

        boolean eq(Set o);

        boolean eq(Intersection o);

        boolean eq(Type o);
        
        boolean eq(Arrow o);

        boolean eqFor(Value o);
        
        boolean matchFor(Pattern p);
    }
