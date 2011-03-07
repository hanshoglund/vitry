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

import java.util.Iterator;

import vitry.runtime.Arity;
import vitry.runtime.Function;
import vitry.runtime.Native;
import vitry.runtime.misc.Checks;
import vitry.runtime.misc.Utils;


/**
 * A seq adapted from another seq by the map operation.
 *
 * The function is applied on head lookup, not tail.
 */
public class MappedSeq<A, B> extends AbstractSeq<B>
{
    private final Function f;
    private final Seq<A> xs;

    public MappedSeq(Function f, Seq<A> xs) {
        this.f = f;
        this.xs = xs;
    }

    public Iterator<B> iterator()
    {
        return new MapIterator<B>(f, xs.iterator());
    }

    public B head()
    {
        A head = xs.head();
        return Utils.<B> unsafe(f.apply(head));
    }

    public Seq<B> tail()
    {
        if (xs.hasTail())
        {
            return new MappedSeq<A, B>(f, xs.tail());
        }
        else
        {
            return null;
        }
    }

    public boolean hasTail()
    {
        return xs.hasTail();
    }
}


class MapIterator<T> implements Iterator<T>
{

    private Function fn;
    private Iterator<?> input;

    public MapIterator(Function fn, Iterator<?> input) {
        if (fn instanceof Arity)
            Checks.checkArity((Arity) fn, 1);
        this.fn = fn;
        this.input = input;
    }

    public boolean hasNext()
    {
        return input.hasNext();
    }

    public T next()
    {
        return Utils.<T> unsafe(fn.apply(input.next()));
    }

    public void remove()
    {
        throw new UnsupportedOperationException("Can not remove from a MapIterator");
    }

}