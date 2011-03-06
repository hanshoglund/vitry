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
import static vitry.runtime.struct.Seqs.isNil;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Properties;

import vitry.Build;
import vitry.runtime.StandardFunction.Binary;
import vitry.runtime.StandardFunction.Unary;

import vitry.prelude.*;
import vitry.runtime.error.*;
import vitry.runtime.misc.Utils;
import vitry.runtime.struct.*;


/**
 * Runtime system for the Vitry programming language.
 *
 * @author Hans Hoglund
 */
public final class VitryRuntime
{

    public static final List     NIL            = new Nil();
    public static final Symbol   TRUE           = Symbol.intern("true");
    public static final Symbol   FALSE          = Symbol.intern("false");
    public static final Symbol   WILDCARD       = Symbol.intern("_");
    public static final Atom     ANY            = new Any();
    public static final Set      BOTTOM         = new Bottom();
    public static final Union    BOOL           = unionOf(TRUE, FALSE);
    
    public static final Set      NAT            = NativeSet.forClass(BigInteger.class);
    public static final Set      INT            = NativeSet.forClass(BigInteger.class);
    public static final Set      RAT            = NativeSet.forClass(BigRational.class);
    public static final Set      FLOAT          = NativeSet.forClass(Float.class);
    public static final Set      DOUBLE         = NativeSet.forClass(Double.class);
    public static final Set      COMPLEX        = null;
    public static final Set      CHAR           = NativeSet.forClass(Character.class);
    public static final Set      STR            = NativeSet.forClass(String.class);

    static final int             MIN_ARITY      = 1;
    static final int             MAX_ARITY      = 0xf;

    private static final Symbol  PRIM_DOUBLE    = Symbol.intern("double");
    private static final Symbol  PRIM_FLOAT     = Symbol.intern("float");
    private static final Symbol  PRIM_LONG      = Symbol.intern("long");
    private static final Symbol  PRIM_INT       = Symbol.intern("int");
    private static final Symbol  PRIM_CHAR      = Symbol.intern("char");
    private static final Symbol  PRIM_SHORT     = Symbol.intern("short");
    private static final Symbol  PRIM_BYTE      = Symbol.intern("byte");
    private static final Symbol  PRIM_BOOLEAN   = Symbol.intern("boolean");
    

    /**
     * Used to determine classpath etc.
     */
    private final Properties  setup;
    
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
     * For the gensym facility and other things.
     */
    private BigInteger uniqueState = BigInteger.valueOf(0x2177375305f7L);

    /**
     * Standard prelude
     *                                          
     * This is non-static so that bootstrap functions can access the runtime. 
     */
    private Module prelude;
    
    /**
     * Classes interned for reflection.
     * 
     * The symbol is full class name or java primitive (int, boolean etc).
     */
    private final Env<Symbol, Class<?>> internedClasses = new HashEnv<Symbol, Class<?>>();

    
    public VitryRuntime() {
        this(System.getProperties());
    }

    public VitryRuntime(Properties setup) {
        this(setup, Thread.currentThread().getContextClassLoader());
    }
    
    public VitryRuntime(Properties setup, ClassLoader classLoader)
    {
        this.setup = setup;
        this.classLoader = classLoader;
        
        this.interpreter = new Interpreter(this);
        
        this.prelude = bootstrapPrelude();
        initPrelude(this.prelude);
        this.prelude = loadPrelude(this.prelude);
    }


    private Module bootstrapPrelude()
    {
        return new Module(Seqs.seq(Symbol.intern("Vitry"), Symbol.intern("Prelude")));
    }
    
    private Module loadPrelude(Module bootstrapPrelude)
    {
        /* 
         * TODO Naive version
         * We should probably obtain interpreted modules from 
         * getResourceAsStream() instead
         */
        
        Function parseFile = (Function) bootstrapPrelude.getValue("parseFile");
        Function eval = (Function) bootstrapPrelude.getValue("eval");
        
        Object ast = parseFile.apply("bin/vitry/Prelude.vitry");
        Module m   = (Module) eval.apply(ast);
        
        return m;
    }

