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
 * Standard environment, i.e. a set of bindings referencing an enclosing 
 * parent environment.
 * 
 * Invariants:    
 *
 *   - parent is referentially transparent
 *   - if isPersistent holds, then lookup is referentially transparent
 */
public interface Environment<K, V>
    {
        Environment<K, V> define(K key, V val) throws BindingError;

        Environment<K, V> extend(K key, V val);

        Environment<K, V> makeChild();

        Environment<K, V> parent();

        boolean isPersistent();

        V lookup(K key) throws UndefinedError;

        boolean contains(K key);

        V get(K key);
    }