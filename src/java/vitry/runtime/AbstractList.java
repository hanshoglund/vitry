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

import static vitry.runtime.VitryRuntime.listFrom;

import java.io.IOException;

import vitry.Build;
import vitry.runtime.struct.Seq;
import vitry.runtime.struct.Seqs;
import vitry.runtime.struct.TakeSeq;
import vitry.runtime.util.Utils;


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
        return this.isNil() && Seqs.isNil(o);
    }

    public boolean eq(List o)
    {
        if (o == this)
            return true;

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
//        return this.isNil() && Seqs.isNil(o);
        if (Seqs.isNil(o))
        {
            return this.isNil() || (!this.hasTail());
        }
        return false;
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

    public List prepend(Pattern head)
    {
        return listFrom(super.prepend(head));
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
        StringBuilder sb = new StringBuilder();
        try
        {
            toString(sb);
        }
        catch (IOException e)
        {
            // It is a StringBuilder
        }
        return sb.toString();
    }
    
    public String toFiniteString()
    {
        StringBuilder sb = new StringBuilder();
        try
        {
            toFiniteString(sb);
        }
        catch (IOException e)
        {
        }
        return sb.toString();        
    }

    public void toString(Appendable a) throws IOException
    {
        a.append("[");
        appendAll(a, this);
        a.append("]");
    }

    public void toFiniteString(Appendable a) throws IOException
    {
        Seq<?> xs = new TakeSeq<Pattern>(this, Build.PRINT_SEQ_LIMIT);
        a.append("[");
        appendAll(a, xs);
        if (Seqs.length(xs) >= Build.PRINT_SEQ_LIMIT)
            a.append(", ...");
        a.append("]");        
    }

    protected void appendAll(Appendable a, Iterable<?> xs) throws IOException
    {
        boolean first = true;
        for (Object e : xs)
        {
            if (!first)
            {
                a.append(", ");
            }
            a.append(e.toString());
            first = false;
        }
    }


}
