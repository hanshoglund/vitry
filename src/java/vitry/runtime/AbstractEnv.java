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
 * Base implementation, providing lookup.
 *
 * Implement:          
 *
 *   - Provide put/get/isPersistent
 *   - (opt) Provide empty and (Env parent) constructors
 */
abstract class AbstractEnv<K, V> implements Env<K, V>
    {      
        
        private final Env<K, V> parent;
        

        /**
         * Creates a top-level environment.
         */
        public AbstractEnv() {
            this.parent = AbstractEnv.<K, V> empty();
        }

        /**
         * Create an environment that is a child of the given environment.
         */
        public AbstractEnv(Env<K, V> parent) {
            this.parent = parent;
        }

        public Env<K, V> parent() {
            return parent;
        }


        public Env<K, V> define(K key, V val) throws BindingError {
            if (contains(key)) { 
                throw new BindingError(key, this);
            }
            return put(key, val);
        }

        public V lookup(K key) throws UndefinedError {
            V val = get(key);

            if (val == null) {
                Env<K, V> checkEnv = this;

                try {
                    do {
                        checkEnv = checkEnv.parent();
                        if (val instanceof AbstractEnv) {
                            // In case we have an AbstractEnv, check locally
                            // Either we succeed, or search is continued in parent
                            val = ((AbstractEnv<K,V>) checkEnv).get(key);                            
                        } else {
                            // Otherwise, eat stack
                            // Either we succeed, or we exit by exception
                            val = checkEnv.lookup(key);
                        }
                    } while (val == null);

                } catch (UndefinedError e) {
                    throw new UndefinedError(key, this);
                }
            }
            return val;
        }
        
        abstract protected Env<K, V> put(K key, V val);
        
        abstract protected V get(K key);
        
        protected boolean contains(K key) {
            return get(key) != null;
        }
        
        

        
        // Empty
        
        @SuppressWarnings("unchecked")

        /**
         * Returns an empty, persistent environment.
         */
        public static <K, V> Env<K, V> empty() {
            return (Env<K, V>) empty;
        }

        private static Env<?, ?> empty = new Empty();
        

        static class Empty extends AbstractEnv<Object, Object>
            {
                Empty() {}

                public Env<Object, Object> define(Object key, Object val) {
                    return throwUnsupported();
                }

                public Env<Object, Object> parent() {
                    return throwUnsupported();
                }

                protected Env<Object, Object> put(Object key, Object val) {
                    return throwUnsupported();
                }

                public Object lookup(Object key) {
                    return throwUnsupported();
                }

                public Object get(Object key) {
                    throw new UndefinedError(key, this);
                }

                private <T> T throwUnsupported() {
                    throw new UnsupportedOperationException(
                            "Not supported for emtpy environment");
                }
                
                public boolean isPersistent() {
                    return true;
                }

                private static final long serialVersionUID = 4460929197701994252L;
            }

        private static final long serialVersionUID = 8402893922379900923L;

    }
