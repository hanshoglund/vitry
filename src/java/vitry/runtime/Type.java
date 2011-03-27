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

import vitry.runtime.error.TypeError;
import vitry.runtime.error.VitryError;
import vitry.runtime.struct.Seq;
import vitry.runtime.util.Utils;


/**
 * Runtime representation of a type.
 */
public class Type extends BasePattern implements TypeExpr
{

    private final Symbol name;
    private final Pattern pattern;
    private final Seq<TypeExpr> vars;

    public Type(Symbol name, Pattern pattern, Seq<TypeExpr> vars) {
        this.name = name;
        this.pattern = pattern;
        this.vars = vars;
    }

    public Symbol getName()
    {
        return name;
    }


    public Pattern getPattern()
    {
        return pattern;
    }

    Seq<TypeExpr> getTypeVariables()
    {
        return vars;
    }

    public Tagged tag(Pattern value) throws VitryError
    {
        if (value instanceof Tagged)
        {
            return ((Tagged) value).retag(this);            
        }

        if (value.matchFor(this))
        {
            return new Tagged(value, this);
        }
        else
        {
            return TypeError.throwFailedTagging(this, value);
        }
    }

    // Eq and match      

    public boolean eq(Type o)
    {
        return o == this || (o.pattern.eqFor(this.pattern));
        // TODO typevars?
    }

    public boolean match(Tagged p)
    {
        return p.getTag() == this;
    }

    public boolean match(Type p)
    {
        return this.eq(p);
    }

    public boolean eqFor(Pattern o)
    {
        return o.eq(this);
    }

    public boolean matchFor(Pattern p)
    {
        return p.match(this);
    }


    // Java stuff

    public String toString()
    {
        if (name != null)
            return name.toString();
        else
            return pattern.toString();
    }

    public int hashCode()
    {
        int hash = this.getClass().hashCode();
        hash = Utils.hash(hash, name);
        hash = Utils.hash(hash, pattern);
        hash = Utils.hash(hash, vars);
        return hash;
    }

}