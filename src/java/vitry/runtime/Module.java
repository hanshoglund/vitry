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

import vitry.runtime.struct.Seq;

/**
 * Implements run-time modules.
 *
 * @author Hans Höglund
 */
public class Module implements Scope
    {
                     
        private Seq<Symbol> name;

        private final Env<Symbol, Object> values;

        private Env<Symbol, Type> types;

        private Env<Symbol, Fixity> fixities;

        public Module(Env<Symbol, Object> env) {
            this.values = env;
        }

        public Env<Symbol, Object> getEnvironment() {
            return values;
        }


        // TODO implicit env
        // TODO type env
    }
