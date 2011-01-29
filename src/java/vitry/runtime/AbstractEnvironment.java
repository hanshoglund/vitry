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
 * Base environment.
 *
 * Implement:          
 *
 *   - Provide put/get/isPersistent
 *   - (opt) Provide empty and (Env parent) constructors
 */
abstract class AbstractEnvironment<K, V> implements Environment<K, V>
    {      
        
        private final Environment<K, V> parent;
        

        /**
         * Creates a top-level environment.
         */
        public AbstractEnvironment() {
            this.parent = AbstractEnvironment.<K, V> empty();
        }

        /**
         * Create an environment that is a child of the given environment.
         */
        public AbstractEnvironment(Environment<K, V> parent) {
            this.parent = parent;
        }

        public Environment<K, V> parent() {
            return parent;
        }


        public Environment<K, V> define(K key, V val) throws BindingError {
            if (contains(key)) { 
                throw new BindingError(key, this);
            }
            return put(key, val);
        }

        public V lookup(K key) throws UndefinedError {
            V val = get(key);

            if (val == null) {
                Environment<K, V> checkEnv = this;

                try {
                    do {
                        checkEnv = checkEnv.parent();
                        if (val instanceof AbstractEnvironment) {
                            // In case we have an AbstractEnv, check locally
                            // Either we succeed, or search is continued in parent
                            val = ((AbstractEnvironment<K,V>) checkEnv).get(key);                            
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
        
        /**
         * Bind the given key to the given value in this env. 
         */
        abstract protected Environment<K, V> put(K key, V val);
                                                                 
        /**
         * Returns the value bound to the given key in this env or 
         * null if no such binding exists. 
         */
        abstract protected V get(K key);
                      
        /**
         * Returns whether this env contains the given key or not.
         */
        protected boolean contains(K key) {
            return get(key) != null;
        }
        
        

        
        // Empty
        
        @SuppressWarnings("unchecked")

        /**
         * Returns an empty, persistent environment.
         */
        public static <K, V> Environment<K, V> empty() {
            return (Environment<K, V>) empty;
        }

        private static Environment<?, ?> empty = new Empty();
        

        static class Empty extends AbstractEnvironment<Object, Object>
            {
                Empty() {}

                public Environment<Object, Object> define(Object key, Object val) {
                    return throwUnsupported();
                }

                public Environment<Object, Object> parent() {
                    return throwUnsupported();
                }

                protected Environment<Object, Object> put(Object key, Object val) {
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
