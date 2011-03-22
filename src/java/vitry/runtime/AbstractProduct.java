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
import vitry.runtime.misc.Utils;
import vitry.runtime.struct.Seq;
import vitry.runtime.struct.Seqs;


/**
 * Base implementation, relying on a sequence.
 * 
 * For the reified block types, we have to override the sequence
 * methods to adapt traversal to the generated accessors.
 *
 * @author Hans Hoglund
 */
abstract class AbstractProduct extends ConstructionPattern implements Product
{
    public boolean eq(Product o)
    {
        if (o == this) return true;

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

    public boolean match(Product p)
    {
        Seq<Pattern> left = p;
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

    public Product prepend(Pattern head)
    {
        return productFrom(super.prepend(head));
    }

    public Product mapProduct(Function fn)
    {
        return productFrom(this.<Pattern> map(fn));
    }


    // Java stuff

    public boolean equals(Object o)
    {
        if (o == this)
            return true;
        if (o instanceof Product)
            return eq((Product) o);
        return false;
    }

    public int hashCode()
    {
        return Utils.hash(this.getClass().hashCode(), this);
    }

    public String toString()
    {
        return Utils.join(this, "(", ", ", ")");
    }
}