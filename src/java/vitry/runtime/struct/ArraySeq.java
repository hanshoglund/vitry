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

import vitry.runtime.misc.ArrayIterator;


/**
 * Adapts an array as a sequence. Mutating the array is not recommended.
 * 
 * @author Hans Hoglund
 */
public class ArraySeq<T> extends AbstractSeq<T> implements Finite<T>
{
    private final T[] ar;
    private final int offset;
    private Seq<T>    tail;
    private boolean   tailed = false;

    public ArraySeq(T... elements) {
        this(elements, 0);
    }

    public ArraySeq(T[] elements, int offset) {
        if (offset >= elements.length)
            throw new IllegalArgumentException("Offset must be less than than length");
        this.ar = elements;
        this.offset = offset;
    }

    private ArraySeq(T[] elements, int offset, Object dummy) {
        this.ar = elements;
        this.offset = offset;
    }

    public Iterator<T> iterator()
    {
        return new ArrayIterator<T>(ar, offset);
    }

    public T head()
    {
        return ar[offset];
    }

    public Seq<T> tail()
    {
        if (!tailed)
        {
            if (hasTail())
            {
                tail = new ArraySeq<T>(ar, offset + 1, null);
            }
            tailed = true;
        }
        return tail;
    }

    public boolean hasTail()
    {
        return offset + 1 < ar.length;
    }

    public int length()
    {
        return ar.length - offset;
    }
}
