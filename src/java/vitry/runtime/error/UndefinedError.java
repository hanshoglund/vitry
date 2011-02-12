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
package vitry.runtime.error;

import vitry.runtime.Environment;

/**
 * Thrown to indicate failed lookup of some binding.
 */
public class UndefinedError extends BindingError
    {
        private Object key;

        private Environment<?,?> env;

        public UndefinedError(Object key, Environment<?, ?> env) {
            super("Could not find key '" + key + "' in " + env);
            this.key = key;
            this.env = env;
        }

        public Object getKey() {
            return key;
        }

        public Environment<?,?> getEnv() {
            return env;
        }

        public static long getSerialversionuid() {
            return serialVersionUID;
        }


        private static final long serialVersionUID = -8154071457798846190L;
    }
