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

import static vitry.runtime.VitryRuntime.*;

import java.io.IOException;

import vitry.runtime.misc.Utils;
import vitry.runtime.struct.Seq;
import vitry.runtime.struct.Seqs;


/**
 * Implements native lists.
 *
 * @author Hans Hoglund
 */
abstract class AbstractList extends ConstructionPattern implements List
{
    // Eq and match

    public boolean eq(Atom o)
    {
        return this.isNil() && ((Seq<?>) o).isNil();
    }

    public boolean eq(List o)
    {
        Seq<Pattern> left = o;
        Seq<Pattern> right = this;

        while (!Seqs.isNil(left) && !Seqs.isNil(right))
        {
            if (!left.head().eqFor(right.head()))
                return false;
            left = left.tail();
            right = right.tail();
        }
        return (Seqs.isNil(left) && Seqs.isNil(right));
    }
    

    public boolean match(Atom o)
    {
        return this.isNil() && ((Seq<?>) o).isNil();
    }

    public boolean match(List o)
    {
        if (!this.hasTail())
        {
            return matchPattern(o);
        }
        return matchStructure(o);
    }

    protected boolean matchPattern(List o)
    {
        Seq<Pattern> left = o;
        Pattern right = this.head();
        while (!Seqs.isNil(left))
        {
            if (!left.head().matchFor(right))
                return false;
            left = left.tail();
        }
        return true;
    }

    protected boolean matchStructure(List o)
    {
        Seq<Pattern> left = o;
        Seq<Pattern> right = this;

        while (!Seqs.isNil(left) && !Seqs.isNil(right))
        {
            if (!left.head().matchFor(right.head()))
                return false;
            left = left.tail();
            right = right.tail();
        }
        return (Seqs.isNil(left) && Seqs.isNil(right));
    }

    public boolean match(Intersection a)
    {
        for (Pattern x : a)
            if (x.matchFor(this))
                return true;
        return false;
    }

    public boolean eqFor(Pattern p)
    {
        return p.eq(this);
    }

    public boolean matchFor(Pattern p)
    {
        return p.match(this);
    }

    public List cons(Pattern head)
    {
        return listFrom(super.cons(head));
    }

    public List mapList(Function fn)
    {
        return listFrom(this.<Pattern> map(fn));
    }


    // Java stuff

    public boolean equals(Object o)
    {
        if (o == this)
            return true;
        if (o instanceof List)
            return eq((List) o);
        return false;
    }

    public int hashCode()
    {
        return Utils.hash(this.getClass().hashCode(), this);
    }

    public String toString()
    {
        return Utils.join(this, "[", ", ", "]");
    }

    public void toString(Appendable a) throws IOException
    {
        boolean first = true;
        a.append("[");
        
        for (Pattern e : this) {
            if (!first) {
                a.append(", ");
            }
            a.append(e.toString());
            first = false;
        }
        a.append("]");
    }
    
    
}
