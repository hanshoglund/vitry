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

import vitry.runtime.error.*;

/**
 * A set of bindings possibly referencing an enclosing parent
 * environment.
 * 
 * This interface supports both persistent (immutable) and 
 * non-persistent (mutable) environments. For persistent environments
 * the define operation is indentical to extend and never throws an
 * exception. For non-persistent implementations define may be used
 * to add bindings, but not to override previous bindings. The assoc
 * operation is used to mutate non-persistent environments explicitly.
 *
 * @author Hans Höglund
 */
public interface Environment<K, V>
    {
        /**
         * Define the given key in this environment.
         * @return A modified environment, which is this if this is a 
         * non-persistent environment.
         * @throws BindingError If the given key already exists.
         */
        Environment<K, V> define(K key, V val) throws BindingError;

        /**
         * Returns an extension of this environment containing the given 
         * binding. Does not modify this environment.
         */
        Environment<K, V> extend(K key, V val);

        /**
         * Returns an extension of this environment.          
         */
        Environment<K, V> extend();
        
        /**
         * Update this environment to associate the given key with the given
         * value. Not supported by persistent environments.
         */
        Environment<K, V> assoc(K key, V val);
        
        /**
         * Returns the parent. Referentially transparent.
         */
        Environment<K, V> getParent();

        /**
         * Lookup the given key. Referentially transparent iff this is a
         * persistent environment.
         */
        V lookup(K key) throws UndefinedError;

        boolean isPersistent();

        /**
         * Returns the local binding for the given key, if any.
         */
        V getBinding(K key);

        /**
         * Returns whether a local binding exists for the given key.
         */
        boolean hasBinding(K key);
    }