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
package vitry.runtime.struct;


/**
 * Lazily drops n elements.
 */
public class DropSeq<T> extends AbstractSeq<T>
{
    private Seq<T> xs;
    private int n;

    public DropSeq(Seq<T> xs, int n) {
        this.xs = xs;
        this.n = n;
    }

    public T head()
    {
        if (n > 0) drop();
        return xs.head();
    }

    public Seq<T> tail()
    {
        if (n > 0) drop();
        return xs.tail();
    }

    private void drop()
    {
        for (; n > 0; n--)
        {
            if (!Seqs.isNil(this.xs))
                this.xs = this.xs.tail();
        }
    }

    public boolean isNil()
    {
        if (n > 0) drop();
        return Seqs.isNil(this.xs);
    }


}
