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

import vitry.runtime.seq.Seq;

/**
 * The intersection of sets.
 * 
 * Equality and matching semantics:
 * 
 * <pre>
 * a = b, a ∈ CompoundType, b ∈ CompoundType, a : b ∪ b : a
 *
 * a : b, a ∈ (Atom ∪ Product), b ∈ Intersection <=> ∀x (x ∈ b -> a : x)
 * a : b, a ∈ Set, b ∈ Intersection              <=> ∀x (x ∈ a -> x : b) 
 * a : b, a ∈ Union, b ∈ Intersection            <=> ∀x (x ∈ a -> x : b) 
 * a : b, a ∈ Intersection, b ∈ Intersection     <=> ∃x (x ∈ a,   x : b)
 * </pre>
 */
public interface Intersection extends Pattern, Seq<Pattern>
    {
    }