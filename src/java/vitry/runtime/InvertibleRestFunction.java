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

import vitry.runtime.error.*;
import vitry.runtime.struct.*;


public class InvertibleRestFunction extends RestFunction implements InvertibleFunction
    {
        public Seq<?> applyVarInverse(Object a) throws InvocationError {
            throw new NoImplementationException();
        }

        public InvertibleRestFunction getInverse() {
            return new Inv();
        }

        public Object applyInverse(Object a) throws InvocationError {
            return applyVarInverse(Seqs.single(a));
        }

        private final class Inv extends InvertibleRestFunction
        {
            public Object apply(Object a) throws InvocationError {
                return InvertibleRestFunction.this.applyInverse(a);
            }
        
            public Object applyInverse(Object a) throws InvocationError {
                return InvertibleRestFunction.this.apply(a);
            }
        
            public Object applyVar(Seq<?> args) {
                return InvertibleRestFunction.this.applyVarInverse(args.head()).head();
            }
        
            public Seq<Object> applyVarInverse(Object a) throws InvocationError {
                return Seqs.cons(InvertibleRestFunction.this.applyVar(Seqs.single(a)), null);
            }
        }
    }
