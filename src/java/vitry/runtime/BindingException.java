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
 * Thrown to indicate a problem related to a binding operation.
 */
public class BindingException extends RuntimeException
    {
        private Object key;

        private Object env;

        public BindingException(Object key, Env<?, ?> env) {
            super("Key " + key + " already defined in " + env);
            this.key = key;
            this.env = env;
        }

        BindingException(String string) {
            super(string);
        }

        public Object getKey() {
            return key;
        }


        public Object getEnv() {
            return env;
        }

        private static final long serialVersionUID = 472453313488024837L;
    }
