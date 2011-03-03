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
import java.util.NoSuchElementException;


/**
 * A generic iterator over sequences.
 * 
 * This is the one returned by AbstractSequence, override if a more effiecient
 * implementation is available.
 */
public class SeqIterator<T> implements Iterator<T>
{
    /**
     * Current sequence, or null if we are finished. Updated for each pass.
     */
    protected Seq<T> seq;

    public SeqIterator(Seq<T> seq) {
        this.seq = seq;
    }

    public boolean hasNext()
    {
        return !Seqs.isNil(seq);
    }

    public T next()
    {
        if (Seqs.isNil(seq))
            throw new NoSuchElementException();

        T head = seq.head();
        seq = seq.tail();
        return head;
    }

    public void remove()
    {
        throw new UnsupportedOperationException("Can not modify a Sequence");
    }

    /**
     * Returns a sequence of all remaining elements (its head is the
     * first element returned by next etc).
     */
    public Seq<T> following()
    {
        return seq;
    }
}
