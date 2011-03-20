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

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

import vitry.runtime.struct.MappedSeq;
import vitry.runtime.struct.Seq;


/**
 * A set of host values, defined by a class or interface. 
 *
 * Matches wrapped and nonwrapped host objects that are instaces of some
 * host type. Subclasses behave as expected. 
 *
 * Does not work for other Pattern instances other than Native.
 *
 * @author Hans Hoglund
 */
public final class NativeSet extends InclusionPattern implements Set
{

    private static final Map<Class<?>, Set> instances = new WeakHashMap<Class<?>, Set>();
    private final Class<?> hostClass;


    private NativeSet(Class<?> javaClass) {
        this.hostClass = javaClass;
    }

    public static Set forClass(Class<?> javaClass)
    {
        Set obj = instances.get(javaClass);
        if (obj == null)
        {
            obj = new NativeSet(javaClass);
            instances.put(javaClass, obj);
        }
        return obj;
    }


    public Pattern union(Set b)
    {
        return VitryRuntime.unionOf(this, b);
    }

    public Pattern intersection(Set b)
    {
        return VitryRuntime.intersectionOf(this, b);
    }


    // Eq and match


    public boolean eq(Set o)
    {
        if (o == this)
            return true;
        if (o instanceof NativeSet)
            return ((NativeSet) o).hostClass == this.hostClass;
        return false;
    }

    public boolean match(Object o)
    {
        return hostClass.isAssignableFrom(o.getClass());
    }

    public boolean match(Atom o)
    {
        if (o instanceof Native)
            return hostClass.isInstance( ((Native) o).obj);
        return false;
    }

    public boolean match(Set a)
    {
        // iff a <: this
        if (a instanceof NativeSet)
            return this.hostClass.isAssignableFrom( ((NativeSet) a).hostClass);
        return false;
    }

    public boolean eq(Product o)
    {
        return false;
    }

    public boolean eq(Tagged o)
    {
        // ?
        return false;
    }

    public boolean eqFor(Pattern o)
    {
        return o.eq(this);
    }

    public boolean matchFor(Pattern p)
    {
        return p.match(this);
    }


    // Throw on enumeration

    // TODO implement this using an interface EnumerableNativeType + registration?

    public Pattern head()
    {
        return throwEnumeration();
    }

    public Seq<Pattern> tail()
    {
        return throwEnumeration();
    }

    public Iterator<Pattern> iterator()
    {
        return throwEnumeration();
    }

    public Seq<Pattern> cons(Pattern head)
    {
        return throwEnumeration();
    }

    public <U> MappedSeq<Pattern, U> map(Function fn)
    {
        return throwEnumeration();
    }

    private <T> T throwEnumeration()
    {
        throw new UnsupportedOperationException("Can not enumerate a native type");
    }
    
    public boolean isNil()
    {
        return false;
    }    

    public boolean hasTail()
    {
        return false;
    }

    public String toString()
    {
//        if (hostClass.equals(BigInteger.class))
//            return "... -1 | 0 | 1 ...";
//        if (hostClass.equals(BigRational.class))
//            return "int / nat";
//        if (hostClass.equals(Float.class))
//            return "-Inf ... 0.0 ... Inf";
//        if (hostClass.equals(Double.class))
//            return "-Inf ... 0.0 ... Inf";
        if (hostClass.equals(BigInteger.class))
            return "int";
        if (hostClass.equals(BigRational.class))
            return "rat";
        if (hostClass.equals(Float.class))
            return "float";
        if (hostClass.equals(Double.class))
            return "double";
        if (hostClass.equals(String.class))
            return "[char]";
        if (hostClass.equals(Character.class))
            return "char";
        return hostClass.getName();
    }


}
