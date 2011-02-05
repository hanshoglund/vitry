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
 * Base environment. Implements non-stack consuming lookup.
 */
abstract public class AbstractEnvironment<K, V> implements Environment<K, V>
    {

        private final Environment<K, V> parent;
        private static Environment<?,?> global = new GlobalEnvironment();


        public AbstractEnvironment() {
            this.parent = AbstractEnvironment.<K, V> empty();
        }

        public AbstractEnvironment(Environment<K, V> parent) {
            this.parent = parent;
        }

        public Environment<K, V> getParent() {
            return parent;
        }

        public V lookup(K key) throws UndefinedError {
            Environment<K, V> env = this;
            V val = this.get(key);
            try {
                while (val == null) {
                    env = env.getParent();
                    val = env.get(key);
                }
            } catch (UndefinedError e) {
                throw new UndefinedError(key, this);
            }
            return val;
        }

        @SuppressWarnings("unchecked")
        private static <K, V> Environment<K, V> empty() {
            return (Environment<K, V>) global;
        }
    }

class GlobalEnvironment extends AbstractEnvironment<Object, Object> {

    public Environment<Object, Object> define(Object key, Object val) throws BindingError {
        return throwUnsupported();
    }

    public Environment<Object, Object> extend(Object key, Object val) {
        return throwUnsupported();
    }

    public Environment<Object, Object> extend() {
        return throwUnsupported();
    }

    public boolean isPersistent() {
        return true;
    }

    public boolean contains(Object key) {
        return false;
    }

    public Object get(Object key) {
        throw new UndefinedError(key, this);
    }

    private <T> T throwUnsupported() {
        throw new UnsupportedOperationException();
    }

        
}