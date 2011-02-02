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

import java.util.Properties;

import vitry.runtime.struct.Sequence;


/**
 * The eval operation.
 * 
 * This operation works a lot like a Lisp eval, i.e. it expects a self-evaluating value
 * or a structure corresponding to the abstract syntax of an expression. Atomic values
 * and tokens representing terminals are considered self-evaluating. This enable us to
 * use the parser generated tokens directly, i.e. without having to walk the syntax tree 
 * and replace tokens with actual numbers, strings, symbols etc.
 * 
 * Nonterminal expressions are represented by symbol-headed tuples such as <em>(Apply, f, x)</em>.
 */
public interface Eval
    {

        /**
         * Encapsulates eval prerequisites.
         */
        public class Prerequisites
            {
                public final ClassLoader classLoader;
                public final Sequence<Module> linkedModules;
                public final Properties systemProperties;
                
                /**
                 * @param classLoader
                 *      ClassLoader from which to obtain dependencies.
                 * @param linkedModules
                 *      List of loaded modules.
                 * @param systemProperties
                 *      System properties, used by some implementations. If null, java.lang.System.getProperties() is used.
                 */
                public Prerequisites
                        (
                        ClassLoader classLoader, 
                        Sequence<vitry.runtime.Module> linkedModules, 
                        Properties systemProperties
                        ){
                    this.classLoader = classLoader;
                    this.linkedModules = linkedModules;
                    this.systemProperties = systemProperties;
                }
            }

        /**
         * Evaluate the given pattern.
         *
         * If the given value is an atomic value, return it. Otherwise, interpret it as a Vitry syntax 
         * tree and return its value. This may result in a ParseError.
         *
         * If the given pattern evaluates to a module, a module is constructed and resolved before
         * it is returned. This may result in a LinkageError or TypeError.
         * @param expr 
         *      Pattern to evaluate.
         * @param setup
         *      See EvalParams.
         * @throws ParseError
         * @throws LinkageError
         */
        public Object eval(Pattern expr, Prerequisites setup) throws ParseError, LinkageError, TypeError;
    }
