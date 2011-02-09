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

import vitry.prelude.*;
import vitry.runtime.struct.*;


/**
 * This class encapsulates the runtime system. 
 *
 * TODO
 * 
 * @author Hans Höglund
 */
public class VitryRuntime
    {

        public static final Nil      NIL    = new Nil();
        public static final Bottom   BOTTOM = new Bottom();
        public static final Any      ANY    = new Any();
        public static final Symbol   TRUE   = Symbol.intern("true");
        public static final Symbol   FALSE  = Symbol.intern("false");
        public static final Type     BOOL   = symType("bool", new SimpleUnion(TRUE, FALSE));

        public static final Set      NAT    = NativeSet.forClass(BigInteger.class);
        public static final Set      INT    = NativeSet.forClass(BigInteger.class);
        public static final Set      RAT    = NativeSet.forClass(BigRational.class);
        public static final Set      FLOAT  = NativeSet.forClass(Float.class);
        public static final Set      DOUBLE = NativeSet.forClass(Double.class);
        public static final Set      STR    = NativeSet.forClass(String.class);
        
        


        public static final List unique = (new List()
            {

                public Pattern head() {
                    return null;
                    // TODO Auto-generated method stub
                }

                public Sequence<Pattern> tail() {
                    return null;
                    // TODO Auto-generated method stub
                }
            });


        public static Symbol toVitryBool(boolean a) {
            return a ? TRUE : FALSE;
        }

        public static Type symType(String name, Pattern pattern) {
            return new Type(pattern, Symbol.intern(name), null);
        }


        static Environment<Symbol, Object>        prelude         = new HashEnvironment<Symbol, Object>();
        static {
            prelude.define(Symbol.intern("()"), NIL);
            prelude.define(Symbol.intern("[]"), NIL);
            prelude.define(Symbol.intern("{}"), BOTTOM);
            prelude.define(Symbol.intern("nil"), NIL);
            prelude.define(Symbol.intern("=="), new eq());
            prelude.define(Symbol.intern("eq"), prelude.lookup(Symbol.intern("==")));
            prelude.define(Symbol.intern("bool"), BOOL);
            prelude.define(Symbol.intern("true"), TRUE);
            prelude.define(Symbol.intern("false"), FALSE);
            prelude.define(Symbol.intern("int"), INT);
            prelude.define(Symbol.intern("nat"), NAT);
            prelude.define(Symbol.intern("rat"), RAT);
            prelude.define(Symbol.intern("float"), FLOAT);
            prelude.define(Symbol.intern("double"), DOUBLE);
            prelude.define(Symbol.intern("str"), STR);
            prelude.define(Symbol.intern("id"), new id());
            prelude.define(Symbol.intern("const"), new const_());   

            // Test constructor
            prelude.define(Symbol.intern("cons"), new cons());   

            
            prelude.define(Symbol.intern("add"), new add());
            prelude.define(Symbol.intern("sub"), new sub());
            prelude.define(Symbol.intern("mul"), new mul());
            prelude.define(Symbol.intern("div"), new div());
            prelude.define(Symbol.intern("mod"), new mod());
            prelude.define(Symbol.intern("modp"), new modp());

            prelude.define(Symbol.intern("(+)"), prelude.lookup(Symbol.intern("add")));
            prelude.define(Symbol.intern("(-)"), prelude.lookup(Symbol.intern("sub")));
            prelude.define(Symbol.intern("(*)"), prelude.lookup(Symbol.intern("mul")));
            prelude.define(Symbol.intern("(/)"), prelude.lookup(Symbol.intern("div")));
            prelude.define(Symbol.intern("(%)"), prelude.lookup(Symbol.intern("mod")));
            prelude.define(Symbol.intern("(%%)"), prelude.lookup(Symbol.intern("modp")));
            prelude.define(Symbol.intern("(,)"), prelude.lookup(Symbol.intern("cons")));

            prelude.define(Symbol.intern("quit"), new quit());
            prelude.define(Symbol.intern("unique"), unique);
            prelude.define(Symbol.intern("arity"), new arity());
        }


        public static Environment<Symbol, Fixity> preludeFixities = new HashEnvironment<Symbol, Fixity>();
        static {
            defineFixity("(.)",     11, false);
            defineFixity("(^^)",    10, true);
            defineFixity("(^)",     10, true);
            defineFixity("(%)",     9, true);
            defineFixity("(%%)",    9, true);
            defineFixity("(/)",     9, true);
            defineFixity("(*)",     9, true);
            defineFixity("(-)",     8, true);
            defineFixity("(+)",     8, true);
            defineFixity("{|}",     7, true);
            defineFixity("[,]",     6, true);
            defineFixity("{,}",     6, true);
            defineFixity("(,)",     6, true);
            defineFixity("(<)",     5, true);
            defineFixity("(<=)",    5, true);
            defineFixity("(>=)",    5, true);
            defineFixity("(>)",     5, true);
            defineFixity("(/=)",    5, true);
            defineFixity("(==)",    5, true);
            defineFixity("(|)",     4, true); // associativity?
            defineFixity("(&)",     4, true); // associativity?
            defineFixity("(->)",    3, false);
            defineFixity("(&&)",    2, false);
            defineFixity("(||)",    1, false);
            defineFixity("($!)",    0, true);
            defineFixity("($)",     0, false);
        }

        private static void defineFixity(String name, int precedence, boolean left) {
            preludeFixities.define(Symbol.intern(name), new Fixity(Symbol.intern(name), precedence, left));
        }


        private static BigInteger uniqueState = BigInteger.valueOf(0x2177375305f7L);

        public static Symbol unique() {
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


        static final int MIN_ARITY = 1;

        static final int MAX_ARITY = 0xf;


    }
