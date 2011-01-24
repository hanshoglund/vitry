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

import vitry.runtime.misc.Utilities;


/**
 * Provides partial and extended application.
 *
 * Subclasses should override one of the apply methods and provide arity and type.
 * 
 * Conceptually, all functionas are unary. However, functions of arity <em>n</em> is
 * used to represent the curried form <em>t1 -> t2 ... tN</em> effetively. Such
 * a function has type <em>T</em> where <em>T</em> is a sequence and <code>T.head</code> 
 * represents <em>t1</em>, <code>T.head().head()</code> represents t2 and so on.
 * 
 * <h4>Invariants:</h4>
 * 
 * Whenever a Function f is called with n arguments:                      
 * <pre>
 *     if  n     &lt; f.arity,  then a partial application is returned
 *     if  n     = f.arity,  then f(a1,a2..a[N]) is returned
 *     if  n + 1 = f.arity,  then f(a1,a2..a[N-1]) f[N] is returned
 *     if  n + 2 = f.arity,  then f(a1,a2..a[N-2]) f[N-1] f[N] is returned</pre>
 * etc.
 * 
 * See <em>Making a Fast Curry: Push/Enter vs Eval/Apply for Higher-order 
 * Languages</em> by Marlow and Jones
 */
abstract public class Function extends Callable implements Apply, Dynamic
    {

        public static int MIN_ARITY = 1;
        public static int MAX_ARITY = 0xf;
        
        protected final int arity;

        protected final FunctionType type;

        
        Function() {
            this.arity = 1;
            this.type = new SimpleFunctionType(Vitry.wildcard, Vitry.wildcard);;
        }

        public Function(FunctionType type) {
            this.arity = 1;
            this.type = type;
        }
        
        public Function(int arity, FunctionType type) {
            if (arity < MIN_ARITY || arity > MAX_ARITY) 
                throw new IllegalArgumentException(
                        "Function must have arity a where " +
                        MIN_ARITY + " < a < " + MAX_ARITY);
            this.arity = arity;
            this.type = type;
        }

        public int arity() {
            return arity;
        }

        public FunctionType type() {
            return type;
        }
        
        

        public Object apply(Object a0) throws InvocationException {
            switch (arity) {
                case 1:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0);
            }
        }

        public Object apply(Object a0, Object a1) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1);
                case 2:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1);
            }
        }

        public Object apply(Object a0, Object a1, Object a2) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2);
                case 3:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3);
                case 4:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2, a3);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3, a4);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3, a4);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3, a4);
                case 4:
                    return ((Apply) this.apply(a0, a1, a2, a3)).apply(a4);
                case 5:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3, a4, a5);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3, a4, a5);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3, a4, a5);
                case 4:
                    return ((Apply) this.apply(a0, a1, a2, a3)).apply(a4, a5);
                case 5:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4)).apply(a5);
                case 6:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6);
                case 4:
                    return ((Apply) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6);
                case 5:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6);
                case 6:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6);
                case 7:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7);
                case 4:
                    return ((Apply) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7);
                case 5:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7);
                case 6:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7);
                case 7:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7);
                case 8:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7, a8);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7, a8);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7, a8);
                case 4:
                    return ((Apply) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7, a8);
                case 5:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7, a8);
                case 6:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7, a8);
                case 7:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7, a8);
                case 8:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7)).apply(a8);
                case 9:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7, a8, a9);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7, a8, a9);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7, a8, a9);
                case 4:
                    return ((Apply) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7, a8, a9);
                case 5:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7, a8, a9);
                case 6:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7, a8, a9);
                case 7:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7, a8, a9);
                case 8:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7)).apply(a8, a9);
                case 9:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8)).apply(a9);
                case 10:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9, Object a10) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7, a8, a9, a10);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7, a8, a9, a10);
                case 4:
                    return ((Apply) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7, a8, a9, a10);
                case 5:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7, a8, a9, a10);
                case 6:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7, a8, a9, a10);
                case 7:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7, a8, a9, a10);
                case 8:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7)).apply(a8, a9, a10);
                case 9:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8)).apply(a9, a10);
                case 10:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9)).apply(a10);
                case 11:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9, Object a10, Object a11) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7, a8, a9, a10, a11);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7, a8, a9, a10, a11);
                case 4:
                    return ((Apply) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7, a8, a9, a10, a11);
                case 5:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7, a8, a9, a10, a11);
                case 6:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7, a8, a9, a10, a11);
                case 7:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7, a8, a9, a10, a11);
                case 8:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7)).apply(a8, a9, a10, a11);
                case 9:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8)).apply(a9, a10, a11);
                case 10:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9)).apply(a10, a11);
                case 11:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10)).apply(a11);
                case 12:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9, Object a10, Object a11, Object a12) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7, a8, a9, a10, a11, a12);
                case 4:
                    return ((Apply) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7, a8, a9, a10, a11, a12);
                case 5:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7, a8, a9, a10, a11, a12);
                case 6:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7, a8, a9, a10, a11, a12);
                case 7:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7, a8, a9, a10, a11, a12);
                case 8:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7)).apply(a8, a9, a10, a11, a12);
                case 9:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8)).apply(a9, a10, a11, a12);
                case 10:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9)).apply(a10, a11, a12);
                case 11:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10)).apply(a11, a12);
                case 12:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)).apply(a12);
                case 13:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9, Object a10, Object a11, Object a12, Object a13) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7, a8, a9, a10, a12, a13);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13);
                case 4:
                    return ((Apply) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7, a8, a9, a10, a11, a12, a13);
                case 5:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7, a8, a9, a10, a11, a12, a13);
                case 6:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7, a8, a9, a10, a11, a12, a13);
                case 7:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7, a8, a9, a10, a11, a12, a13);
                case 8:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7)).apply(a8, a9, a10, a11, a12, a13);
                case 9:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8)).apply(a9, a10, a11, a12, a13);
                case 10:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9)).apply(a10, a11, a12, a13);
                case 11:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10)).apply(a11, a12, a13);
                case 12:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)).apply(a12, a13);
                case 13:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12)).apply(a13);
                case 14:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9, Object a10, Object a11, Object a12, Object a13, Object a14) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14);
                case 4:
                    return ((Apply) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14);
                case 5:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7, a8, a9, a10, a11, a12, a13, a14);
                case 6:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7, a8, a9, a10, a11, a12, a13, a14);
                case 7:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7, a8, a9, a10, a11, a12, a13, a14);
                case 8:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7)).apply(a8, a9, a10, a11, a12, a13, a14);
                case 9:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8)).apply(a9, a10, a11, a12, a13, a14);
                case 10:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9)).apply(a10, a11, a12, a13, a14);
                case 11:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10)).apply(a11, a12, a13, a14);
                case 12:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)).apply(a12, a13, a14);
                case 13:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12)).apply(a13, a14);
                case 14:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13)).apply(a14);

                case 15:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9, Object a10, Object a11, Object a12, Object a13, Object a14, Object a15) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15);
                case 4:
                    return ((Apply) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15);
                case 5:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15);
                case 6:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7, a8, a9, a10, a11, a12, a13, a14, a15);
                case 7:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7, a8, a9, a10, a11, a12, a13, a14, a15);
                case 8:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7)).apply(a8, a9, a10, a11, a12, a13, a14, a15);
                case 9:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8)).apply(a9, a10, a11, a12, a13, a14, a15);
                case 10:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9)).apply(a10, a11, a12, a13, a14, a15);
                case 11:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10)).apply(a11, a12, a13, a14, a15);
                case 12:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)).apply(a12, a13, a14, a15);
                case 13:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12)).apply(a13, a14, a15);
                case 14:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13)).apply(a14, a15);
                case 15:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14)).apply(a15);
                case 16:
                    throw new NoImplementationException();
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15);

            }
        }

        public Object applyVariadic(Object... args) throws InvocationException {
            switch (args.length) {
                case 1:
                    return apply(args[0]);
                case 2:
                    return apply(args[0], args[1]);
                case 3:
                    return apply(args[0], args[1], args[2]);
                case 4:
                    return apply(args[0], args[1], args[2], args[3]);
                case 5:
                    return apply(args[0], args[1], args[2], args[3], args[4]);
                case 6:
                    return apply(args[0], args[1], args[2], args[3], args[4], args[5]);
                case 7:
                    return apply(args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
                case 8:
                    return apply(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7]);
                case 9:
                    return apply(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8]);
                case 10:
                    return apply(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9]);
                case 11:
                    return apply(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10]);
                case 12:
                    return apply(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11]);
                case 13:
                    return apply(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11], args[12]);
                case 14:
                    return apply(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11], args[12], args[13]);
                case 15:
                    return apply(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11], args[12], args[13], args[14]);
                case 16:
                    return apply(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11], args[12], args[13], args[14], args[15]);
                default:
                    throw new IllegalArgumentException();
            }
        }
    }


