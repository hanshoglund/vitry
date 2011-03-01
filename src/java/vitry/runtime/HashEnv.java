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

import vitry.runtime.error.BindingError;
import vitry.runtime.struct.Seq;
import vitry.runtime.struct.Seqs;

/**
 * A basic non-persistent environment.
 *
 * @author Hans Höglund
 */
public class HashEnv<K, V> extends AbstractEnv<K, V>
    {
        protected final HashMap<K, V> bindings = new HashMap<K, V>();
        
        public HashEnv() {
            super();
        }

        public HashEnv(Env<K, V> env) {
            super(env);
        }

        public Env<K, V> define(K key, V val) throws BindingError {
            if (this.hasBinding(key)) throw new BindingError(key, this);
            bindings.put(key, val);
            return this;
        }
        
        public Env<K, V> extend(K key, V val) {
            return extend().define(key, val);
        }

        public Env<K, V> extend() {
            return new HashEnv<K, V>(this);
        }

        public V getBinding(K key) {
            return bindings.get(key);
        }

        public boolean hasBinding(K key) {
            return bindings.containsKey(key);
        }

        public boolean isPersistent() {
            return false;
        }

        public Env<K, V> assoc(K key, V val) {
            bindings.put(key, val);
            return this;
        }
    }
