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

import java.util.Iterator;

import vitry.runtime.struct.MapSeq;
import vitry.runtime.struct.Pair;
import vitry.runtime.struct.Seq;
import vitry.runtime.struct.SeqIterator;


abstract public class ConstructionPattern extends BasePattern
implements Seq<Pattern>, Destructible
{
    public Seq<Pattern> destruct()
    {
        return this;
    }

    public boolean canDestruct()
    {
        return true;
    }

    public Seq<Pattern> cons(Pattern head)
    {
        return new Pair<Pattern>(head, this);
    }

    public <U> Seq<U> map(Function fn)
    {
        return new MapSeq<Pattern, U>(fn, this);
    }

    public Iterator<Pattern> iterator()
    {
        return new SeqIterator<Pattern>(this);
    }

    public SeqIterator<Pattern> seqIterator()
    {
        return new SeqIterator<Pattern>(this);
    }
}
