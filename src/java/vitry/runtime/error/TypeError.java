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
package vitry.runtime.error;

import vitry.runtime.Function;
import vitry.runtime.Pattern;
import vitry.runtime.Type;

/**
 * Thrown to indicate a typing error.
 *
 * TODO
 */
public class TypeError extends VitryError
    {

        private TypeError(String msg) {
            super(msg);
        }
        
        public TypeError(Type tag, Pattern v) {
            super("Can not apply tag " + tag + " to " + v);
        }
        
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
        
        public static <T> T throwMismatch(Object v, Object p) {
            throw new TypeError("" + v + " does not conform to " + p);            
        }
        
        public static <T> T throwWrongStructor(Object v, Function structor) {
            throw new TypeError("Could not destruct " + v + " using " + structor);
        }
        
        public static <T> T throwWrongCount(Object v) {
            throw new TypeError("Mismatching number of elements in " + v);
        }


        private static final long serialVersionUID = 3634069213260367204L;
    }
