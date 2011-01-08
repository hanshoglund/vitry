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
package vitry.primitive;

import java.io.Serializable;


/**
 * A scopable set of bindings. Typically are used to hold non-local variable
 * bindings.
 * 
 * Implementions should specify whether they are persistent or not.
 * 
 * Invariants:
 * 
 *   - {@link #lookup} and {@link #parent}parent are referentially transparent
 *  
 */
public interface Env<K, V> extends Serializable
    {
        /**
         * Checks parent environments and throws exception as needed,
         * normal return implies a valid binding.
         * @throws UndefinedException
         */
        V lookup(K key) throws UndefinedException;

        /**
         * Return the parent environment or null.
         */
        Env<K, V> parent();

        /**
         * Define a key in this environment. Returns a modified environment
         * which may be this.
         * @return The resulting environment.
         * @throws BindingException If the given value is already defined.
         */
        Env<K, V> define(K key, V val) throws BindingException;

        /**
         * Returns local binding or null.
         */
        V localValue(K key);
    }