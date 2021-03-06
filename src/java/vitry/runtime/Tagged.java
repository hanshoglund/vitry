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
import vitry.runtime.util.Utils;


/**
 * Implements tagged values.
 *
 * TODO do something special with Native/NativeSet etc etc to avoid double wrapping
 *
 * @author Hans Hoglund
 */
public class Tagged extends BasePattern implements Destructible
{
    private final Pattern val;

    private final Type tag;

    public Tagged(Pattern val, Type tag) {
        this.val = val;
        this.tag = tag;
    }

    public Pattern getValue()
    {
        return val;
    }

    public Type getTag()
    {
        return tag;
    }

    public Tagged retag(Type type)
    {
        return type.tag(val);
    }


    // Eq and match

    // TODO match all other forms properly

    public boolean eq(Tagged o)
    {
        return (this == o) || (tag.equals(o.tag) && (val.eqFor(o.val)));
    }

    public boolean match(Tagged o)
    {
        return (this == o) || (tag.equals(o.tag) && (val.eqFor(o.val)));
    }

    public boolean eqFor(Pattern o)
    {
        return o.eq(this);
    }

    public boolean matchFor(Pattern p)
    {
        return p.match(this);
    }

    public String toString()
    {
        return val.toString();
    }


    // Java stuff

    public boolean equals(Object o)
    {
        if (o instanceof Tagged)
            return ((Tagged) o).eq(this);
        return false;
    }

    public int hashCode()
    {
        int hash = this.getClass().hashCode();
        hash = Utils.hash(hash, val);
        hash = Utils.hash(hash, tag);
        return hash;
    }

    public boolean canDestruct()
    {
        return (val instanceof Destructible) && ((Destructible) val).canDestruct();
    }

    public Seq<Pattern> destruct()
    {
        return ((Destructible) val).destruct();
    }
}
