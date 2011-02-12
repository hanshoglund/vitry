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

import static vitry.runtime.VitryRuntime.product;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Properties;

import vitry.prelude.*;
import vitry.runtime.error.UndefinedError;
import vitry.runtime.struct.*;


/**
 * Runtime system for the Vitry programming language.
 * 
 * @author Hans Höglund
 */
public final class VitryRuntime 
    {

        public static final Nil         NIL             = new Nil();
        public static final Bottom      BOTTOM          = new Bottom();
        public static final Any         ANY             = new Any();
        public static final Symbol      TRUE            = Symbol.intern("true");
        public static final Symbol      FALSE           = Symbol.intern("false");                                                        
        public static final Set         NAT             = NativeSet.forClass(BigInteger.class);
        public static final Set         INT             = NativeSet.forClass(BigInteger.class);
        public static final Set         RAT             = NativeSet.forClass(BigRational.class);
        public static final Set         FLOAT           = NativeSet.forClass(Float.class);
        public static final Set         DOUBLE          = NativeSet.forClass(Double.class);
        public static final Set         STR             = NativeSet.forClass(String.class); 
        // TODO boolean etc                                                                                
        static final int                MIN_ARITY       = 1;
        static final int                MAX_ARITY       = 0xf;

        
        // Prelude
        
        private static final Environment<Symbol, Object> prelude = new HashEnvironment<Symbol, Object>();
        private static final Environment<Symbol, Fixity> preludeFixities = new HashEnvironment<Symbol, Fixity>();

        static {
            def("()",                   NIL);
            def("[]",                   NIL);
            def("{}",                   BOTTOM);
            def("nil",                  NIL);
            def("eq",                   new eq());
            def("==",                   "eq");
            def("true",                 TRUE);
            def("false",                FALSE);
            def("int",                  INT);
            def("nat",                  NAT);
            def("rat",                  RAT);
            def("float",                FLOAT);
            def("double",               DOUBLE);
            def("str",                  STR);
            
            def("id",                   new id());
            def("const",                new const_());   
            def("product",              new product());   
            def("add",                  new add());
            def("sub",                  new sub());
            def("mul",                  new mul());
            def("div",                  new div());
            def("mod",                  new mod());
            def("modp",                 new modp());

            def("(+)",                  "add");
            def("(-)",                  "sub");
            def("(*)",                  "mul");
            def("(/)",                  "div");
            def("(%)",                  "mod");
            def("(%%)",                 "modp");
            def("(,)",                  "product");

            def("quit",                 new quit());
            def("arity",                new arity());

            
            defFix("(.)",               12, false, true );   // gathering?
            defFix("(^^)",              10, true,  false);
            defFix("(^)",               10, true,  false);
            defFix("(%)",               9,  true,  false);
            defFix("(%%)",              9,  true,  false);
            defFix("(/)",               9,  true,  false);
            defFix("(*)",               9,  true,  false);
            defFix("(-)",               8,  true,  false);
            defFix("(+)",               8,  true,  false);
            defFix("(<)",               6,  true,  false);
            defFix("(<=)",              6,  true,  false);
            defFix("(>=)",              6,  true,  false);
            defFix("(>)",               6,  true,  false);
            defFix("(/=)",              6,  true,  false);
            defFix("(==)",              6,  true,  false);
            defFix("[,]",               5,  true,  true);
            defFix("{,}",               5,  true,  true);
            defFix("(,)",               5,  true,  true);
            defFix("(|)",               4,  true,  false);  // assoc?
            defFix("(&)",               4,  true,  false);  // assoc?
            defFix("(->)",              3,  false, false);
            defFix("(&&)",              2,  false, false);
            defFix("(||)",              1,  false, false);
            defFix("($!)",              0,  true,  false);
            defFix("($)",               0,  false, false);
        }
        

        
        private final Properties  systemProperties;

        private ClassLoader classLoader;
        
        private Eval       interpreter;
        
        private BigInteger uniqueState = BigInteger.valueOf(0x2177375305f7L);
        
        
        public VitryRuntime
            (
            Properties systemProperties, 
            ClassLoader classLoader,
            Eval interpreter
            ) 
        {
            this.systemProperties = systemProperties;
            this.classLoader = classLoader;
            this.interpreter = interpreter;
        }

        
        
        
        // Static accessors
        

        public Properties getSystemProperties() {
            return systemProperties;
        }

        public ClassLoader getClassLoader() {
            return classLoader;
        }

        public Eval getInterpreter() {
            return interpreter;
        }

        public BigInteger getUniqueState() {
            return uniqueState;
        }

        public void setClassLoader(ClassLoader classLoader) {
            this.classLoader = classLoader;
        }

        public void setInterpreter(Eval interpreter) {
            this.interpreter = interpreter;
        }

        public static Environment<Symbol, Object> getPrelude() {
            return prelude;
        }
        
        public static Environment<Symbol, Fixity> getPreludeFixities() {
            return preludeFixities;
        }



        
        // Prelude accessors
        
        public static Environment<Symbol, Object> newTopLevelEnvironment() {
            return prelude.extend();
        }
        
        public Object getPreludeValue(Symbol key) throws UndefinedError {
            return prelude.lookup(key);
        }
        
        public static Object getPreludeValue(String key) throws UndefinedError {
            return prelude.lookup(Symbol.intern(key));
        }
        
        
        
        
        
        
        // General construction and conversion
        
        
        public static Product product(Sequence<Pattern> s) {
            if (s instanceof Product) return (Product) s;
            return new ForwardingProduct(s);
        }

        public static Set set(Sequence<Pattern> s) {
            if (s instanceof Set) return (Set) s;
            return new ForwardingSet(s);
        }

        public static Union union(Sequence<Pattern> s) {
            if (s instanceof Union) return (Union) s;
            return new ForwardingUnion(s);
        }

        public static Intersection intersection(Sequence<Pattern> s) {
            if (s instanceof Intersection) return (Intersection) s;
            return new ForwardingIntersection(s);
        }
        
        public static Product productOf(Object... args) {
            return new ForwardingProduct(Native.wrap(new ArraySequence<Object>(args)));
        }
        
        public static Set setOf(Object... args) {
            return new ForwardingSet(Native.wrap(new ArraySequence<Object>(args)));
        }
        
        public static Union unionOf(Object... args) {
            return new ForwardingUnion(Native.wrap(new ArraySequence<Object>(args)));
        }
        
        public static Intersection intersectionOf(Object... args) {
            return new ForwardingIntersection(Native.wrap(new ArraySequence<Object>(args)));
        }




        public static Symbol toVitryBool(boolean a) {
            return a ? TRUE : FALSE;
        }
        
        public static boolean toJavaBool(Symbol a) {
            return a != FALSE;
        }
        
        
        
        
         
        // Support code

        private static void def(String name, Object val) {
            prelude.define(Symbol.intern(name), val);
        }            
        
        private static Object alias(String name) {
            return prelude.lookup(Symbol.intern(name));
        }
        
        private static void defFix(String name, int precedence, boolean assoc, boolean gathering) {
            preludeFixities.define(Symbol.intern(name), new Fixity(precedence, assoc, gathering));
        }
        
        private Symbol nextUnique() {
            byte[] val = uniqueState.toByteArray();
            char[] str = new char[val.length / 2 + 1];
            for (int i = 0; i < val.length; i += 2) {
                if ( (str.length & 1) == 1) str[i / 2] = (char) (val[i]);
                else
                    str[i / 2] = (char) ( (val[i] << 8) | val[i + 1]);

            }
            uniqueState = uniqueState.add(BigInteger.ONE);
            return Symbol.intern(new String(str));
        }
    }



