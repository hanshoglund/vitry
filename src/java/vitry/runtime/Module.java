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
import vitry.runtime.util.Strings;


/**
 * Implements run-time modules.
 * 
 * TODO import/export
 * TODO implicits
 *
 * @author Hans Hoglund
 */
public class Module implements Scope, Compilable
{

    final Seq<Symbol> name;
    final Rec<Symbol, Object> values = new HashRec<Symbol, Object>();
    final Rec<Symbol, Type> types = new HashRec<Symbol, Type>();
    final Rec<Symbol, Fixity> fixities = new HashRec<Symbol, Fixity>();


    public Module(Seq<Symbol> name) {
        this.name = name;
    }

    public boolean isCompiled()
    {
        return true;
    }

    public Seq<Symbol> getName()
    {
        return name;
    }

    public Object getValue(String name)
    {
        return getValue(Symbol.intern(name));
    }

    public Object getValue(Symbol name)
    {
        return values.lookup(name);
    }

    public Rec<Symbol, Object> getValues()
    {
        return values;
    }

    public Rec<Symbol, Type> getTypes()
    {
        return types;
    }

    public Rec<Symbol, Fixity> getFixities()
    {
        return fixities;
    }

    void addValue(Symbol name, Object value)
    {
        values.define(name, value);
    }

    void addFixity(String name, Fixity fix)
    {
        fixities.define(Symbol.intern(name), fix);
    }
    
    void addFixity(Symbol name, Fixity fix)
    {
        fixities.define(name, fix);
    }
    
    void def(String name, Object value)
    {
        values.define(Symbol.intern(name), value);
    }

    void defFix(String name, int precedence, boolean assoc, boolean gathering) {
        addFixity(name, new Fixity(precedence, assoc, gathering));
    }


    void importModule(Module source)
    {
        for (Symbol name : source.getValues().getKeys())
        {
            importValue(source, name, name);            
        }
        for (Symbol name : source.getFixities().getKeys())
        {
            importFixity(source, name);            
        }
    }

    void importValue(Module source, Symbol name, Symbol as)
    {
        addValue(as, source.getValue(name));
    }
    
    void importFixity(Module source, Symbol name)
    {
        addFixity(name, source.getFixities().lookup(name));
    }

    public String toString()
    {
        return Strings.join(name, "", ".", "");
    }


}
