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

import java.io.Serializable;


/**
 * A standard environment, defined as a set of bindings along with a reference to another 
 * parent environment.
 * 
 * Invariants:    
 *
 *   - {@link #parent} is referentially transparent
 *   - if this {@link #isPersistent}, then {@link #lookup} is referentially transparent
 */
public interface Env<K, V> extends Serializable
    {
        
        /**
         * Lookup the given binding in this environment.
         * @throws UndefinedError
         */
        V lookup(K key) throws UndefinedError;

        /**
         * Return the parent environment or <code>null</code>.
         * @return
         */
        Env<K, V> parent();
                        
        /**
         * Return whether this environment is persistent or not.
         */
        boolean isPersistent();                   
                                                                
        /**
         * Make a new definition in this environment and return a
         * modified environment (optional).
         */
        Env<K, V> define(K key, V val) throws BindingError;
    }