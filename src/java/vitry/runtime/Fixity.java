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
 * Represents operator fixity (including precedence associcativity 
 * and binding style).
 *
 * Gathering operators are resolved to n-ary function calls when 
 * repeated.
 *
 * @author Hans Hoglund
 */
public class Fixity
{
    private final int precedence;
    private final boolean assoc;
    private final boolean gathering;

    public Fixity(int precedence, boolean assoc) {
        this(precedence, assoc, false);
    }

    public Fixity(int precedence, boolean assoc, boolean gathering) {
        this.precedence = precedence;
        this.assoc = assoc;
        this.gathering = gathering;
    }

    public int getPrecedence()
    {
        return precedence;
    }

    public boolean getAssociativity()
    {
        return assoc;
    }

    public boolean isGathering()
    {
        return gathering;
    }
}
