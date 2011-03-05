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

import vitry.runtime.error.InvocationError;
import vitry.runtime.struct.Seq;


/**
 * Wrapper for host objects. It is not necessary to wrap objects to
 * simply expose them, but it is necessary in order to include them in
 * patterns.
 *
 * Wrapping mutable objects is not recommended.
 *
 * @author Hans Hoglund
 */
public final class Native extends Atom
{
    final Object obj;

    private Native(Object obj) {
        this.obj = obj;
    }

    @Override
    public boolean eq(Object o)
    {
        return obj.equals(o);
    }

    @Override
    public boolean eq(Atom o)
    {
        if (o instanceof Native)
        {
            return obj.equals( ((Native) o).obj);
        }
        return false;
    }

    @Override
    public boolean match(Object o)
    {
        return eq(o);
    }

    @Override
    public boolean match(Atom o)
    {
        return eq(o);
    }


    // TODO tagged

    public int hashCode()
    {
        return obj.hashCode();
    }

    public String toString()
    {
        return obj.toString();
    }

    /**
     * Returns the given object iff it is a pattern, or a Native instance
     * wrapping it otherwise.
     */
    public static Pattern wrap(Object o)
    {
        if (o == null) return VitryRuntime.NIL;
        if (o instanceof Pattern)
            return (Pattern) o;
        else
            return new Native(o);
    }

    public static Object unwrap(Object o)
    {
        if (o instanceof Native)
            return ((Native) o).obj;
        else
            return o;
    }

    public static Seq<Pattern> wrap(Seq<?> values)
    {
        return values.map(new StandardFunction.Unary()
            {
                public Object apply(Object v) throws InvocationError
                {
                    return wrap(v);
                }
            });
    }

    public static Seq<Object> unwrap(Seq<?> values)
    {
        return values.map(new StandardFunction.Unary()
            {
                public Object apply(Object v) throws InvocationError
                {
                    return unwrap(v);
                }
            });
    }

}
