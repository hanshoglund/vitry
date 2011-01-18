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
 * Base implementation.
 *
 * Implement:
 *   - Provide store/fetch/isPersistent
 *   - (opt) Provide empty and (Env parent) constructors
 */
abstract class AbstractEnv<K, V> implements Env<K, V>
    {

        public Env<K, V> define(K key, V val) throws BindingException {
            if (get(key) != null) throw new BindingException(key, this);
            return put(key, val);
        }

        public V lookup(K key) throws UndefinedException {
            V val = get(key);

            if (val == null) {
                Env<K, V> env = this;
                try {
                    do {
                        env = env.parent();
                        val = env.get(key);
                    } while (val == null);
                } catch (LookupFailedException e) {
                    throw new UndefinedException(key, this);
                }
            }
            return val;
        }

        abstract protected Env<K, V> put(K key, V val);


        @SuppressWarnings("unchecked")
        // Safe as the we never return values
        public static <K, V> Env<K, V> getEmpty() {
            if (empty == null) empty = new EmptyEnv();
            return (Env<K, V>) empty;
        }


        public static boolean isEmpty(Env<?, ?> env) {
            return env == getEmpty();
        }


        private static Env<?, ?> empty;

        private static final long serialVersionUID = 8402893922379900923L;
    }


class EmptyEnv extends AbstractEnv<Object, Object>
    {
        EmptyEnv() {
        }

        public Env<Object, Object> define(Object key, Object val) {
            throw new UnsupportedOperationException();
        }

        public Env<Object, Object> parent() {
            throw new UnsupportedOperationException();
        }

        protected Env<Object, Object> put(Object key, Object val) {
            throw new UnsupportedOperationException();
        }

        public Object lookup(Object key) {
            throw new UnsupportedOperationException();
        }

        public Object get(Object key) {
            throw new LookupFailedException();
        }

        private static final long serialVersionUID = 4460929197701994252L;

        public boolean isPersistent() {
            return true;
        }
    }


/**
 * Thrown by the empty environment to signal failed lookup.
 */
class LookupFailedException extends RuntimeException
    {
        private static final long serialVersionUID = -6163913997642410031L;
    }
