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
import static vitry.runtime.VitryRuntime.toVitryBool;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Properties;

import vitry.prelude.*;
import vitry.runtime.error.*;
import vitry.runtime.struct.*;


/**
 * Runtime system for the Vitry programming language.
 *
 * @author Hans Höglund
 */
public final class VitryRuntime implements Scope
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



        private final Env<Symbol, Object> prelude = new HashEnvironment<Symbol, Object>();
        
        private final Env<Symbol, Fixity> preludeFixities = new HashEnvironment<Symbol, Fixity>();

        {
            def("()",                   NIL);
            def("[]",                   productOf(NIL, new list()));
            def("{}",                   productOf(BOTTOM, new set()));
            def("_",                    ANY);
            def("nil",                  NIL);
            def("true",                 TRUE);
            def("false",                FALSE);
            def("bool",                 unionOf(TRUE, FALSE));
            def("nat",                  NAT);
            def("int",                  INT);
            def("rat",                  RAT);
            def("float",                FLOAT);
            def("double",               DOUBLE);
            def("complex",              COMPLEX);
            def("char",                 CHAR);
            def("str",                  STR);

            def("(,)",                  new product());         // bootstr
            def("[,]",                  new list());            // bootstr
            def("{,}",                  new set());             // bootstr
            def("(|)",                  new union());           // bootstr
            def("(&)",                  new intersection());    // bootstr
            def("(->)",                 NIL);                   // bootstr TODO 
            def("(<->)",                NIL);                   // bootstr TODO 
            def("(<-)",                 NIL);                   // bootstr TODO 
            def("symbol",               new symbol());
            def("string",               new string());

            def("eq",                   new eq());
            def("neq",                  NIL);                   // bootstr TODO 
            def("lt",                   NIL);                   // bootstr TODO 
            def("lte",                  NIL);                   // bootstr TODO 
            def("gte",                  NIL);                   // bootstr TODO 
            def("gt",                   NIL);                   // bootstr TODO 
            def("succ",                 NIL);                   // bootstr TODO 
            def("pred",                 NIL);                   // bootstr TODO 
            def("min",                  NIL);                   // prelude TODO 
            def("max",                  NIL);                   // prelude TODO
            def("(==)",                 alias("eq"));
            def("(/=)",                 alias("neq"));
            def("(<)",                  alias("lt"));
            def("(<=)",                 alias("lte"));
            def("(=>)",                 alias("gte"));
            def("(>)",                  alias("gt"));
            def("not",                  NIL);                   // prelude TODO 
            def("and",                  NIL);                   // prelude TODO 
            def("or",                   NIL);                   // prelude TODO 

            def("arity",                new arity_());
            def("id",                   new id());
            def("const",                new const_());
            def("compose",              new compose());
            def("follow",               NIL);                   // prelude TODO
            def("power",                NIL);                   // prelude TODO
            def("flip",                 NIL);                   // prelude TODO
            def("(.)",                 alias("compose"));
            def("(..)",                alias("follow"));

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

            // head        : [a] -> a
            // tail        : [a] -> [a]
            // last        : [a] -> a
            // init        : [a] -> [a]
            // cons        : a, [a] -> a
            
            // Sequence functions
            // Overload on strings pro tempore

            def("head",                 new head());
            def("tail",                 new tail());
            def("last",                 NIL);
            def("init",                 NIL);
            def("prepend",              NIL);
            def("append",               NIL);

            def("length",               NIL);
            def("rank",                 NIL);
            def("isEmpty",              NIL);
            def("isSingle",             NIL);

            def("nth",                  NIL);
            def("map",                  NIL);
            def("apply",                NIL);
            def("foldl",                NIL);
            def("foldr",                NIL);
            def("concat",               NIL);

            def("insert",               NIL);
            def("substr",               NIL);
            def("subseq",               NIL);
            def("drop",                 NIL);
            def("take",                 NIL);
            def("remove",               NIL);
            def("retain",               NIL);

            def("reverse",              NIL);
            def("revappend",            NIL);
            def("sort",                 NIL);
            def("search",               NIL);
            def("shuffle",              NIL);
            def("permute",              NIL);
            def("partition",            NIL);

            def("some",                 NIL);
            def("every",                NIL);
            def("none",                 NIL);

            def("(++)",                 new conc());
            def("conc",                 alias("(++)"));
            
            def("now",                  NIL);

            def("read",                 new read(this));
            def("eval",                 new eval_(this));
            def("print",                new print(this));
            def("error",                NIL);

            def("repl",                 new repl(this));
            def("require",              NIL);
            def("load",                 NIL);
            def("version",              NIL);
            def("quit",                 new quit());
            
            // Implementation
            def("__rt",                 this);

            // Alpha - to be replaced
            def("openFile",             NIL);
            def("closeFile",            NIL);
            def("readFile",             NIL);
            def("writeFile",            NIL);
            def("str2list",             NIL);
            def("list2str",             NIL);
            def("rewrite",              new rewrite(this));

            // Alpha - JVM interop
            def("host",                 NIL);
            def("class",                new class_(this));
            def("method",               new method(this));
            def("fieldGet",             NIL);
            def("fieldPut",             NIL);
            def("classOf",              new classOf(this));
            def("methodsOf",            NIL);
            def("fieldsOf",             NIL);

            defFix("(..)",              12, false, false);   // gathering?
            defFix("(.)",               12, false, false );   // gathering?
            defFix("(^^)",              10, true,  false);
            defFix("(^)",               10, true,  false);
            defFix("(%)",               9,  true,  false);
            defFix("(%%)",              9,  true,  false);
            defFix("(/)",               9,  true,  false);
            defFix("(*)",               9,  true,  false);
            defFix("(-)",               8,  true,  false);
            defFix("(+)",               8,  true,  false);
            defFix("(++)",              8,  true,  false);
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
        private Seq<Module> modules;

        /**
         * Used to execute interpreted code.
         */
        private Eval       interpreter;

        /**
         * This is for the gensym facility.
         */
        private BigInteger uniqueState = BigInteger.valueOf(0x2177375305f7L);

        /**
         * Classes interned for reflection.
         * TODO unify with native set mechanism?
         */
        private final Env<Symbol, Class<?>> internedClasses = new HashEnvironment<Symbol, Class<?>>();



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
            
            if(this.interpreter == null)
                this.interpreter = new Interpreter(this);
        }




        // Accessors


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
        
        
        public Env<Symbol, Object> getEnvironment() {
            return getPrelude();
        }

        public Env<Symbol, Object> getPrelude() {
            return prelude;
        }

        public Env<Symbol, Fixity> getPreludeFixities() {
            return preludeFixities;
        }

        public Env<Symbol, Object> newTopLevelEnvironment() {
            return prelude.extend();
        }

        public Object getPreludeValue(Symbol key) throws UndefinedError {
            return prelude.lookup(key);
        }

        public Object getPreludeValue(String key) throws UndefinedError {
            return prelude.lookup(Symbol.intern(key));
        }


        public Class<?> internClass(Symbol name) throws ClassNotFoundException {
            if (!internedClasses.hasBinding(name)) {
                Class<?> c = Class.forName(name.toString());
                internedClasses.define(name, c);
            }
            return internedClasses.lookup(name);
        }







        // General construction and conversion


        public static Symbol toVitryBool(boolean a) {
            return a ? TRUE : FALSE;
        }

        public static boolean toPrimBool(Symbol a) {
            return a != FALSE;
        }
        
        

        public static Product product(Seq<Pattern> s) {
            if (Seqs.isNil(s)) return null;
            if (s instanceof Product) return (Product) s;
            return productFrom(s);
        }

        public static List list(Seq<Pattern> s) {
            if (Seqs.isNil(s)) return null;
            if (s instanceof List) return (List) s;
            return listFrom(s);
        }

        public static Set set(Seq<Pattern> s) {
            if (s instanceof Set) return (Set) s;
            return setFrom(s);
        }

        public static Union union(Seq<Pattern> s) {
            if (s instanceof Union) return (Union) s;
            return unionFrom(s);
        }

        public static Intersection intersection(Seq<Pattern> s) {
            if (s instanceof Intersection) return (Intersection) s;
            return intersectionFrom(s);
        }
        
        
        public static Product productOf(Object... args) {
            return productFrom(Native.wrap(new ArraySeq<Object>(args)));
        }

        public static List listOf(Object... args) {
            return listFrom(Native.wrap(new ArraySeq<Object>(args)));
        }

        public static Set setOf(Object... args) {
            return setFrom(Native.wrap(new ArraySeq<Object>(args)));
        }

        public static Union unionOf(Object... args) {
            return unionFrom(Native.wrap(new ArraySeq<Object>(args)));
        }

        public static Intersection intersectionOf(Object... args) {
            return intersectionFrom(Native.wrap(new ArraySeq<Object>(args)));
        }
        
        
        public static Product productFrom(Seq<Pattern> s) {
            return new ForwardingProduct(s);
        }

        public static List listFrom(Seq<Pattern> s) {
            return new ForwardingList(s);
        }
        
        public static Set setFrom(Seq<Pattern> s) {
            return new ForwardingSet(s);
        }
        
        public static Union unionFrom(Seq<Pattern> s) {
            return new ForwardingUnion(s);
        }

        public static Intersection intersectionFrom(Seq<Pattern> s) {
            return new ForwardingIntersection(s);
        }




        // Helper methods

        private void def(String name, Object val) {
            prelude.define(Symbol.intern(name), val);
        }

        private  Object alias(String name) {
            return prelude.lookup(Symbol.intern(name));
        }

        private void defFix(String name, int precedence, boolean assoc, boolean gathering) {
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

        public Seq<Pattern> tail() {
            return throwUnsupported();
        }

        public Iterator<Pattern> iterator() {
            return NilIterator.INSTANCE;
        }

        private <T> T throwUnsupported() {
            throw new UnsupportedOperationException("{} has no members.");
        }
    }


