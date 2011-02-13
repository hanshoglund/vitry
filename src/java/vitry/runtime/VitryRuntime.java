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
import vitry.runtime.util.ModuleClassLoader;


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
        public static final Set         COMPLEX         = null;
        public static final Set         CHAR            = NativeSet.forClass(Character.class);
        public static final Set         STR             = NativeSet.forClass(String.class); 
        // TODO boolean etc                                                                                
        static final int                MIN_ARITY       = 1;
        static final int                MAX_ARITY       = 0xf;

        
        
        private static final Environment<Symbol, Object> prelude = new HashEnvironment<Symbol, Object>();
        private static final Environment<Symbol, Fixity> preludeFixities = new HashEnvironment<Symbol, Fixity>();

        static {
            def("()",                   NIL);
            def("[]",                   NIL);
            def("{}",                   BOTTOM);
            def("_",                    ANY);
            def("nil",                  NIL);
            def("true",                 TRUE);
            def("false",                FALSE);
            def("bool",                 null);
            def("nat",                  NAT);
            def("int",                  INT);
            def("rat",                  RAT);
            def("float",                FLOAT);
            def("double",               DOUBLE);
            def("complex",              COMPLEX);
            def("char",                 CHAR);
            def("str",                  STR);
            
            def("eq",                   new eq());
            def("neq",                  NIL);
            def("lt",                   NIL);
            def("lte",                  NIL);
            def("gte",                  NIL);
            def("gt",                   NIL);
            def("min",                  NIL);
            def("max",                  NIL);
            def("==",                   alias("eq"));
            def("/=",                   alias("neq"));
            def("<",                    alias("lt"));
            def("<=",                   alias("lte"));
            def("=>",                   alias("gte"));
            def(">",                    alias("gt"));
                          
            def("arity",                new arity());
            def("id",                   new id());
            def("const",                new const_());   
            def("compose",              NIL);
            def("follow",               NIL);
            def("power",                NIL);
            def("flip",                 NIL);            
            def("(./)",                 alias("compose"));            
            def("(.\\)",                alias("follow"));            

            def("(,)",                  new product());
            def("[,]",                  NIL);
            def("{,}",                  NIL);
                 
            def("succ",                 NIL);
            def("pred",                 NIL);
                             

            def("not",                  NIL);

               
            def("add",                  new add());
            def("sub",                  new sub());
            def("mul",                  new mul());
            def("div",                  new div());
            def("mod",                  new mod());
            def("modp",                 new modp());
            def("negate",               new neg());
            def("abs",                  NIL);
            def("signum",               NIL);
            def("exp",                  new pow());
            def("sqrt",                 NIL);
            def("log",                  NIL);
            def("logn",                 NIL);
            def("ln",                   NIL);
            def("sin",                  NIL);
            def("tan",                  NIL);
            def("cos",                  NIL);
            def("asin",                 NIL);
            def("atan",                 NIL);
            def("acos",                 NIL);
            def("round",                NIL);
            def("ceil",                 NIL);
            def("floor",                NIL);
            def("recip",                NIL);
            def("sum",                  NIL);
            def("prod",                 NIL);
            def("gcd",                  NIL);
            def("lcm",                  NIL);
            def("(+)",                  alias("add"));
            def("(-)",                  alias("sub"));
            def("(*)",                  alias("mul"));
            def("(/)",                  alias("div"));
            def("(%)",                  alias("mod"));
            def("(%%)",                 alias("modp"));
            def("(^)",                  alias("exp"));
            
            def("isNegative",           NIL);
            def("isOdd",                NIL);
            def("isEven",               NIL);
            def("isPrime",              NIL);
            
            

            def("now",                  NIL);

            def("read",                 NIL);
            def("eval",                 NIL);
            def("print",                NIL);
            def("error",                NIL);
            
            def("require",              NIL);
            def("load",                 NIL);
            def("version",              NIL);
            def("quit",                 new quit());

            
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
        

        /**
         * Used to determine classpath etc.
         */
        private final Properties  systemProperties;
                          
        /**
         * Used to load modules.
         */
        private ClassLoader classLoader;
                                      
        /**
         * Loaded modules.
         */
        private Sequence<Module> modules;
                                          
        /**
         * Used to execute interpreted code.
         */
        private Eval       interpreter;
           
        /**
         * This is for the gensym facility.
         */
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


final class Any extends Atom
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


final class Bottom extends AbstractSet
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

final class ForwardingProduct extends AbstractProduct
    {
        final Sequence<Pattern> elements;

        public ForwardingProduct(Sequence<Pattern> elements) {
            this.elements = elements;
        }

        public Iterator<Pattern> iterator() {
            return elements.iterator();
        }

        final  public Pattern head() {
            return elements.head();
        }

        public Product tail() {
            return product(elements.tail());
        }

        public boolean hasTail() {
            return elements.hasTail();
        }
    }


final class ForwardingSet extends AbstractSet
    {
        final Sequence<Pattern> elements;

        public ForwardingSet(Sequence<Pattern> elements) {
            this.elements = elements;
        }

        public Iterator<Pattern> iterator() {
            return elements.iterator();
        }

        public Pattern head() {
            return elements.head();
        }

        public Sequence<Pattern> tail() {
            return elements.tail();
        }

        public boolean hasTail() {
            return elements.hasTail();
        }
    }


final class ForwardingUnion extends Union
    {
        final Sequence<Pattern> elements;

        public ForwardingUnion(Sequence<Pattern> elements) {
            this.elements = elements;
        }

        public Iterator<Pattern> iterator() {
            return elements.iterator();
        }

        public Pattern head() {
            return elements.head();
        }

        public Sequence<Pattern> tail() {
            return elements.tail();
        }

        public boolean hasTail() {
            return elements.hasTail();
        }
    }


final class ForwardingIntersection extends Intersection
    {
        final Sequence<Pattern> elements;

        public ForwardingIntersection(Sequence<Pattern> elements) {
            this.elements = elements;
        }

        public Iterator<Pattern> iterator() {
            return elements.iterator();
        }

        public Pattern head() {
            return elements.head();
        }

        public Sequence<Pattern> tail() {
            return elements.tail();
        }

        public boolean hasTail() {
            return elements.hasTail();
        }
    }




