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

/**
 * Visits the apply operation.
 *
 * Implementations may support any arity through applyVariadic() or some
 * arities (i..j) where 1 ≤ i ≤ j ≤ 16.
 */
public interface ApplyLeft
    {

        Object apply(Object a0) throws InvocationError;

        Object apply(Object a0, Object a1) throws InvocationError;

        Object apply(Object a0, Object a1, Object a2) throws InvocationError;

        Object apply(Object a0, Object a1, Object a2, Object a3) throws InvocationError;

        Object apply(Object a0, Object a1, Object a2, Object a3, Object a4) throws InvocationError;

        Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5) throws InvocationError;

        Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6) throws InvocationError;

        Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7) throws InvocationError;

        Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8) throws InvocationError;

        Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9) throws InvocationError;

        Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9, Object a10) throws InvocationError;

        Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9, Object a10, Object a11) throws InvocationError;

        Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9, Object a10, Object a11, Object a12) throws InvocationError;

        Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9, Object a10, Object a11, Object a12, Object a13) throws InvocationError;

        Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9, Object a10, Object a11, Object a12, Object a13, Object a14) throws InvocationError;

        Object apply(Object a0, Object a1, Object a2, Object a3, Object a4, Object a5, Object a6, Object a7, Object a8, Object a9, Object a10, Object a11, Object a12, Object a13, Object a14, Object a15) throws InvocationError;

        Object applyVariadic(Object... args) throws InvocationError;

    }