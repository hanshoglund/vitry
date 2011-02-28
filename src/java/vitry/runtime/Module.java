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
import vitry.runtime.struct.Seqs;

/**
 * Implements run-time modules.
 *
 * @author Hans Höglund
 */
public class Module implements Scope
    {
                     
        private final Seq<Symbol> name;
        private Env<Symbol, Object> values;
        private Env<Symbol, Type> types;
        private Env<Symbol, Fixity> fixities;
        
                
        public Module(Seq<Symbol> name) {
            this.name = name;
        }
        
        public Module(Seq<Symbol> name, Env<Symbol, Object> values, Env<Symbol, Type> types,
                Env<Symbol, Fixity> fixities) {
            this.name = name;
            this.values = values;
            this.types = types;
            this.fixities = fixities;
        }

        public Env<Symbol, Object> getValues() {
            return values;
        }
        
        public Object getValue(String name) {
            return getValue(Symbol.intern(name));
        }
        public Object getValue(Symbol name) {
            return values.lookup(name);
        }

        public Env<Symbol, Type> getTypes() {
            return types;
        }

        public Env<Symbol, Fixity> getFixities() {
            return fixities;
        }

        public Seq<Symbol> getName() {
            return name;
        }

        public void setValues(Env<Symbol, Object> values) {
            this.values = values;
        }

        public void setTypes(Env<Symbol, Type> types) {
            this.types = types;
        }

        public void setFixities(Env<Symbol, Fixity> fixities) {
            this.fixities = fixities;
        }
        
        

    }
