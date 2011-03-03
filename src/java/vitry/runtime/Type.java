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
import vitry.runtime.misc.Utils;
import vitry.runtime.struct.Seq;


public class Type extends BasePattern implements TypeExpr
{

    private final Pattern pattern;
    private final Symbol name;
    private final Seq<TypeExpr> vars;

    public Type(Pattern pattern, Symbol id, Seq<TypeExpr> vars) {
        this.pattern = pattern;
        this.name = id;
        this.vars = vars;
    }


    public Pattern getPattern()
    {
        return pattern;
    }

    public Symbol getName()
    {
        return name;
    }

    Seq<TypeExpr> getTypeVariables()
    {
        return vars;
    }

    public Tagged tag(Pattern value) throws TypeError
    {
        if (value instanceof Tagged)
            return ((Tagged) value).retag(this);

        if (value.matchFor(this))
        {
            // TODO memoize to speed up equality checks
            return new Tagged(value, this);
        }
        else
        {
            throw new TypeError(this, value);
        }
    }

    // Eq and match      

    public boolean eq(Type o)
    {
        return (o == this || (o.pattern.eqFor(this.pattern) && o.name.eqFor(this.name) && o.vars
                .equals(this.vars))); // TODO seq equality?
    }

    public boolean match(Tagged p)
    {
        return p.getTag() == this;
    }

    public boolean match(Type p)
    {
        return p.pattern.matchFor(this.pattern); // TODO correct ?
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