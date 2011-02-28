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
import vitry.runtime.struct.Seqs;


/**
 * Function with variable number of arguments.
 * 
 * All methods delegate to applyVar(Sequence)
 *
 * @author Hans Höglund
 */
public class RestFunction extends AbstractFunction
    {    
        public RestFunction() {
            super();
        }

        public RestFunction(Scope scope) {
            super(scope);
        }

        public RestFunction(Env<Symbol, Object> env) {
            super(env);
        }
        
        /**
         * Throws a NoImplementationException.
         */
        public Object applyVar(Seq<?> args) {
            throw new NoImplementationException();
        }

        public Object applyVar(Object[] args) {
            return applyVar(Seqs.from(args));
        }

        public Object apply(Object a0) throws InvocationError {
            return applyVar(new Object[]{ a0 });
        }

        public Object apply(Object a0, Object a1) throws InvocationError {
            return applyVar(new Object[]{ a0, a1 });
        }

        public Object apply(Object a0, Object a1, Object a2) throws InvocationError {
            return applyVar(new Object[]{ a0, a1, a2 });
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3) throws InvocationError {
            return applyVar(new Object[]{ a0, a1, a2, a3 });
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4)
                throws InvocationError {
            return applyVar(new Object[]{ a0, a1, a2, a3, a4 });
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5)
                throws InvocationError {
            return applyVar(new Object[]{ a0, a1, a2, a3, a4, a5 });
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6) throws InvocationError {
            return applyVar(new Object[]{ a0, a1, a2, a3, a4, a5, a6 });
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7) throws InvocationError {
            return applyVar(new Object[]{ a0, a1, a2, a3, a4, a5, a6, a7 });
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7, Object a8) throws InvocationError {
            return applyVar(new Object[]{ a0, a1, a2, a3, a4, a5, a6, a7, a8 });
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7, Object a8, Object a9) throws InvocationError {
            return applyVar(new Object[]{ a0, a1, a2, a3, a4, a5, a6, a7, a8, a9 });
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7, Object a8, Object a9, Object a10) throws InvocationError {
            return applyVar(new Object[]{ a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10 });
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7, Object a8, Object a9, Object a10, Object a11)
                throws InvocationError {
            return applyVar(new Object[]{ a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11 });
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7, Object a8, Object a9, Object a10, Object a11, Object a12)
                throws InvocationError {
            return applyVar(new Object[]{ a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11,
                a12 });
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7, Object a8, Object a9, Object a10, Object a11,
                Object a12, Object a13) throws InvocationError {
            return applyVar(new Object[]{ a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11,
                a12, a13 });
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7, Object a8, Object a9, Object a10, Object a11,
                Object a12, Object a13, Object a14) throws InvocationError {
            return applyVar(new Object[]{ a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11,
                a12, a13, a14 });
        }

        public Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5,
                Object a6, Object a7, Object a8, Object a9, Object a10, Object a11,
                Object a12, Object a13, Object a14, Object a15) throws InvocationError {
            return applyVar(new Object[]{ a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11,
                a12, a13, a14, a15 });
        }
    }