    private void initPrelude(Module prelude) 
    {    
        prelude.def("()",         NIL);
        prelude.def("[]",         productOf(NIL,    new list_()));
        prelude.def("{}",         productOf(BOTTOM, new set_()));
        prelude.def("_",          ANY);
        
        prelude.def("(,)",        new product_());        
        prelude.def("[,]",        new list_());
        prelude.def("{,}",        new set_());            
        prelude.def("(|)",        new union_());          
        prelude.def("(&)",        new intersection_());   
        prelude.def("(->)",       NIL);                   // TODO 
        prelude.def("(<->)",      NIL);                   // TODO 
        
        prelude.def("nil",        NIL);
        prelude.def("true",       TRUE);
        prelude.def("false",      FALSE);
        prelude.def("bool",       BOOL);
        prelude.def("nat",        NAT);
        prelude.def("int",        INT);
        prelude.def("rat",        RAT);
        prelude.def("float",      FLOAT);
        prelude.def("double",     DOUBLE);
        prelude.def("complex",    COMPLEX);
        prelude.def("char",       CHAR);
        prelude.def("str",        STR);
        
        prelude.def("(==)",       new eq());
        prelude.def("(<)",        new lt());
        prelude.def("(>)",        new gt());

        prelude.def("arity",      new arity_());
        prelude.def("id",         new id());
        prelude.def("const",      new const_());
        prelude.def("(.)",        new compose());
        prelude.def("(..)",       new follow());
        prelude.def("flip",       new flip());

        prelude.def("(+)",        new add());
        prelude.def("(-)",        new sub());
        prelude.def("(*)",        new mul());
        prelude.def("(/)",        new div());
        prelude.def("(%)",        new mod());
        prelude.def("(%%)",       new modp());
        prelude.def("(^)",        new pow());
        prelude.def("random",     new random());
        prelude.def("signum",     NIL);                   // TODO
        prelude.def("recip",      NIL);                   // TODO
        prelude.def("gcd",        NIL);                   // TODO
        prelude.def("lcm",        NIL);                   // TODO
        prelude.def("NaN",        Double.NaN);
        prelude.def("Infinity",   Double.POSITIVE_INFINITY);

        prelude.def("(++)",       new conc());
        prelude.def("cons",       new prepend());
        prelude.def("append",     NIL);                   // TODO
        prelude.def("head",       new head());
        prelude.def("tail",       new tail());
        prelude.def("last",       NIL);                   // TODO
        prelude.def("init",       NIL);                   // TODO

        prelude.def("rank",       NIL);                   // TODO
        prelude.def("isSingle",   NIL);                   // TODO

        prelude.def("nth",        new nth());
        prelude.def("map",        new map());
        prelude.def("apply",      NIL);                   // TODO
        prelude.def("foldl",      new foldl());
        prelude.def("foldr",      new foldr());

        prelude.def("insert",     NIL);                   // TODO
        prelude.def("substr",     NIL);                   // TODO
        prelude.def("subseq",     NIL);                   // TODO
        prelude.def("drop",       NIL);                   // TODO
        prelude.def("take",       NIL);                   // TODO
        prelude.def("remove",     NIL);                   // TODO
        prelude.def("retain",     NIL);                   // TODO
        prelude.def("range",      new range());
        prelude.def("(...)",      new range());
        prelude.def("[...]",      new range());

        prelude.def("reverse",    NIL);                   // TODO
        prelude.def("sort",       NIL);                   // TODO
        prelude.def("search",     NIL);                   // TODO
        prelude.def("shuffle",    NIL);                   // TODO
        prelude.def("permute",    NIL);                   // TODO
        prelude.def("partition",  NIL);                   // TODO

        prelude.def("some",       NIL);                   // TODO
        prelude.def("every",      NIL);                   // TODO
        prelude.def("none",       NIL);                   // TODO

        prelude.def("now",        new now(this));

        prelude.def("parse",      new parse(this));
        prelude.def("print",      new print(this));
        prelude.def("parseFile",  new parseFile(this));
        prelude.def("eval",       new eval_(this));
        prelude.def("error",      new error_(this));
        prelude.def("writeFile",  new writeFile(this));

        prelude.def("repl",       new repl(this, prelude));
        prelude.def("load",       new load(prelude));
        prelude.def("quit",       new quit());
        

        // Non-standard
        
        prelude.def("__rt",       this);
        prelude.def("rewrite",    new rewrite(this));

        prelude.def("seq",        new seq());
        prelude.def("array",      new array());
        prelude.def("symbol",     new symbol_());
        prelude.def("string",     new string_());
        prelude.def("parseDecl",  new parseDecl(this));

        prelude.def("class",      new class_(this));
        prelude.def("new",        new new_(this));
        prelude.def("method",     new method(this, prelude));
        prelude.def("classOf",    new classOf(this));
        prelude.def("methodsOf",  NIL);
        prelude.def("fieldsOf",   NIL);


        // Fixities

        prelude.defFix("[...]",   12, true,  false);
        prelude.defFix("(...)",   12, true,  false);
        prelude.defFix("(..)",    12, false, false);
        prelude.defFix("(.)",     12, false, false);
        prelude.defFix("(^^)",    11, true,  false);
        prelude.defFix("(^)",     11, true,  false);
        prelude.defFix("(%)",     10, true,  false);
        prelude.defFix("(%%)",    10, true,  false);
        prelude.defFix("(/)",     10, true,  false);
        prelude.defFix("(*)",     10, true,  false);
        prelude.defFix("(-)",     9,  true,  false);
        prelude.defFix("(+)",     9,  true,  false);
        prelude.defFix("(++)",    9,  true,  false);
        prelude.defFix("[,]",     8,  true,  true);
        prelude.defFix("{,}",     8,  true,  true);
        prelude.defFix("(,)",     8,  true,  true);
        prelude.defFix("(&)",     7,  true,  false);
        prelude.defFix("(|)",     6,  true,  false);
        prelude.defFix("(->)",    5,  false, false);
        prelude.defFix("(<->)",   4,  false, false);
        prelude.defFix("(<)",     3,  true,  false);
        prelude.defFix("(<=)",    3,  true,  false);
        prelude.defFix("(>=)",    3,  true,  false);
        prelude.defFix("(>)",     3,  true,  false);
        prelude.defFix("(!=)",    3,  true,  false);
        prelude.defFix("(==)",    3,  true,  false);
        prelude.defFix("(&&)",    2,  false, false);
        prelude.defFix("(||)",    1,  false, false);
        prelude.defFix("($!)",    0,  true,  false);
        prelude.defFix("($)",     0,  false, false);
    }

    
    
