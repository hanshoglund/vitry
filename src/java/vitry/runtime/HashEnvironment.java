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

import java.util.HashMap;


/**
 * A basic non-persistent environment.
 */
public class HashEnvironment<K, V> extends AbstractEnvironment<K, V>
    {
        private final HashMap<K, V> bindings = new HashMap<K, V>();

        
        public HashEnvironment() {
        }

        public HashEnvironment(Environment<K, V> env) {
            super(env);
        }

        public Environment<K, V> define(K key, V val) throws BindingError {
            if (this.contains(key)) throw new BindingError(key, this);
            bindings.put(key, val);
            return this;
        }
        
        public Environment<K, V> extend(K key, V val) {
            return makeChild().define(key, val);
        }

        public Environment<K, V> makeChild() {
            return new HashEnvironment<K, V>(this);
        }

        public V get(K key) {
            return bindings.get(key);
        }

        public boolean contains(K key) {
            return bindings.containsKey(key);
        }

        public boolean isPersistent() {
            return false;
        }

    }
