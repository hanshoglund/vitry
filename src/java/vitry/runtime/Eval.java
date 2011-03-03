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


/**
 * The eval operation.
 * 
 * Expects a atomic values or a an expression tree. Atomic values 
 * evaluate to themselves. Tokens representing atomic values evaluate
 * to the value represented. Compound structures evaluate as the 
 * expression they represent.
 *
 * @author Hans Höglund
 */
public interface Eval {
    
    /**
     * Evaluate the given pattern.
     *
     * If the given value is an atomic value, return it. Otherwise, 
     * interpret it as a Vitry syntax tree and return its value. This 
     * may result in a ParseError.
     *
     * If the given pattern evaluates to a module, a module is 
     * constructed and resolved before it is returned. This may result in
     * a ResolveError or TypeError.
     * 
     * @param expr 
     *      Object to evaluate.
     * 
     * @throws ParseError
     * @throws ResolveError
     */
    public Object eval(Object expr) throws ParseError, ResolveError, TypeError;

    public Object eval(Object expr, Module module) throws ParseError, ResolveError, TypeError;


    /**
     * Whether this eval method accepts parser-generated tokens.
     */
    public boolean acceptsParserTokens();

    /**
     * Whether this eval method accepts symbolic tokens.
     */
    public boolean acceptsUserTokens();

}
