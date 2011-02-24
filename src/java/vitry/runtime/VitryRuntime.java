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

import static vitry.runtime.VitryRuntime.*;

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

        public static final Nil       NIL             = new Nil();
        public static final Symbol    TRUE            = Symbol.intern("true");
        public static final Symbol    FALSE           = Symbol.intern("false");
        public static final Any       ANY             = new Any();
        public static final Bottom    BOTTOM          = new Bottom();
        public static final Union     BOOL            = unionOf(TRUE, FALSE);
        
        public static final Set       NAT             = NativeSet.forClass(BigInteger.class);
        public static final Set       INT             = NativeSet.forClass(BigInteger.class);
        public static final Set       RAT             = NativeSet.forClass(BigRational.class);
        public static final Set       FLOAT           = NativeSet.forClass(Float.class);
        public static final Set       DOUBLE          = NativeSet.forClass(Double.class);
        public static final Set       COMPLEX         = null;
        public static final Set       CHAR            = NativeSet.forClass(Character.class);
        public static final Set       STR             = NativeSet.forClass(String.class);

        static final int              MIN_ARITY       = 1;
        static final int              MAX_ARITY       = 0xf;


        /**
         * Standard prelude
         *                                          
         * This is non-static so that bootstrap functions can access the runtime. 
         */
        private final Env<Symbol, Object> prelude = new HashEnv<Symbol, Object>();
           
        private final Env<Symbol, Fixity> preludeFixities = new HashEnv<Symbol, Fixity>();

        {
            def("()",                 NIL);
            def("[]",                 productOf(NIL,    new list_()));
            def("{}",                 productOf(BOTTOM, new set_()));
            def("_",                  ANY);
            
            def("(,)",                new product_());        
            def("[,]",                new list_());
            def("{,}",                new set_());            
            def("(|)",                new union_());          
            def("(&)",                new intersection_());   
            def("(->)",               NIL);                   // TODO 
            def("(<->)",              NIL);                   // TODO 
            
            def("nil",                NIL);
            def("true",               TRUE);
            def("false",              FALSE);
            def("bool",               BOOL);
            def("nat",                NAT);
            def("int",                INT);
            def("rat",                RAT);
            def("float",              FLOAT);
            def("double",             DOUBLE);
            def("complex",            COMPLEX);
            def("char",               CHAR);
            def("str",                STR);
            
            def("symbol",             new symbol_());
            def("string",             new string_());

            def("(==)",               new eq());
            def("(!=)",               NIL);                   // TODO
            def("not",                NIL);                   // TODO 
            def("(&&)",               NIL);                   // TODO 
            def("(||)",               NIL);                   // TODO 
            def("(<)",                NIL);
            def("(<=)",               NIL);
            def("(=>)",               NIL);
            def("(>)",                NIL);

            def("arity",              new arity_());
            def("id",                 new id());
            def("const",              new const_());
            def("(.)",                new compose());
            def("(..)",               NIL);                   // TODO
            def("power",              NIL);                   // TODO
            def("flip",               NIL);                   // TODO

            def("(+)",                new add());
            def("(-)",                new sub());
            def("(*)",                new mul());
            def("(/)",                new div());
            def("(%)",                new mod());
            def("(%%)",               new modp());
            def("(^)",                new pow());
            def("abs",                NIL);                   // TODO
            def("signum",             NIL);                   // TODO
            def("sqrt",               NIL);                   // TODO
            def("log",                NIL);                   // TODO
            def("logn",               NIL);                   // TODO
            def("ln",                 NIL);                   // TODO
            def("sin",                NIL);                   // TODO
            def("tan",                NIL);                   // TODO
            def("cos",                NIL);                   // TODO
            def("asin",               NIL);                   // TODO
            def("atan",               NIL);                   // TODO
            def("acos",               NIL);                   // TODO
            def("round",              NIL);                   // TODO
            def("ceil",               NIL);                   // TODO
            def("floor",              NIL);                   // TODO
            def("recip",              NIL);                   // TODO
            def("sum",                NIL);                   // TODO
            def("prod",               NIL);                   // TODO
            def("gcd",                NIL);                   // TODO
            def("lcm",                NIL);                   // TODO

            def("isOdd",              NIL);                   // TODO
            def("isEven",             NIL);                   // TODO
            def("isPrime",            NIL);                   // TODO
            def("isZero",             NIL);                   // TODO
            def("isNegative",         NIL);                   // TODO

            def("head",               new head());
            def("tail",               new tail());
            def("last",               NIL);                   // TODO
            def("init",               NIL);                   // TODO
            def("prepend",            NIL);                   // TODO
            def("append",             NIL);                   // TODO

            def("length",             NIL);                   // TODO
            def("rank",               NIL);                   // TODO
            def("isEmpty",            NIL);                   // TODO
            def("isSingle",           NIL);                   // TODO

            def("nth",                NIL);                   // TODO
            def("map",                NIL);                   // TODO
            def("apply",              NIL);                   // TODO
            def("foldl",              NIL);                   // TODO
            def("foldr",              NIL);                   // TODO
            def("concat",             NIL);                   // TODO

            def("insert",             NIL);                   // TODO
            def("substr",             NIL);                   // TODO
            def("subseq",             NIL);                   // TODO
            def("drop",               NIL);                   // TODO
            def("take",               NIL);                   // TODO
            def("remove",             NIL);                   // TODO
            def("retain",             NIL);                   // TODO

            def("reverse",            NIL);                   // TODO
            def("revappend",          NIL);                   // TODO
            def("sort",               NIL);                   // TODO
            def("search",             NIL);                   // TODO
            def("shuffle",            NIL);                   // TODO
            def("permute",            NIL);                   // TODO
            def("partition",          NIL);                   // TODO

            def("some",               NIL);                   // TODO
            def("every",              NIL);                   // TODO
            def("none",               NIL);                   // TODO

            def("(++)",               new conc());            
            def("now",                NIL);                   // TODO

            def("read",               new read(this));
            def("eval",               new eval_(this));
            def("print",              new print(this));
            def("error",              NIL);                   // TODO

            def("repl",               new repl(this));
            def("require",            NIL);                   // TODO
            def("load",               NIL);                   // TODO
            def("version",            NIL);                   // TODO
            def("quit",               new quit());
            
            

            // Alpha - subject to change or disappear:
            
            def("__rt",               this);
            def("openFile",           NIL);
            def("closeFile",          NIL);
            def("readFile",           NIL);
            def("writeFile",          NIL);
            def("str2list",           NIL);
            def("list2str",           NIL);
            def("rewrite",            new rewrite(this));

            def("host",               NIL);
            def("class",              new class_(this));
            def("method",             new method(this));
            def("classOf",            new classOf(this));
            def("methodsOf",          NIL);
            def("fieldsOf",           NIL);
            


            defFix("(..)",            12, false, false);   // gathering?
            defFix("(.)",             12, false, false );   // gathering?
            defFix("(^^)",            10, true,  false);
            defFix("(^)",             10, true,  false);
            defFix("(%)",             9,  true,  false);
            defFix("(%%)",            9,  true,  false);
            defFix("(/)",             9,  true,  false);
            defFix("(*)",             9,  true,  false);
            defFix("(-)",             8,  true,  false);
            defFix("(+)",             8,  true,  false);
            defFix("(++)",            8,  true,  false);
            defFix("(<)",             6,  true,  false);
            defFix("(<=)",            6,  true,  false);
            defFix("(>=)",            6,  true,  false);
            defFix("(>)",             6,  true,  false);
            defFix("(/=)",            6,  true,  false);
            defFix("(==)",            6,  true,  false);
            defFix("[,]",             5,  true,  true);
            defFix("{,}",             5,  true,  true);
            defFix("(,)",             5,  true,  true);
            defFix("(|)",             4,  true,  false);  // assoc?
            defFix("(&)",             4,  true,  false);  // assoc?
            defFix("(->)",            3,  false, false);
            defFix("(&&)",            2,  false, false);
            defFix("(||)",            1,  false, false);
            defFix("($!)",            0,  true,  false);
            defFix("($)",             0,  false, false);
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
        private final Env<Symbol, Class<?>> internedClasses = new HashEnv<Symbol, Class<?>>();



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
            return new StdProduct(s);
        }

        public static List listFrom(Seq<Pattern> s) {
            return new StdList(s);
        }
        
        public static Set setFrom(Seq<Pattern> s) {
            return new StdSet(s);
        }
        
        public static Union unionFrom(Seq<Pattern> s) {
            return new StdUnion(s);
        }

        public static Intersection intersectionFrom(Seq<Pattern> s) {
            return new StdIntersection(s);
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
        Any() {
        }

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
        Bottom() {
        }

        public boolean eq(Set o) {
            return o == this;
        }
        
        public boolean match(Set a) {
            return a == this;
        }

        public boolean match(Union a) {
            return false;
        }

        public boolean match(Intersection a) {
            return false;
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
        Nil() {
        }

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

        private NilIterator() {
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


final class StdProduct extends AbstractProduct
    {
        final Seq<Pattern> elements;

        public StdProduct(Seq<Pattern> elements) {
            this.elements = elements;
        }

        public Iterator<Pattern> iterator() {
            return elements.iterator();
        }

        final public Pattern head() {
            return elements.head();
        }

        public Product tail() {
            return product(elements.tail());
        }

        public boolean hasTail() {
            return elements.hasTail();
        }
    }


final class StdSet extends AbstractSet
    {
        final Seq<Pattern> elements;

        public StdSet(Seq<Pattern> elements) {
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


final class StdUnion extends Union
    {
        final Seq<Pattern> elements;

        public StdUnion(Seq<Pattern> elements) {
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


final class StdIntersection extends Intersection
    {
        final Seq<Pattern> elements;

        public StdIntersection(Seq<Pattern> elements) {
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


final class StdList extends List
    {
        final Seq<Pattern> elements;

        public StdList(Seq<Pattern> elements) {
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


// Bootstrap prelude

abstract class Unary extends StandardFunction
    {
        public Unary() {
            super(1);
        }
    }

abstract class Binary extends StandardFunction
    {
        public Binary() {
            super(2);
        }
    }


final class product_ extends InvertibleRestFunction
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

final class list_ extends InvertibleRestFunction
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

final class set_ extends RestFunction
    {
        public Object applyVar(Seq<?> args) {
            return VitryRuntime.setOf(Seqs.toArray(args));
        }
        
        public String toString() {
            return "{,}";
        }
    }

final class union_ extends RestFunction
    {
        public Object applyVar(Seq<?> args) {
            return VitryRuntime.unionOf(Seqs.toArray(args));
        }
        
        public String toString() {
            return "(|)";
        }
    }

final class intersection_ extends RestFunction
    {
        public Object applyVar(Seq<?> args) {
            return VitryRuntime.intersectionOf(Seqs.toArray(args));
        }
        
        public String toString() {
            return "(&)";
        }
    }
    

final class symbol_ extends Unary
{
    public Object apply(Object a) {
        return Symbol.intern((String) a);
    }
}

final class string_ extends Unary
    {
        public Object apply(Object a) throws InvocationError {
            return a.toString();
        }
    }

final class id extends Unary
    {
        public Object apply(Object a) {
            return a;
        }
    }

final class const_ extends Unary
    {
        public Object apply(final Object a) {
            return new Unary() {
                public Object apply(Object b) {
                    return a;
                }
            };
        }
    }

final class compose extends Binary
    {
        public Object apply(final Object f, final Object g) {
            return new Unary() {
                public Object apply(Object x) throws InvocationError {
                    return ((Function) f).apply( ((Function) g).apply(x));
                }
            };
        }
    }

final class arity_ extends Unary
    {
        public Object apply(Object a) {
            return ((Arity) a).getArity();
        }
    }

final class conc extends Binary
    {
        public Object apply(Object a, Object b) {
            return ((String) a).concat((String) b);
        }
    }

final class eq extends Binary
    {
        public Object apply(Object a, Object b) {
            if (b instanceof Pattern) {
                if (a instanceof Pattern) { 
                    return toVitryBool( ((Pattern) a).eqFor((Pattern) b)); }
                return toVitryBool( ((Pattern) b).eq(a));
            }
            return toVitryBool(a.equals(b));
        }
    }

final class eval_ extends StandardFunction
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

final class head extends Unary
    {
        public Object apply(Object a) {
            return ((Seq) a).head();
        }
    }

final class tail extends Unary
    {
        public Object apply(Object a) {
            return ((Seq) a).tail();
        }
    }
