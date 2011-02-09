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

import vitry.runtime.struct.Sequence;
import vitry.runtime.struct.Sequences;


public class InvertibleRestFunction extends RestFunction implements InvertibleFunction
    {
        public Sequence<Object> applyVarInverse(Object a) throws InvocationError {
            return null;
        }

        public InvertibleRestFunction getInverse() {
            return new InvertibleRestFunction(){

                public Object invoke(Object a) throws InvocationError {
                    return this.applyInverse(a);
                }

                public Object applyInverse(Object a) throws InvocationError {
                    return this.apply(a);
                }

                public Object applyVar(Sequence<?> args) {
                    return this.applyVarInverse(args.head()).head();
                }

                public Sequence<Object> applyVarInverse(Object a) throws InvocationError {
                    return Sequences.cons(this.applyVar(Sequences.cons(a, null)), null);
                }
            };
        }

        public Object applyInverse(Object a) throws InvocationError {
            return applyVarInverse(Sequences.cons(a, null));
        }
    }