final class Nil extends Atom implements Finite<Pattern>
    {
        Nil() {}

        public boolean eq(Atom o) {
            return o == this;
        }

        public String toString() {
            return "()";
        }

        public Product cons(Pattern head) {
            // TODO product by default?
            return product(new Pair<Pattern>(head, this));
        }

        public <U> MapSeq<Pattern, U> map(Function fn) {
            return new MapSeq<Pattern, U>(fn, this);
        }

        public boolean hasTail() {
            return false;
        }

        public int length() {
            return 0;
        }

        // Rest of interface unsupported...


        public Pattern head() {
            return throwUnsupported();
        }

        public Product tail() {
            return throwUnsupported();
        }

        public Iterator<Pattern> iterator() {
            return NilIterator.INSTANCE;
        }

        public SeqIterator<Pattern> sequenceIterator() {
            return NilIterator.INSTANCE;
        }

        private <T> T throwUnsupported() {
            throw new UnsupportedOperationException("() has no members.");
        }

    }


class NilIterator extends SeqIterator<Pattern>
    {
        static final SeqIterator<Pattern> INSTANCE = new NilIterator();

        private NilIterator(){
            super(VitryRuntime.NIL);
        }

        public boolean hasNext() {
            return false;
        }

        public Pattern next() {
            return throwUnsupported();
        }

        public void remove() {
            throwUnsupported();
        }

        private <T> T throwUnsupported() {
            throw new UnsupportedOperationException("() has no members.");
        }
    }