class PartialApplication extends Function
    {

        PartialApplication(Function original, Object... args) {
            super(original.arity - args.length, null);
            this.original = original;
            this.args = args;

            assert (this.arity > 0);
        }

        private final Apply original;

        private final Object[] args;

        public Object apply(Object a0) throws InvocationException {
            switch (arity) {
                case 1:
                    return original.applyVariadic(Utilities.concat(args, a0));
                default:
                    return new PartialApplication(this, a0);
            }
        }

        public Object apply(Object a0, Object a1) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1);
                case 2:
                    return original.applyVariadic(Utilities.concat(args, a0, a1));
                default:
                    return new PartialApplication(this, a0, a1);
            }
        }

        public Object apply(Object a0, Object a1, Object a2) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2);
                case 3:
                    return original.applyVariadic(Utilities.concat(args, a0, a1, a2));
                default:
                    return new PartialApplication(this, a0, a1, a2);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3);
                case 4:
                    return original.applyVariadic(Utilities.concat(args, a0, a1, a2, a3));
                default:
                    return new PartialApplication(this, a0, a1, a2, a3);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3, a4);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3, a4);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3, a4);
                case 4:
                    return ((Apply) this.apply(a0, a1, a2, a3)).apply(a4);
                case 5:
                    return original.applyVariadic(Utilities.concat(args, a0, a1, a2, a3, a4));
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3, a4, a5);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3, a4, a5);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3, a4, a5);
                case 4:
                    return ((Apply) this.apply(a0, a1, a2, a3)).apply(a4, a5);
                case 5:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4)).apply(a5);
                case 6:
                    return original.applyVariadic(Utilities.concat(args, a0, a1, a2, a3, a4, a5));
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6);
                case 4:
                    return ((Apply) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6);
                case 5:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6);
                case 6:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6);
                case 7:
                    return original.applyVariadic(Utilities.concat(args, a0, a1, a2, a3, a4, a5, a6));
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7);
                case 4:
                    return ((Apply) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7);
                case 5:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7);
                case 6:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7);
                case 7:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7);
                case 8:
                    return original.applyVariadic(Utilities.concat(args, a0, a1, a2, a3, a4, a5, a6, a7));

                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7, a8);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7, a8);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7, a8);
                case 4:
                    return ((Apply) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7, a8);
                case 5:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7, a8);
                case 6:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7, a8);
                case 7:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7, a8);
                case 8:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7)).apply(a8);
                case 9:
                    return original.applyVariadic(Utilities.concat(args, a0, a1, a2, a3, a4, a5, a6, a7, a8));
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7, a8, a9);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7, a8, a9);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7, a8, a9);
                case 4:
                    return ((Apply) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7, a8, a9);
                case 5:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7, a8, a9);
                case 6:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7, a8, a9);
                case 7:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7, a8, a9);
                case 8:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7)).apply(a8, a9);
                case 9:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8)).apply(a9);
                case 10:
                    return original.applyVariadic(Utilities.concat(args, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9));
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9, Object a10) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7, a8, a9, a10);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7, a8, a9, a10);
                case 4:
                    return ((Apply) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7, a8, a9, a10);
                case 5:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7, a8, a9, a10);
                case 6:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7, a8, a9, a10);
                case 7:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7, a8, a9, a10);
                case 8:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7)).apply(a8, a9, a10);
                case 9:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8)).apply(a9, a10);
                case 10:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9)).apply(a10);
                case 11:
                    return original.applyVariadic(Utilities.concat(args, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10));
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9, Object a10, Object a11) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7, a8, a9, a10, a11);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7, a8, a9, a10, a11);
                case 4:
                    return ((Apply) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7, a8, a9, a10, a11);
                case 5:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7, a8, a9, a10, a11);
                case 6:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7, a8, a9, a10, a11);
                case 7:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7, a8, a9, a10, a11);
                case 8:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7)).apply(a8, a9, a10, a11);
                case 9:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8)).apply(a9, a10, a11);
                case 10:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9)).apply(a10, a11);
                case 11:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10)).apply(a11);
                case 12:
                    return original.applyVariadic(Utilities.concat(args, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11));
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9, Object a10, Object a11, Object a12) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7, a8, a9, a10, a11, a12);
                case 4:
                    return ((Apply) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7, a8, a9, a10, a11, a12);
                case 5:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7, a8, a9, a10, a11, a12);
                case 6:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7, a8, a9, a10, a11, a12);
                case 7:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7, a8, a9, a10, a11, a12);
                case 8:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7)).apply(a8, a9, a10, a11, a12);
                case 9:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8)).apply(a9, a10, a11, a12);
                case 10:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9)).apply(a10, a11, a12);
                case 11:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10)).apply(a11, a12);
                case 12:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)).apply(a12);
                case 13:
                    return original.applyVariadic(Utilities.concat(args, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12));
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9, Object a10, Object a11, Object a12, Object a13) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7, a8, a9, a10, a12, a13);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13);
                case 4:
                    return ((Apply) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7, a8, a9, a10, a11, a12, a13);
                case 5:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7, a8, a9, a10, a11, a12, a13);
                case 6:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7, a8, a9, a10, a11, a12, a13);
                case 7:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7, a8, a9, a10, a11, a12, a13);
                case 8:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7)).apply(a8, a9, a10, a11, a12, a13);
                case 9:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8)).apply(a9, a10, a11, a12, a13);
                case 10:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9)).apply(a10, a11, a12, a13);
                case 11:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10)).apply(a11, a12, a13);
                case 12:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)).apply(a12, a13);
                case 13:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12)).apply(a13);
                case 14:
                    return original.applyVariadic(Utilities.concat(args, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13));
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9, Object a10, Object a11, Object a12, Object a13, Object a14) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14);
                case 4:
                    return ((Apply) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14);
                case 5:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7, a8, a9, a10, a11, a12, a13, a14);
                case 6:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7, a8, a9, a10, a11, a12, a13, a14);
                case 7:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7, a8, a9, a10, a11, a12, a13, a14);
                case 8:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7)).apply(a8, a9, a10, a11, a12, a13, a14);
                case 9:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8)).apply(a9, a10, a11, a12, a13, a14);
                case 10:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9)).apply(a10, a11, a12, a13, a14);
                case 11:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10)).apply(a11, a12, a13, a14);
                case 12:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)).apply(a12, a13, a14);
                case 13:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12)).apply(a13, a14);
                case 14:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13)).apply(a14);

                case 15:
                    return original.applyVariadic(Utilities.concat(args, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14));
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14);
            }
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9, Object a10, Object a11, Object a12, Object a13, Object a14, Object a15) throws InvocationException {

            switch (arity) {
                case 1:
                    return ((Apply) this.apply(a0)).apply(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15);
                case 2:
                    return ((Apply) this.apply(a0, a1)).apply(a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15);
                case 3:
                    return ((Apply) this.apply(a0, a1, a2)).apply(a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15);
                case 4:
                    return ((Apply) this.apply(a0, a1, a2, a3)).apply(a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15);
                case 5:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4)).apply(a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15);
                case 6:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5)).apply(a6, a7, a8, a9, a10, a11, a12, a13, a14, a15);
                case 7:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6)).apply(a7, a8, a9, a10, a11, a12, a13, a14, a15);
                case 8:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7)).apply(a8, a9, a10, a11, a12, a13, a14, a15);
                case 9:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8)).apply(a9, a10, a11, a12, a13, a14, a15);
                case 10:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9)).apply(a10, a11, a12, a13, a14, a15);
                case 11:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10)).apply(a11, a12, a13, a14, a15);
                case 12:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)).apply(a12, a13, a14, a15);
                case 13:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12)).apply(a13, a14, a15);
                case 14:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13)).apply(a14, a15);
                case 15:
                    return ((Apply) this.apply(a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14)).apply(a15);
                case 16:
                    return original.applyVariadic(Utilities.concat(args, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15));
                default:
                    return new PartialApplication(this, a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15);
            }
        }
    }


class NoImplementationException extends RuntimeException
    {
        private static final long serialVersionUID = 2787250838481872800L;
    }