// Built-in types


class Any extends Atom
    {
        Any() {}

        public boolean eq(Atom o) {
            return o == this;
        }

        public boolean match(Atom o) {
            return true;
        }

        public boolean match(Product p) {
            return true;
        }

        public boolean match(Union p) {
            return true;
        }

        public boolean match(Set p) {
            return true;
        }

        public boolean match(Intersection p) {
            return true;
        }

        public boolean match(Type p) {
            return true;
        }

        public String toString() {
            return "_";
        }
    }


class Bottom extends AbstractSet
    {
        Bottom() {}

        public boolean eq(Set o) {
            return o == this;
        }

        public String toString() {
            return "{}";
        }

        public int hashCode() {
            return -1;
        }

        public boolean hasTail() {
            return false;
        }

        public Pattern head() {
            return throwUnsupported();
        }

        public Sequence<Pattern> tail() {
            return null;
        }       
        
        private <T> T throwUnsupported() {
            throw new UnsupportedOperationException("{} has no members.");
        }
    }


final class Nil extends Atom implements Product
    {
        Nil() {}

        public boolean eq(Atom o) {
            return o == this;
        }

        public String toString() {
            return "()";
        }

        public Product cons(Pattern head) {
            return product(new Pair<Pattern>(head, this));
        }

        public <U> MapSequence<Pattern, U> map(Function fn) {
            return new MapSequence<Pattern, U>(fn, this);
        }

        public boolean isCompound() {
            return false;
        }

        public boolean hasTail() {
            return false;
        }

        // Rest of interface unsupported...
        

        public Pattern head() {
            return throwUnsupported();
        }

        public Product tail() {
            return throwUnsupported();
        }

        public SequenceIterator<Pattern> sequenceIterator() {
            return throwUnsupported();
        }

        public Iterator<Pattern> iterator() {
            return throwUnsupported();
        }

        public Product mapProduct(Function fn) {
            return throwUnsupported();
        }

        private <T> T throwUnsupported() {
            throw new UnsupportedOperationException("() has no members.");
        }

    }



