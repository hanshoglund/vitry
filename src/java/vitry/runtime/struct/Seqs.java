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
import vitry.runtime.Native;
import vitry.runtime.misc.Utils;


/**
 * Sequence operations used by runtime.
 */
public final class Seqs
{

    private static final Object[] EMPTY_ARRAY = new Object[0];

    private Seqs() {}


    public static boolean isNil(Object xs)
    {
        if (xs == null) return true;
        if (xs instanceof Seq)
        {
            return ((Seq<?>) xs).isNil();
        }
        else return false;
    }


    public static <T> Seq<T> single(T x)
    {
        return cons(x, null);
    }

    public static <T> Seq<T> cons(T x, Seq<T> xs)
    {
        if (isNil(xs))
            return new Single<T>(x);
        else
            return xs.cons(x);
    }

    public static <T> Seq<T> from(T... a)
    {
        if (a.length == 0)
            return null;
        else
            return new ArraySeq<T>(a);
    }

    public static <T> Seq<T> from(Iterable<T> a)
    {
        if (!a.iterator().hasNext())
            return null;
        else
            return new IterableSeq<T>(a);
    }

    public static <T> T head(Seq<T> xs)
    {
        return xs.head();
    }

    public static <T> Seq<T> tail(Seq<T> xs)
    {
        return xs.tail();
    }

    public static <T> T last(Seq<T> xs)
    {
        while (!isNil(xs.tail()))
        {
            xs = tail(xs);
        }
        T r = xs.head();
        return r;
    }

    public static <T> Seq<T> init(Seq<T> xs)
    {
        if (isNil(xs.tail()))
        {
            return null;
        }
        else
        {
            return cons(head(xs), init(tail(xs)));
        }
    }

    public static <T> Seq<T> untilElement(Seq<T> xs, T y)
    {
        if (isNil(xs) || xs.head().equals(y))
            return null;
        else
            return cons(head(xs), untilElement(tail(xs), y));
    }


    public static int length(Finite<?> xs) {
        return xs.length();        
    }
    
    public static int length(Seq<?> xs)
    {
        int length = 0;
        do
        {
            length++;
            xs = xs.tail();
        } while (!isNil(xs));
        return length;
    }

    public static <T> T first(Seq<T> xs)
    {
        return xs.head();
    }

    public static <T> T second(Seq<T> xs)
    {
        return xs.tail().head();
    }

    public static <T> T third(Seq<T> xs)
    {
        return xs.tail().tail().head();
    }

    public static <T> T nth(Seq<T> xs, int n)
    {
        for (int i = 0; i < n; i++)
            xs = tail(xs);
        return xs.head();
    }

    public static <U, T> U foldl(Function f, U z, Seq<T> xs)
    {
        U res = z;
        while (!isNil(xs))
        {
            res = Utils.<U> unsafe(f.apply(res, xs.head()));
            xs = xs.tail();
        }
        return res;
    }

    public static <U, T> U foldr(Function f, U z, Seq<T> xs)
    {
        U res = z;
        xs = eagerlyReverse(xs);
        while (!isNil(xs))
        {
            res = Utils.<U> unsafe(f.apply(xs.head(), res));
            xs = xs.tail();
        }
        return res;
    }
    
    public static <U, T> U foldlUnwrap(Function f, U z, Seq<T> xs)
    {
        U res = z;
        while (!isNil(xs))
        {
            res = Utils.<U> unsafe(f.apply(res, Native.unwrap(xs.head())));
            xs = xs.tail();
        }
        return res;
    }

    public static <U, T> U foldrUnwrap(Function f, U z, Seq<T> xs)
    {
        U res = z;
        xs = eagerlyReverse(xs);
        while (!isNil(xs))
        {
            res = Utils.<U> unsafe(f.apply(Native.unwrap(xs.head()), res));
            xs = xs.tail();
        }
        return res;
    }

    public static <T> Seq<T> concat(Seq<T> xs, Seq<T> ys)
    {
        if (isNil(xs)) return ys;
        return new ConcedSeq<T>(xs, ys);
    }


    private static <T> Seq<T> eagerlyReverse(Seq<T> xs)
    {
        Seq<T> ys = null;
        while (!isNil(xs)) {
            ys = cons(xs.head(), ys);
            xs = xs.tail();
        }
        return ys;
    }
    
    
    
    // Utils
    
    public static <T> Seq<T> printable(Seq<T> s)
    {
        return new PrintableSeq<T>(s);
    }

    public static <T> SeqIterator<T> iterate(Seq<T> s)
    {
        return new SeqIterator<T>(s);
    }

    public static Object[] toArray(Seq<?> s)
    {
        if (isNil(s))
            return EMPTY_ARRAY;

        Object[] a;
        if (s instanceof Finite)
            a = new Object[ ((Finite<?>) s).length()];
        else
            a = new Object[length(s)];

        int i = 0;
        do
        {
            a[i++] = s.head();
            s = s.tail();
        } while (!isNil(s));
        return a;
    }

    public static <T> T[] toArray(Seq<T> s, T[] dummy)
    {
        java.util.List<T> l = new java.util.LinkedList<T>();
        if (isNil(s))
            return l.toArray(dummy);
        do
        {
            l.add(s.head());
            s = tail(s);
        } while (!isNil(s));
        return l.toArray(dummy);
    }
}


class Single<T> extends AbstractSeq<T> implements Finite<T>
{
    private final T obj;

    public Single(T obj) {
        this.obj = obj;
    }

    public T head()
    {
        return obj;
    }

    public Seq<T> tail()
    {
        return null;
    }

    public int length()
    {
        return 1;
    }

    public boolean hasTail()
    {
        return false;
    }
}

class ConcedSeq<T> extends AbstractSeq<T>
{
    final Seq<T> xs; // Always non-nil
    final Seq<T> ys;
    
    ConcedSeq(Seq<T> xs, Seq<T> ys) {
        this.xs = xs;
        this.ys = ys;
    }

    public T head()
    {
        return xs.head();
    }

    public Seq<T> tail()
    {
        return Seqs.concat(xs.tail(), ys);
    }

    public boolean hasTail()
    {
        return !Seqs.isNil(ys) || !Seqs.isNil(xs.tail());
    }
}
