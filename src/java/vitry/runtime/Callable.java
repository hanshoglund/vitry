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
 * Base class for callable entities.
 */
abstract public class Callable extends Atom
    {
        /**
         * Creates a top-level callable entity (a module or a compiled
         * function).
         */
        public Callable() {
            this.env = new HashEnv<Symbol, Object>();
        }

        /**
         * Creates a nested callable entity.
         */
        public Callable(Callable parent) {
            this.env = new HashEnv<Symbol, Object>(parent.env());
        }

        final Env<Symbol, Object> env;

        public Env<Symbol, Object> env() {
            return env;
        }
    }