// Core type delegators

class ForwardingProduct extends AbstractProduct
    {
        Sequence<Pattern> elements;

        public ForwardingProduct(Sequence<Pattern> elements) {
            this.elements = elements;
        }

        public final Iterator<Pattern> iterator() {
            return elements.iterator();
        }

        final  public Pattern head() {
            return elements.head();
        }

        public final Product tail() {
            return product(elements.tail());
        }

        public final boolean hasTail() {
            return elements.hasTail();
        }
    }


class ForwardingSet extends AbstractSet
    {
        Sequence<Pattern> elements;

        public ForwardingSet(Sequence<Pattern> elements) {
            this.elements = elements;
        }

        public final Iterator<Pattern> iterator() {
            return elements.iterator();
        }

        public final Pattern head() {
            return elements.head();
        }

        public final Sequence<Pattern> tail() {
            return elements.tail();
        }

        public final boolean hasTail() {
            return elements.hasTail();
        }
    }


class ForwardingUnion extends Union
    {
        Sequence<Pattern> elements;

        public ForwardingUnion(Sequence<Pattern> elements) {
            this.elements = elements;
        }

        public final Iterator<Pattern> iterator() {
            return elements.iterator();
        }

        public final Pattern head() {
            return elements.head();
        }

        public final Sequence<Pattern> tail() {
            return elements.tail();
        }

        public final boolean hasTail() {
            return elements.hasTail();
        }
    }


class ForwardingIntersection extends Intersection
    {
        Sequence<Pattern> elements;
    
    public ForwardingIntersection(Sequence<Pattern> elements) {
        this.elements = elements;
    }
    
    public final Iterator<Pattern> iterator() {
        return elements.iterator();
    }
    
    public final Pattern head() {
        return elements.head();
    }
    
    public final Sequence<Pattern> tail() {
        return elements.tail();
    }
    
    public final boolean hasTail() {
        return elements.hasTail();
    }
}