    // Accessors
    
    public Properties getSystemProperties() {
        return setup;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public Eval getInterpreter() {
        return interpreter;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public void setInterpreter(Eval interpreter) {
        this.interpreter = interpreter;
    }

    public Module getPrelude() {
        return prelude;
    }        

    /**
     * Returns the current value of the state counter.
     */
    public BigInteger getUniqueState() {
        return uniqueState;
    }

    /**
     * Advances the state counter by one. Not synchronized.
     */
    public BigInteger advanceUniqueState() {
        uniqueState = uniqueState.add(BigInteger.ONE);
        return uniqueState;
    }
    
    public Product internSymbolAndClass(String name) throws ClassNotFoundException {
        Symbol sym = Symbol.intern(name);
        return productOf(sym, internClass(sym));
    }

    public Class<?> internClass(Symbol name) throws ClassNotFoundException {
        if (name.equals(PRIM_BOOLEAN)) return Boolean.TYPE;
        if (name.equals(PRIM_BYTE)) return Byte.TYPE;
        if (name.equals(PRIM_SHORT)) return Short.TYPE;
        if (name.equals(PRIM_CHAR)) return Character.TYPE;
        if (name.equals(PRIM_INT)) return Integer.TYPE;
        if (name.equals(PRIM_LONG)) return Long.TYPE;
        if (name.equals(PRIM_FLOAT)) return Float.TYPE;
        if (name.equals(PRIM_DOUBLE)) return Double.TYPE;
        if (!internedClasses.hasBinding(name)) {
            Class<?> c = Class.forName(name.toString());
            internedClasses.define(name, c);
        }
        return internedClasses.lookup(name);
    }
    
    public static List getVersion() {
        return listOf(Build.MAJOR_VERSION, Build.MINOR_VERSION, Build.RELEASE_VERSION);
    }


    // Data
    
    public static Symbol toVitryBool(boolean a) {
        return a ? TRUE : FALSE;
    }

    public static boolean toPrimBool(Symbol a) {
        return a != FALSE;
    }
    
    public static boolean isInvertible(Object f) {
        return (f instanceof InvertibleFunction);
    }

    public static Product product(Seq<Pattern> s) {
        if (Seqs.isNil(s)) return null; // TODO should be NIL
        if (s instanceof Product) return (Product) s;
        return productFrom(s);
    }

    public static List list(Seq<Pattern> s) {
        if (Seqs.isNil(s)) return NIL;
        if (s instanceof List) return (List) s;
        return listFrom(s);
    }

    public static Set set(Seq<Pattern> s) {
        if (Seqs.isNil(s)) throw new NullPointerException("Can not make a set from null");
        if (s instanceof Set) return (Set) s;
        return setFrom(s);
    }

    public static Union union(Seq<Pattern> s) {
        if (Seqs.isNil(s)) throw new NullPointerException("Can not make a union from null");
        if (s instanceof Union) return (Union) s;
        return unionFrom(s);
    }

    public static Intersection intersection(Seq<Pattern> s) {
        if (Seqs.isNil(s)) throw new NullPointerException("Can not make an intersection from null");
        if (s instanceof Intersection) return (Intersection) s;
        return intersectionFrom(s);
    }
    
    
    public static Product productOf(Object... args) {
        return productFrom(Native.wrapAll(new ArraySeq<Object>(args)));
    }

    public static List listOf(Object... args) {
        return listFrom(Native.wrapAll(new ArraySeq<Object>(args)));
    }

    public static Set setOf(Object... args) {
        return setFrom(Native.wrapAll(new ArraySeq<Object>(args)));
    }

    public static Union unionOf(Object... args) {
        return unionFrom(Native.wrapAll(new ArraySeq<Object>(args)));
    }

    public static Intersection intersectionOf(Object... args) {
        return intersectionFrom(Native.wrapAll(new ArraySeq<Object>(args)));
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




    // Private

//    private void def(Module mod, String name, Object val) {
//        mod.addValue(Symbol.intern(name), val);
//    }
//
//    private void defFix(Module mod, String name, int precedence, boolean assoc, boolean gathering) {
//        mod.addFixity(Symbol.intern(name), new Fixity(precedence, assoc, gathering));
//    }

    private Symbol nextUnique() {
        byte[] val = uniqueState.toByteArray();
        char[] str = new char[val.length / 2 + 1];
        for (int i = 0; i < val.length; i += 2) {
            if ( (str.length & 1) == 1) str[i / 2] = (char) (val[i]);
            else
                str[i / 2] = (char) ( (val[i] << 8) | val[i + 1]);

        }
        advanceUniqueState();
        return Symbol.intern(new String(str));
    }
}






final class Any extends Atom
{
    Any() {
    }

    public boolean eq(Atom o)
    {
        return o == this;
    }

    public boolean match(Atom o)
    {
        return true;
    }

    public boolean match(Product p)
    {
        return true;
    }

    public boolean match(Union p)
    {
        return true;
    }

    public boolean match(Set p)
    {
        return true;
    }

    public boolean match(Intersection p)
    {
        return true;
    }

    public boolean match(Type p)
    {
        return true;
    }

    public String toString()
    {
        return "_";
    }
}


final class Bottom extends AbstractSet
{
    Bottom() {
    }

    public boolean eq(Set o)
    {
        return o == this;
    }

    public boolean match(Set a)
    {
        return a == this;
    }

    public boolean match(Union a)
    {
        return false;
    }

    public boolean match(Intersection a)
    {
        return false;
    }

    public String toString()
    {
        return "{}";
    }

    public int hashCode()
    {
        return -1;
    }

    public boolean hasTail()
    {
        return false;
    }

    public Pattern head()
    {
        return throwUnsupported();
    }

    public Seq<Pattern> tail()
    {
        return throwUnsupported();
    }

    public Iterator<Pattern> iterator()
    {
        return ITER;
    }

    static <T> T throwUnsupported()
    {
        throw new UnsupportedOperationException("{} has no members.");
    }
    
    static final SeqIterator<Pattern> ITER = new Iter();
    
    static class Iter extends SeqIterator<Pattern>
    {
        private Iter() {
            super(VitryRuntime.NIL);
        }
        
        @Override
        public boolean hasNext()
        {
            return false;
        }
        
        @Override
        public Pattern next()
        {
            return Bottom.throwUnsupported();
        }
        
        @Override
        public void remove()
        {
            Bottom.throwUnsupported();
        }
    }
}


final class Nil extends Atom implements List, Finite<Pattern>
{
    Nil() {
    }

    public boolean eq(Atom o)
    {
        return o == this;
    }

    public String toString()
    {
        return "()";
    }

    public List cons(Pattern head)
    {
        // TODO product by default?
        return list(new Pair<Pattern>(head, this));
    }

    public boolean hasTail()
    {
        return false;
    }

    @SuppressWarnings("unchecked")
    public <U> Seq<U> map(Function fn)
    {
        return (Seq<U>) NIL;
    }

    public Product mapProduct(Function fn)
    {
        return throwUnsupported();
    }

    public List mapList(Function fn)
    {
        return NIL;
    }

    public int length()
    {
        return 0;
    }
    
    public Pattern head()
    {
        return throwUnsupported();
    }

    public Product tail()
    {
        return throwUnsupported();
    }

    public Iterator<Pattern> iterator()
    {
        return ITER;
    }

    public SeqIterator<Pattern> seqIterator()
    {
        return ITER;
    }

    public boolean canDestruct()
    {
        return false;
    }

    public Seq<Pattern> destruct()
    {
        return throwUnsupported();
    }

    static <T> T throwUnsupported()
    {
        throw new UnsupportedOperationException("() has no members.");
    }

    static final SeqIterator<Pattern> ITER = new Iter();
    
    static class Iter extends SeqIterator<Pattern>
    {
        private Iter() {
            super(VitryRuntime.NIL);
        }
        
        @Override
        public boolean hasNext()
        {
            return false;
        }
        
        @Override
        public Pattern next()
        {
            return Nil.throwUnsupported();
        }
        
        @Override
        public void remove()
        {
            Nil.throwUnsupported();
        }
    }

}




final class StdProduct extends AbstractProduct
{
    final Seq<Pattern> elements;

    public StdProduct(Seq<Pattern> elements) {
        this.elements = elements;
    }

    public Iterator<Pattern> iterator()
    {
        return elements.iterator();
    }

    final public Pattern head()
    {
        return elements.head();
    }

    public Product tail()
    {
        return product(elements.tail());
    }

    public boolean hasTail()
    {
        return elements.hasTail();
    }
}


final class StdList extends AbstractList
{
    final Seq<Pattern> elements;

    public StdList(Seq<Pattern> elements) {
        this.elements = elements;
    }

    public Iterator<Pattern> iterator()
    {
        return elements.iterator();
    }

    public Pattern head()
    {
        return elements.head();
    }

    public List tail()
    {
        return list(elements.tail());
    }

    public boolean hasTail()
    {
        return elements.hasTail();
    }
}


final class StdSet extends AbstractSet
{
    final Seq<Pattern> elements;

    public StdSet(Seq<Pattern> elements) {
        this.elements = elements;
    }

    public Iterator<Pattern> iterator()
    {
        return elements.iterator();
    }

    public Pattern head()
    {
        return elements.head();
    }

    public Set tail()
    {
        return set(elements.tail());
    }

    public boolean hasTail()
    {
        return elements.hasTail();
    }
}


final class StdUnion extends Union
{
    final Seq<Pattern> elements;

    public StdUnion(Seq<Pattern> elements) {
        this.elements = elements;
    }

    public Iterator<Pattern> iterator()
    {
        return elements.iterator();
    }

    public Pattern head()
    {
        return elements.head();
    }

    public Union tail()
    {
        return union(elements.tail());
    }

    public boolean hasTail()
    {
        return elements.hasTail();
    }
}


final class StdIntersection extends Intersection
{
    final Seq<Pattern> elements;

    public StdIntersection(Seq<Pattern> elements) {
        this.elements = elements;
    }

    public Iterator<Pattern> iterator()
    {
        return elements.iterator();
    }

    public Pattern head()
    {
        return elements.head();
    }

    public Intersection tail()
    {
        return intersection(elements.tail());
    }

    public boolean hasTail()
    {
        return elements.hasTail();
    }
}


final class eq extends Binary
{
    public Object apply(Object a, Object b)
    {
        if (b instanceof Pattern)
        {
            if (a instanceof Pattern)
            {
                return toVitryBool(( (Pattern) a).eqFor((Pattern) b));
            }
            return toVitryBool(( (Pattern) b).eq(a));
        }
        if (a instanceof Pattern)
        {
            return apply(b, a);
        }
        return toVitryBool(a.equals(b));
    }
}


final class product_ extends InvertibleRestFunction
{
    public Seq<?> applyVarInverse(Object obj) throws InvocationError
    {
        if (isNil(obj))
        {
            TypeError.throwWrongStructor(obj, this);
        }
        if (obj instanceof Product)
        {
            return Native.unwrapAll(((Destructible) obj).destruct());
        }
        if (obj instanceof List)
        {
            List l = (List) obj;
            Object x        = Native.unwrap(l.head());
            Seq<Pattern> xs = list((List) obj).tail();

            // FIXME should wrap in Native
//            return VitryRuntime.productOf(x, xs);
            return new ArraySeq<Object>(new Object[]{x, xs});
        }
        return TypeError.throwWrongStructor(obj, this);
    }

    public Object applyVar(Seq<?> args)
    {
        return VitryRuntime.productOf(Seqs.toArray(args));
    }

    public String toString()
    {
        return "(,)";
    }
}


final class list_ extends InvertibleRestFunction
{
    public Seq<?> applyVarInverse(Object a) throws InvocationError
    {
        if (a instanceof List)
        {
            return Native.unwrapAll(((List) a).destruct());
        }
        return TypeError.throwWrongStructor(a, this);
    }

    public Object applyVar(Seq<?> args)
    {
        return VitryRuntime.listOf(Seqs.toArray(args));
    }

    public String toString()
    {
        return "[,]";
    }
}


final class set_ extends RestFunction
{
    public Object applyVar(Seq<?> args)
    {
        return VitryRuntime.setOf(Seqs.toArray(args));
    }

    public String toString()
    {
        return "{,}";
    }
}


final class union_ extends RestFunction
{
    public Object applyVar(Seq<?> args)
    {
        return VitryRuntime.unionOf(Seqs.toArray(args));
    }

    public String toString()
    {
        return "(|)";
    }
}


final class intersection_ extends RestFunction
{
    public Object applyVar(Seq<?> args)
    {
        return VitryRuntime.intersectionOf(Seqs.toArray(args));
    }

    public String toString()
    {
        return "(&)";
    }
}


//final class not extends Unary
//{
//    public Object apply(Object a) throws InvocationError
//    {
//        if (a.equals(TRUE))
//            return FALSE;
//        if (a.equals(FALSE))
//            return TRUE;
//        throw new TypeError("Expected bool");
//    }
//}


final class arity_ extends Unary
{
    public Object apply(Object a)
    {
        return ((Arity) a).getArity();
    }
}


final class id extends Unary
{
    public Object apply(Object a)
    {
        return a;
    }
}


final class const_ extends Unary
{
    public Object apply(final Object a)
    {
        return new Unary()
            {
                public Object apply(Object b)
                {
                    return a;
                }
            };
    }
}


final class flip extends Unary
{
    public Object apply(final Object f)
    {
        return new Binary() {
            public Object apply(Object x, Object y) throws InvocationError
            {
                return ((Function) f).apply(y, x);
            }
        };
    }
}






final class compose extends Binary
{
    public Object apply(final Object f, final Object g)
    {
        return new Unary() {
            public Object apply(Object x) throws InvocationError
            {
                return ((Function) f).apply( ((Function) g).apply(x));
            }
        };
    }
}
final class follow extends Binary
{
    public Object apply(final Object f, final Object g)
    {
        return new Unary() {
            public Object apply(Object x) throws InvocationError
            {
                return ((Function) g).apply( ((Function) f).apply(x));
            }
        };
    }
}
final class prepend extends Binary
{
    public Object apply(Object x, Object xs)
    {
        if (xs instanceof String) {
            xs = list(Native.wrapAll(CharSeq.from((String) xs)));
        }
        return list(Seqs.cons(Native.wrap(x), (List) xs));
    }
}

final class head extends Unary
{
    public Object apply(Object xs)
    {
        if (xs instanceof String) {
            xs = CharSeq.from((String) xs);
        }
        return Native.unwrap(((Seq<?>) xs).head());
    }
}


final class tail extends Unary
{
    public Object apply(Object xs)
    {
        if (xs instanceof String) {
            xs = list(Native.wrapAll(CharSeq.from((String) xs)));
        }
        return ((List) xs).tail();
    }
}


final class conc extends Binary
{
    public Object apply(Object a, Object b)
    {
        // TODO is unwrapping necessary?
        if (a instanceof List)
        {
            if (b instanceof List)
            {
                return list(Seqs.concat((List) a, (List) b));
            }
            else
            {
                String a2 = CharSeq.toString(Native.unwrapAll((Seq<Pattern>) a));
                String b2 = (String) Native.unwrap(b);
                return (a2).concat(b2);
            }
        }
        else
        {

            if (b instanceof List)
            {
                String a2 = (String) Native.unwrap(a);
                String b2 = CharSeq.toString(Native.unwrapAll((Seq<Pattern>) b));
                return (a2).concat(b2);
            }
            else
            {
                a = Native.unwrap(a);
                b = Native.unwrap(b);
                return ((String) a).concat((String) b);
            }
        }
    }
}






final class map extends Binary
{
    public Object apply(Object f, Object xs)
    {
        if (xs instanceof String) {
            xs = list(Native.wrapAll(CharSeq.from((String) xs)));
        }
        if (Seqs.isNil(xs)) return NIL;
        return ((List) xs).mapList((Function) f);
    }
}


final class foldl extends StandardFunction
{
    public foldl() {
        super(3);
    }

    public Object apply(Object f, Object u, Object xs)
    {
        if (xs instanceof String) {
            xs = list(Native.wrapAll(CharSeq.from((String) xs)));
        }
        if (Seqs.isNil((Seq<?>) xs)) return u;
        return Seqs.foldlUnwrap((Function) f, u, (List) xs);
    }
}


final class foldr extends StandardFunction
{
    public foldr() {
        super(3);
    }

    public Object apply(Object f, Object u, Object xs)
    {
        if (xs instanceof String) {
            xs = list(Native.wrapAll(CharSeq.from((String) xs)));
        }
        return Seqs.foldrUnwrap((Function) f, u, (List) xs);
    }
}

final class nth extends StandardFunction
{
    public nth() {
        super(2);
    }

    public Object apply(Object n, Object xs)
    {
        if (xs instanceof String) {
            xs = CharSeq.from((String) xs);
        }
        return Native.unwrap(Seqs.nth((Seq<?>) xs, ((Number) n).intValue()));
    }
}


final class range extends Binary
{
    public Object apply(Object min, Object max)
    {
        BigInteger minNum = (BigInteger) min;
        BigInteger maxNum = (BigInteger) max;
        if (minNum.compareTo(maxNum) >= 0) return NIL;
        return list(Native.wrapAll(new Range(minNum, maxNum)));
    }
}





final class symbol_ extends Unary
{
    public Object apply(Object a)
    {
        if (a instanceof Seq) 
            a = CharSeq.toString((Seq<?>) a);
        return Symbol.intern((String) a);
    }
}

final class string_ extends Unary
{
    public Object apply(Object a) throws InvocationError
    {
        return a.toString();
    }
}

final class seq extends StandardFunction.Unary
{
    public Object apply(Object a) {
        return listOf((Object[]) a);
    }
}

final class array extends StandardFunction.Unary
{
    public Object apply(Object a) {
        return Seqs.toArray(Native.unwrapAll((Seq<?>) a));
    }
}

final class random extends Unary
{

    public Object apply(Object a) throws InvocationError
    {
//        a = Native.unwrap(a);
        return BigInteger.valueOf((long) (Math.random() * ((Number) a).longValue()));
    }
}

final class eval_ extends StandardFunction
{
    private VitryRuntime rt;

    public eval_(VitryRuntime rt) {
        super(1, rt.getPrelude());
        this.rt = rt;
    }

    public Object apply(Object a)
    {
        return rt.getInterpreter().eval(a);
    }
}

class print extends StandardFunction
{
    private VitryRuntime rt;

    public print(VitryRuntime rt) {
        super(1, rt.getPrelude());
        this.rt = rt;
    }

    public Object apply(Object a) {
        System.out.println(a);
        return a;
    }
}

class error_ extends StandardFunction
{
    private VitryRuntime rt;

    public error_(VitryRuntime rt) {
        super(1, rt.getPrelude());
        this.rt = rt;
    }

    public Object apply(Object a) {
        throw new StandardError((String) a);
    }
}

class quit extends StandardFunction
{
    public quit() {
        super(1);
    }

    public Object apply(Object a) throws InvocationError {
        if (a instanceof Number)
            System.exit(((Number) a).intValue());
        else
            System.exit(-1);

        // Never reached
        throw new AssertionError();
    }
}

class now extends StandardFunction
{
    private VitryRuntime rt;

    public now(VitryRuntime rt) {
        super(1, rt.getPrelude());
        this.rt = rt;
    }

    public Object apply(Object a) {
        return BigInteger.valueOf(System.currentTimeMillis());
    }
}

class class_ extends StandardFunction
{
    private static final String[] AUTO_PREFIXES = { 
        "", 
        "java.lang.", 
        "vitry.runtime.",
        "vitry.prelude." 
    };

    final VitryRuntime rt;

    public class_(VitryRuntime rt) {
        super(1);
        this.rt = rt;
    }


    /**
     * type class = symbol
     * 
     * class : str -> class
     * 
     * Loads the given class using reflection and returns a symbol
     * referencing it.
     */
    public Object apply(Object nameStr) throws InvocationError
    {
        Object res = null;
        for (String p : AUTO_PREFIXES)
        {
            try
            {
                res = Seqs.first(rt.internSymbolAndClass(p + ((String) nameStr)));
            }
            catch (ClassNotFoundException _)
            {
            }
        }
        if (res != null)
            return res;
        else
            throw new ResolveError("Could not find class " + nameStr);
    }
}

class classOf extends StandardFunction
{
    final VitryRuntime rt;

    public classOf(VitryRuntime rt) {
        super(1);
        this.rt = rt;
    }

    /**
     * a:_ -> class
     * Returns a reference to the class of a.
     */
    public Object apply(Object obj) throws InvocationError {
        Symbol ref = Symbol.intern(obj.getClass().getName());
        try {
            rt.internClass(ref);
        } catch (ClassNotFoundException e) {
            throw new AssertionError("Failed interning a loaded class");
        }
        return ref;
    }
}

final class method extends StandardFunction
{

    private static final Class<?>[] dummy = new Class<?>[0];

    private final VitryRuntime rt;

    public method(VitryRuntime rt, Scope prelude) {
        super(3, prelude);
        this.rt = rt;
    }

    /**
     * class, name:str, [types] -> (... -> a)
     * 
     * Returns a function wrapping a method.
     */
    public Object apply(Object r, Object n, Object t) throws InvocationError
    {
        Symbol className = Utils.maybeIntern(r);
        String methodName = n.toString();
        Seq<Symbol> typeNames = (Seq<Symbol>) t;
        final Method m;

        try
        {
            Class<?> clazz = rt.internClass(className);
            Class<?>[] types = null;
            if (typeNames != null)
            {
                types = Seqs.toArray(typeNames.<Class<?>> map(new StandardFunction.Unary()
                    {
                        public Object apply(Object n) throws InvocationError
                        {
                            try
                            {
                                return rt.internClass((Symbol) n);
                            }
                            catch (ClassNotFoundException _)
                            {
                            }
                            return throwResolveClass(n);
                        }
                    }), dummy);
            }

            m = clazz.getMethod(methodName, types);
            final int arity = types.length + (isStatic(m) ? 0 : 1);

//            System.err.println(m);

            switch (arity) {
                case 0:
                    return new StandardFunction(1) {
                        public Object apply(Object _) throws InvocationError
                        {
                            try
                            {
                                return m.invoke(null);
                            }
                            catch (Exception e)
                            {
                            }
                            return throwInvoke(m);
                        }
                    };
                case 1:
                    return new StandardFunction(1) {
                        public Object apply(Object a) throws InvocationError
                        {
//                            a = Native.unwrap(a);
                            try
                            {
                                if (isStatic(m))
                                    return m.invoke(null, a);
                                else
                                    return m.invoke(a);
                            }
                            catch (Exception e)
                            {
                            }
                            return throwInvoke(m, a);
                        }
                    };
                case 2:
                    return new StandardFunction(2) {
                        public Object apply(Object a, Object b) throws InvocationError
                        {
//                            a = Native.unwrap(a);
//                            b = Native.unwrap(b);
                            try
                            {
                                if (isStatic(m))
                                    return m.invoke(null, a, b);
                                else
                                    return m.invoke(a, b);
                            }
                            catch (Exception e)
                            {
                            }
                            return throwInvoke(m, a);
                        }
                    };
                case 3:
                    return new StandardFunction(3) {
                        public Object apply(Object a, Object b, Object c) throws InvocationError
                        {
//                            a = Native.unwrap(a);
//                            b = Native.unwrap(b);
//                            c = Native.unwrap(c);
                            try
                            {
                                if (isStatic(m))
                                    return m.invoke(null, a, b, c);
                                else
                                    return m.invoke(a, b, c);
                            }
                            catch (Exception e)
                            {
                            }
                            return throwInvoke(m, a);
                        }
                    };
                case 4:
                    return new StandardFunction(4) {
                        public Object apply(Object a, Object b, Object c, Object d) throws InvocationError
                        {
//                            a = Native.unwrap(a);
//                            b = Native.unwrap(b);
//                            c = Native.unwrap(c);
//                            d = Native.unwrap(d);
                            try
                            {
                                if (isStatic(m))
                                    return m.invoke(null, a, b, c, d);
                                else
                                    return m.invoke(a, b, c, d);
                            }
                            catch (Exception e)
                            {
                            }
                            return throwInvoke(m, a);
                        }
                    };
                case 5:
                    return new StandardFunction(5) {
                        public Object apply(Object a, Object b, Object c, Object d, Object e) throws InvocationError
                        {
//                            a = Native.unwrap(a);
//                            b = Native.unwrap(b);
//                            c = Native.unwrap(c);
//                            d = Native.unwrap(d);
//                            e = Native.unwrap(e);
                            try
                            {
                                if (isStatic(m))
                                    return m.invoke(null, a, b, c, d, e);
                                else
                                    return m.invoke(a, b, c, d, e);
                            }
                            catch (Exception ex)
                            {
                            }
                            return throwInvoke(m, a);
                        }
                    };
                default:
                    throw new RuntimeException("Has not implemented reflection for arity > 5");
            }
        }
        catch (ClassNotFoundException e)
        {
            return throwResolveClass(className);
        }
        catch (SecurityException e)
        {
            return throwResolveMethod(methodName);
        }
        catch (NoSuchMethodException e)
        {
            return throwResolveMethod(methodName);
        }
    }

    boolean isStatic(final Method m)
    {
        return Modifier.isStatic(m.getModifiers());
    }
    
    

    <T> T throwInvoke(Method method)
    {
        throw new InvocationError("Could not call method " + method + " for no arguments");
    }

    <T> T throwInvoke(Method method, Object args) throws InvocationError
    {
        throw new InvocationError("Could not call method " + method + " for arguments " + args);
    }
    
    <T> T throwResolveMethod(Object name) throws ResolveError
    {
        throw new ResolveError("Could not find method " + name);
    }

    <T> T throwResolveClass(Object name) throws ResolveError
    {
        throw new ResolveError("Could not find class " + name);
    }
}

class new_ extends StandardFunction
{
    private VitryRuntime rt;

    public new_(VitryRuntime rt) {
        super(1, rt.getPrelude());
        this.rt = rt;
    }

    /**
     * sym -> instance
     * 
     * TODO arguments to constructors 
     */
    public Object apply(Object c) {
        try
        {
            return rt.internClass((Symbol) c).newInstance();
        }
        catch (Exception _)
        {
            throw new ResolveError("Could not initiate class" + c);
        }
    }
}