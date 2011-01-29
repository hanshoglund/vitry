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

import vitry.runtime.struct.Seq;


/**
 * Visits the eval operation.        
 * 
 * Evaluation prerequisites like linkage classloader, system properties etc. are typically
 * stored in an instance of the Vitry class. We prefer to pass them explicitly in case we
 * want to use this operation in other contexts.
 */
public interface Eval
    {
        /**
         * Evaluate the given pattern.
         * 
         * @param e 
         *      Pattern to evaluate.
         * @param cl
         *      ClassLoader from which to obtain dependencies.
         * @param link
         *      List of loaded modules.
         * @param systemProperties
         *      System properties, used by some implementations. If null, java.lang.System.getProperties() is used.
         * @throws ParseError
         * @throws LinkageError
         */
        public Value eval(Pattern e, ClassLoader cl, Seq<Module> link, Properties systemProperties)
        throws ParseError, LinkageError;
    }
