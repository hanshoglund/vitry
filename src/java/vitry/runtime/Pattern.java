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
 * Provides matching semantics.
 * 
 * Implementations may be used on the right side of a match operation.
 *
 * Invariants:
 * 
 *   - this.match(x)    <=> x : this
 *   - this.matchFor(x) <=> this : x
 */
public interface Pattern extends Value
    {
        boolean match(Atom o);
        
        boolean match(Tagged<?> o);

        boolean match(Product p);

        boolean match(Union p);

        boolean match(Set p);

        boolean match(Intersection p);

        boolean match(Type p);

        boolean match(FunctionType p);
    }
