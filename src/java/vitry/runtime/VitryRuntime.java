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

import vitry.runtime.struct.Sequence;


/**
 * This class encapsulates an entire runtime system. That is, a set of system
 * properties, a set of loaded modules and possibly an interpreter.
 * Implements functions and types needed to bootstrap <code>Vitry.Prelude</code>.
 * 
 * The native types we use are:
 * <pre><code>
 *     BigInteger   <=> nat
 *     BigInteger   <=> int
 *     BigRational  <=> rat
 *     Float        <=> float
 *     Double       <=> double
 *     String       <=> str
 * </code></pre>
 * 
 * @author Hans Höglund
 */
public class VitryRuntime
    {
        
        /**
         * Standard operator bindings.
         */
        static class Ops
            {
                // !
                public static final Apply _21 = null;
                // #
                public static final Apply _23 = null;
                // $
                public static final Apply _24 = null;
                // %
                public static final Apply _25 = mod;
                // &
                public static final Apply _26 = intersection;
                // '
                public static final Apply _27 = add;
                // *
                public static final Apply _2A = mul;
                // +
                public static final Apply _2B = add;
                // ,
                public static final Apply _2C = product;
                // -
                public static final Apply _2D = sub;
                // /
                public static final Apply _2F = div;
                
                // ;
                public static final Apply _3B = null;
                // <
                public static final Apply _3C = less;
                // >
                public static final Apply _3E = greater;
                // ?
                public static final Any _3F = any;
                // @
                public static final Apply _40 = null;
                
                // ^
                public static final Apply _5E = null;
                // _
                public static final Apply _5F = null;
                
                // |
                public static final Apply _7C = union;
                // ~
                public static final Apply _7F = not;

                
                // ==
                public static final Apply _3D_3D = eq;
                // []
                public static final Apply _5B_5D = list;
                // {}
                public static final Apply _7B_7D = set;
                
                // TODO precedence rules
            }
        
        

        // ()
        public static final Nil        nil = new Nil();

        // {}
        public static final Bottom   bottom = Bottom.instance;
        
        // _
        public static final Any    any = new Any();

        
        
        // ==
        public static final Apply eq = new Function(
                2, 
                fnType(any, any))
            {
                public Object apply(Object a, Object b) {
                    return null; // TODO
                }
            };
            

        // Basic types
        
        // type bool = `true | `false
        public static final Symbol true_   = Symbol.intern("true");
        public static final Symbol false_  = Symbol.intern("false");
        public static final Type   bool    = symType("bool", new SimpleUnion(true_, false_));
        
        // type 
        //   nat    = ...
        //   int    = ...
        //   rat    = ...
        //   float  = ...
        //   double = ...
        //   str    = ...
        public static final SetLike    nat     = NativeType.forClass(BigInteger.class);
        public static final SetLike    int_    = NativeType.forClass(BigInteger.class);
        public static final SetLike    rat     = NativeType.forClass(BigRational.class);
        public static final SetLike    float_  = NativeType.forClass(Float.class);
        public static final SetLike    double_ = NativeType.forClass(Double.class);
        public static final SetLike    str     = NativeType.forClass(String.class);

        //
        // implicit
        //   bool  -> nat
        //   nat   -> int
        //   int   -> rat
        //   int   -> float
        //   float -> complex 
        //   
        //   [a]           <-> int -> a
        //   [(a, b)]      ->  a -> b
        //   {a}           <-> a -> bool
        //   a, b ...      <-> [a | b ...]
        //   
        //   ; Set vs type ??                   
        //   [a]           -> {a}
        //   {a}           -> [a]
        //   {a}, a -> int -> [a]
        //   [{a}], a -> int -> [a]
        //   
        // ; Basic logic
        // (==)
        // (/=)
        // not
        // true
        // false

        // ; Functions
        // arity     : ? -> nat
        public static final Apply arity = new Function(
                1, 
                fnType(any, nat))
            {
                public Object apply(Object a) {
                    return ((Function) a).arity;
                }
            };

        //
        // id        : (a -> a)
        public static final Apply id = new Function(1, null)
            {
                public Object apply(Object a) {
                    return a;
                }
            };


        // const     : a -> (? -> a)
        public static final Apply const_ = new Function(1, null)
            {
                public Object apply(final Object a) {
                    return new Function(1, null)
                        {
                            public Object apply(Object b) {
                                return a;
                            }
                        };
                }
            };

        // compose   : (b -> c), (a -> b) -> (a -> c)
        // sequence  : (a -> b), (b -> c) -> (a -> c)
        // flip      : (a, b -> c) -> (b, a -> c)
        // 
        // apply     : (a -> b), a -> b
        // curry     : a, b -> c -> (a -> b -> c)
        // uncurry   : (a -> b -> c) -> a, b -> c
        // power     : (a -> b), int -> (a -> b)
        // 
        // implicit                              
        //   curry
        //   uncurry
        //   const

            
            
        // Arithmetic
            
        // As overloaded functions, the arithmetic operators could technically
        // be handled by the matching logic. Here we do explicit checks to speed
        // things up a bit.
            
        static class ArithmeticFunction extends Function {
                // TODO factor out instance checks to here
                // Try to avoid call overhead
        }
            
        public static final Apply neg = new Function(1, null)
            {
                public Object apply(Object a) {
                    if (a instanceof BigRational) return ((BigRational) a).negate();
                    if (a instanceof BigInteger)  return ((BigInteger) a).negate();
                    if (a instanceof Number)      return ((Number) a).floatValue() * -1;
                    throw new RuntimeException("Expected number type.");
                }
            };
            
        // + 
        public static final Apply add = new Function(2, null)
            {
                public Object apply(Object a, Object b) {
                    if (a instanceof BigRational) {
                        if (b instanceof BigRational) return ((BigRational) a).add((BigRational) b);
                        else if (b instanceof Number) return ((BigRational) a).add(((Number) b).longValue());
                        throw new RuntimeException("Expected number type.");
                    }
                    if (a instanceof BigInteger)  {
                        if (b instanceof BigInteger)  return ((BigInteger) a).add((BigInteger) b);
                        // TODO
                        throw new RuntimeException("Expected number type.");
                    }
                    if (a instanceof Double)      {
                        if (b instanceof Number)      return ((Double) a) + ((Number) b).doubleValue();
                        throw new RuntimeException("Expected number type.");
                    }
                    if (a instanceof Float)      {
                        if (b instanceof Number)      return ((Float) a) + ((Number) b).floatValue();
                        throw new RuntimeException("Expected number type.");
                    }
                    throw new RuntimeException("Expected number type.");
                }
            };

            
        // -
        public static final Apply sub = new Function(2, null)
            {
                public Object apply(Object a, Object b) {
                    if (a instanceof BigRational) {
                        if (b instanceof BigRational) return ((BigRational) a).subtract((BigRational) b);
                        else if (b instanceof Number) return ((BigRational) a).subtract(((Number) b).longValue());
                        throw new RuntimeException("Expected number type.");
                    }
                    if (a instanceof BigInteger)  {
                        if (b instanceof BigInteger)  return ((BigInteger) a).subtract((BigInteger) b);
                        throw new RuntimeException("Expected number type.");
                    }
                    if (a instanceof Double)      {
                        if (b instanceof Number)      return ((Double) a) - ((Number) b).doubleValue();
                        throw new RuntimeException("Expected number type.");
                    }
                    if (a instanceof Float)      {
                        if (b instanceof Number)      return ((Float) a) - ((Number) b).floatValue();
                        throw new RuntimeException("Expected number type.");
                    }
                    throw new RuntimeException("Expected number type.");
                }
            };

        // *
        public static final Apply mul = new Function(2, null)
            {
                public Object apply(Object a, Object b) {
                    if (a instanceof BigRational) {
                        if (b instanceof BigRational) return ((BigRational) a).multiply((BigRational) b);
                        else if (b instanceof Number) return ((BigRational) a).multiply(((Number) b).longValue());
                        throw new RuntimeException("Expected number type.");
                    }
                    if (a instanceof BigInteger)  {
                        if (b instanceof BigInteger)  return ((BigInteger) a).multiply((BigInteger) b);
                        throw new RuntimeException("Expected number type.");
                    }
                    if (a instanceof Double)      {
                        if (b instanceof Number)      return ((Double) a) * ((Number) b).doubleValue();
                        throw new RuntimeException("Expected number type.");
                    }
                    if (a instanceof Float)      {
                        if (b instanceof Number)      return ((Float) a) * ((Number) b).floatValue();
                        throw new RuntimeException("Expected number type.");
                    }
                    throw new RuntimeException("Expected number type.");
                }
            };


        // /
            public static final Apply div = new Function(2, null)
            {
                public Object apply(Object a, Object b) {
                    if (a instanceof BigRational) {
                        if (b instanceof BigRational) return ((BigRational) a).divide((BigRational) b);
                        else if (b instanceof Number) return ((BigRational) a).divide(((Number) b).longValue());
                        throw new RuntimeException("Expected number type.");
                    }
                    if (a instanceof BigInteger)  {
                        if (b instanceof BigInteger)  return ((BigInteger) a).divide((BigInteger) b);
                        throw new RuntimeException("Expected number type.");
                    }
                    if (a instanceof Double)      {
                        if (b instanceof Number)      return ((Double) a) / ((Number) b).doubleValue();
                        throw new RuntimeException("Expected number type.");
                    }
                    if (a instanceof Float)      {
                        if (b instanceof Number)      return ((Float) a) / ((Number) b).floatValue();
                        throw new RuntimeException("Expected number type.");
                    }
                    throw new RuntimeException("Expected number type.");
                }
            };


        // %
        public static final Apply mod = new Function(2, null)
            {
                public Object apply(Object a, Object b) {
                    return null; // TODO
                }
            };


        // (%%)
        public static final Apply modp = new Function(2, null)
            {
                public Object apply(Object a, Object b) {
                    return null; // TODO
                }
            };
            
        // (^)
        // modp
            
            
        // pow
        public static final Apply pow = new Function(2, null)
        {
            public Object apply(Object a, Object b) {
                if (a instanceof BigRational) return ((BigRational) a).pow(((Number) b).intValue());
                if (a instanceof BigInteger)  return ((BigInteger) a).pow(((Number) b).intValue());
                if (a instanceof Number)      return Math.pow(((Number) a).doubleValue(), ((Number) b).doubleValue());
                throw new RuntimeException("Expected number type.");
            }
        };
            
        // log
        // ln
        // sin
        // cos
        // asin
        // acos
        // round
        // ceil
        // floor
        // repr
        // succ
        // sum
        // prod
        // gcd
        // lcm
        // 
        // odd
        // even
        // prime


        
        
        // Sets
                
        // union         : {a} -> {a}
         public static final Function union = new RestArgFunction(
                 2, 
                 null) {
             public Object apply(Object elem) {
                 if (elem instanceof Object[])
                     return new SimpleUnion((Object[]) elem);
                 else
                     return new SimpleUnion(elem);
             }
         };

        // intersection  : {a} -> {a}
         public static final Function intersection = new Function(
                 2, 
                 null) {
             public Object apply(Object elem) {
                 if (elem instanceof Object[])
                     return new SimpleIntersection((Object[]) elem);
                 else
                     return new SimpleIntersection(elem);
             }
         };
         
         
         // symdif        : {a} -> {a}
         // powerset      : {a} -> {a}
         // subset        : {a}, {a} -> bool
         // propsubset    : {a}, {a} -> bool
         // superset      : {a}, {a} -> bool
         // propsuperset  : {a}, {a} -> bool
          

        
         // Products and lists

        // 
        // first       : [a] -> a
        // rest        : [a] -> [a]
        // last        : [a] -> a
        // init        : [a] -> [a]
        // cons        : a, [a] -> a
        // 
        // length      : [a] -> nat
        // rank        : [a] -> nat
        // empty       : [a] -> bool
        // single      : [a] -> bool
        // 
        // nth         : [a], int    -> a
        // apply       : [a], [a] -> b -> b
        // fold        : [a], (b, a -> b), b -> b
        // foldr       : [a], (a, b -> b), b -> b
        // 
        // ; ... arithmetic ops and fns ...
        //
        //                                 
        // ; How about partial application ([a] should not be first arg). Use flip?
        // concat      : [a], [a] -> [a]
        // append      : [a], a -> [a]
        // prepend     : [a], a -> [a]
        // remove      : [a], int -> [a]
        // insert      : [a], int, a -> [a]
        // subst       : [a], int, a -> [a]
        // subseq      : [a], int, int -> [a]
        // drop        : [a], int    -> [a]
        // take        : [a], int    -> [a]
        // map         : [a], a -> b -> [b]
        // remove      : [a], (a -> bool) -> [a]
        // retain      : [a], (a -> bool) -> [a]
        // 
        // reverse     : [a] -> [a]
        // sort        : [a] -> [a]
        // search      : [a], a -> int
        // shuffle     : [a] -> [a]
        // permute     : [a] -> [[a]]
        // permute     : [a], int -> [[a]]
        // partition   : [a], int -> [[a]]
        // 
        // zip
        // zipn ; ??
        //
        // some        : [a], (a -> bool) -> ([a] -> bool) 
        // every       : [a], (a -> bool) -> ([a] -> bool)
         
         
         
         // ; Standard notion of bounds and enumerable seqs (Haskell-like?)
         // 
         // ; Well-known sequences (lazy lists)
         // fibbonaci : [nat]
         // harmonic  : [nat]
         // prime     : [nat]
        
          
         // ; Randomness                 
         // rand : [int]
         // 
         // ; TODO overloads with ability to select seed and distribution
         // ; pink, brown, low, high, middle, gauss, exp, beta, gamma, cauchy, poisson                                             
         //
         // ; Each take a random sequence or use default (rand with no args, meaning 
         // ; random seed).
         // pick        : [a]         -> a
         // pick        : [a], [int]  -> a
         // pick        : [int], [a]  -> a
         // shuffle     : [a]         -> [a]
         // shuffle     : [a], [int]  -> [a]
         // shuffle     : [int], [a]  -> [a]
         
         
         
        // ; "Pdef"-style lazy sequences
        // interleave  : [a] -> [a]                          
        // cycle
        // palindrome
        // repeat
        // rotation
        //
        // 
        // 
        // 
        // 
        // 
        // ; Environment
        // require     : string -> module
        // load        : string ->
        // print       : string ->
        // error       : string ->
        // now         : int
        // version     : [nat]
        // versionStr  : string               
        // 
        // show        : ? ->
        // read        : -> ?
        // help        : ->
            
        public static Apply not;



        public static Apply less;



        public static Apply greater;



        public static Apply list;



        public static Apply set;



        public static Apply product;



        // quit        : ->
        public static final Apply quit = new Function(
                1, 
                fnType(any, any)){
            
            public Object apply(Object a) throws InvocationError {
                if (a instanceof Number)
                    System.exit(((Number) a).intValue());
                else
                    System.exit(-1);
                
                // Never reached
                return null;
            }
            
        };
        
        // unique
        public static final List unique = new List(){

            public Pattern head() {
                return null;
                // TODO Auto-generated method stub
            }

            public Sequence<Pattern> tail() {
                return null;
                // TODO Auto-generated method stub
            }
        };
        
        
        public static Arrow fnType(Pattern co, Pattern dom) {
            return new Arrow(co, dom);
        }
            
        public static Type symType(String name, Pattern pattern) {
            return new Type(pattern, Symbol.intern(name), null);
            // TODO
        }

        
        
        
        public static Scope stdScope = new Scope()
            {
                public Environment<Symbol, Object> environment() {
                    return prelude;
                }
            };

        static Environment<Symbol, Object> prelude = new HashEnvironment<Symbol, Object>();
        static {
            prelude.define( Symbol.intern("()"),       nil );
            prelude.define( Symbol.intern("[]"),       nil );
            prelude.define( Symbol.intern("{}"),       nil );
            prelude.define( Symbol.intern("`()"),      nil );
            prelude.define( Symbol.intern("`[]"),      nil );
            prelude.define( Symbol.intern("`{}"),      bottom );
            prelude.define( Symbol.intern("nil"),      nil );
            prelude.define( Symbol.intern("=="),       eq );
            prelude.define( Symbol.intern("eq"),       eq );
            prelude.define( Symbol.intern("bool"),     bool );
            prelude.define( Symbol.intern("true"),     true_ );
            prelude.define( Symbol.intern("false"),    false_ );
            prelude.define( Symbol.intern("int"),      int_ );
            prelude.define( Symbol.intern("nat"),      nat );
            prelude.define( Symbol.intern("rat"),      rat );
            prelude.define( Symbol.intern("float"),    float_ );
            prelude.define( Symbol.intern("double"),   double_ );
            prelude.define( Symbol.intern("str"),      str );
            prelude.define( Symbol.intern("id"),       id );
            prelude.define( Symbol.intern("add"),      add );
            prelude.define( Symbol.intern("sub"),      sub );
            prelude.define( Symbol.intern("mul"),      mul );
            prelude.define( Symbol.intern("div"),      div );
            prelude.define( Symbol.intern("mod"),      mod );
            prelude.define( Symbol.intern("quit"),     quit );
            prelude.define( Symbol.intern("unique"),   unique );
            prelude.define( Symbol.intern("arity"),    arity );
        }
        
        
        
        
        
        
        
        private static BigInteger uniqueState = BigInteger.valueOf(0x2177375305f7L);
        
        public static Symbol unique() {
            byte[] val = uniqueState.toByteArray();
            char[] str = new char[val.length/2 + 1];
            for (int i = 0; i < val.length; i += 2) {
                if ((str.length & 1) == 1)
                        str[i/2] = (char) (val[i]);
                    else 
                        str[i/2] = (char) ((val[i] << 8) | val[i+1]);
                        
            }
            uniqueState = uniqueState.add(BigInteger.ONE);
            return Symbol.intern(new String(str));
        }

        public static Pattern product(Object... args) {
            return new SimpleProduct(args);
        }

        public static Pattern set(Object... args) {
            return new SimpleSet(args);
        }

        public static Pattern union(Object... args) {
            return new SimpleUnion(args);
        }

        public static Pattern intersection(Object... args) {
            return new SimpleIntersection(args);
        }
        
        
        
        
        

    }