// Core type delegators

final class ForwardingProduct extends AbstractProduct
    {
        final Seq<Pattern> elements;

        public ForwardingProduct(Seq<Pattern> elements) {
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
        final Seq<Pattern> elements;

        public ForwardingSet(Seq<Pattern> elements) {
            this.elements = elements;
        }

        public Iterator<Pattern> iterator() {
            return elements.iterator();
        }

        public Pattern head() {
            return elements.head();
        }

        public Seq<Pattern> tail() {
            return elements.tail();
        }

        public boolean hasTail() {
            return elements.hasTail();
        }
    }


final class ForwardingUnion extends Union
    {
        final Seq<Pattern> elements;

        public ForwardingUnion(Seq<Pattern> elements) {
            this.elements = elements;
        }

        public Iterator<Pattern> iterator() {
            return elements.iterator();
        }

        public Pattern head() {
            return elements.head();
        }

        public Seq<Pattern> tail() {
            return elements.tail();
        }

        public boolean hasTail() {
            return elements.hasTail();
        }
    }


final class ForwardingIntersection extends Intersection
    {
        final Seq<Pattern> elements;

        public ForwardingIntersection(Seq<Pattern> elements) {
            this.elements = elements;
        }

        public Iterator<Pattern> iterator() {
            return elements.iterator();
        }

        public Pattern head() {
            return elements.head();
        }

        public Seq<Pattern> tail() {
            return elements.tail();
        }

        public boolean hasTail() {
            return elements.hasTail();
        }
    }


final class ForwardingList extends List
{
    final Seq<Pattern> elements;

    public ForwardingList(Seq<Pattern> elements) {
        this.elements = elements;
    }

    public Iterator<Pattern> iterator() {
        return elements.iterator();
    }

    public Pattern head() {
        return elements.head();
    }

    public Seq<Pattern> tail() {
        return elements.tail();
    }

    public boolean hasTail() {
        return elements.hasTail();
    }
}





// Trivial prelude



class arity_ extends StandardFunction
{
    public arity_() { super(1); }

    public Object apply(Object a) {
        return ((Arity) a).getArity();
    }
}

class compose extends StandardFunction
{
    public compose() { super(2); }
    
    public Object apply(final Object f, final Object g) {
        return new StandardFunction(1){
            public Object apply(Object x) throws InvocationError {
                return ((Function) f).apply(((Function) g).apply(x));
            }  
        };
    }
}

class conc extends StandardFunction
{
    public conc() { super(2); }
    
    public Object apply(Object a, Object b) {
        return ((String) a).concat((String) b);
    }
}

class const_ extends StandardFunction
{
    public const_() {
        super(1);
    }

    public Object apply(final Object a) {
        return new StandardFunction(1)
            {
                public Object apply(Object b) {
                    return a;
                }
            };
    }
}

class eq extends StandardFunction
{
    public eq() {
        super(2);
    }

    public Object apply(Object a, Object b) {
        if (b instanceof Pattern) {
            if (a instanceof Pattern) { 
                return toVitryBool( ((Pattern) a).eqFor((Pattern) b)); 
            }
            return toVitryBool( ((Pattern) b).eq(a));
        }
        return toVitryBool(a.equals(b));
    }
}

class eval_ extends StandardFunction
{
    private VitryRuntime rt;

    public eval_(VitryRuntime rt) {
        super(1, rt);
        this.rt = rt;
    }

    public Object apply(Object a) {
        return rt.getInterpreter().eval(a);
    }
}

class head extends StandardFunction
{
    public head() {
        super(1);
    }
    public Object apply(Object a) {
        return ((Seq) a).head();
    }
}

class tail extends StandardFunction
{
    public tail() {
        super(1);
    }

    public Object apply(Object a) {
        return ((Seq) a).tail();
    }
}

class id extends StandardFunction
{
    public id() {
        super(1);
    }

    public Object apply(Object a) {
        return a;
    }
}


class product extends InvertibleRestFunction
   {
       public Seq<?> applyVarInverse(Object a) throws InvocationError {
           if (a instanceof Product)
               return ((Destructible) a).destruct();
           return throwDestruct(a);
       }

       public Object applyVar(Seq<?> args) {
           return VitryRuntime.productOf(Seqs.toArray(args));
       }

       private <T> T throwDestruct(Object val) {
           throw new TypeError(val, this);
       }
       
       public String toString() {
           return "(,)";
       }
   }

class list extends InvertibleRestFunction
   {
       public Seq<?> applyVarInverse(Object a) throws InvocationError {
           if (a instanceof List)
               return ((Destructible) a).destruct();
           return throwDestruct(a);
       }

       public Object applyVar(Seq<?> args) {
           return VitryRuntime.listOf(Seqs.toArray(args));
       }

       private <T> T throwDestruct(Object val) {
           throw new TypeError(val, this);
       }

       public String toString() {
           return "[,]";
       }
   }

class set extends RestFunction
   {
       public Object applyVar(Seq<?> args) {
           return VitryRuntime.setOf(Seqs.toArray(args));
       }
   }

class union extends RestFunction
   {
       public Object applyVar(Seq<?> args) {
           return VitryRuntime.unionOf(Seqs.toArray(args));
       }
   }

class intersection extends RestFunction
   {
       public Object applyVar(Seq<?> args) {
           return VitryRuntime.intersectionOf(Seqs.toArray(args));
       }
   }
