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


public class MemoizedSeq<T> extends AbstractSeq<T>
{
    private static final int HEADED = 1;
    private static final int TAILED = 2;
    private static final int FINISHED = 3;

    private int state = 0;
    private Seq<T> ys;
    private T x;
    private Seq<T> xs;

    public MemoizedSeq(Seq<T> s) {
        this.ys = s;
    }

    public T head()
    {
        if ( (this.state & HEADED) != HEADED)
        {
            this.x = ys.head();
            this.state |= HEADED;
            maybeFinish();
        }
        return this.x;
    }

    public Seq<T> tail()
    {
        if ( (this.state & TAILED) != TAILED)
        {
            if (ys.hasTail())
            {
                this.xs = new MemoizedSeq<T>(ys.tail());
            }
            else
            {
                this.xs = null;
            }
            this.state |= TAILED;
            maybeFinish();
        }
        return this.xs;
    }

    public boolean hasTail()
    {
        if ( (this.state & TAILED) == TAILED)
        {
            return !Seqs.isNil(this.xs);
        }
        else
        {
            return ys.hasTail();
        }
    }

    private void maybeFinish()
    {
        if (this.state == FINISHED)
        {
            this.ys = null;
        }
    }
}
