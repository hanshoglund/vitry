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

import vitry.runtime.Function;


/**
 * An immutable sequence of values. Seqs may be thunks; methods forcing evaluation
 * are explicitly marked in this interface.
 *
 * Because of lazy evaluation, nil may be represented either by null, or by an
 * instance of Seq. Check using Seqs.isNil().
 * 
 * @author Hans Hoglund
 */
public interface Seq<T> extends Iterable<T>
{
    /**
     * Returns the head of this seq. 
     * Forces evaluation of this.
     * 
     * @throws TypeError if this is nil.
     */
    T head();

    /**
     * Returns the tail of this seq. 
     * Forces evaluation of this.
     * 
     * @throws TypeError if this is nil.
     */
    Seq<T> tail();

    /**
     * Whether this seq represents nil or not. 
     * Forces evaluation of this.
     *
     * Should not be called directly, use Seqs.isNil instead.
     */
    boolean isNil();

    /**
     * Whether the tail of this seq represents nil or not. Implies !isNil.
     * 
     * Forces evaluation of this.
     */
    boolean hasTail();

    /**
     * Returns a new seq that is the result of consing the given value 
     * onto this seq. Not forcing.
     */
    Seq<T> prepend(T head);

    /**
     * Returns a new seq that is the result of mapping the given function 
     * against this seq. Not forcing.
     */
    <U> Seq<U> map(Function fn);


    SeqIterator<T> seqIterator();
}
