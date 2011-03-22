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

import vitry.runtime.misc.Utils;


/**
 * For debugging. Prints like a product.
 */
class PrintableSeq<T> extends AbstractSeq<T>
{
    private Seq<T> delegee;

    public PrintableSeq(Seq<T> delegee) {
        this.delegee = delegee;
    }

    public T head()
    {
        return delegee.head();
    }

    public boolean hasTail()
    {
        return delegee.hasTail();
    }

    public Seq<T> prepend(T head)
    {
        return delegee.prepend(head);
    }

    public Iterator<T> iterator()
    {
        return delegee.iterator();
    }

    public Seq<T> tail()
    {
        return delegee.tail();
    }

    public SeqIterator<T> seqIterator()
    {
        return delegee.seqIterator();
    }

    public String toString()
    {
return "[...]";
//        return Utils.join(this, "(", ", ", ")");
    }
}
