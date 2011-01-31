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
 * Indicates all language errors. We do not use checked exceptions for the
 * Vitry language.
 * 
 * The runtime classes may also throw general exceptions such as 
 * IllegalArgumentException and of course VirtualMachineErrors. These should
 * be considered implementation bugs.
 */                        
@SuppressWarnings("serial")

abstract public class VitryError extends RuntimeException
    {

        public VitryError(String string) {
            super(string);
        }

        public VitryError(String string, Throwable cause) {
            super(string, cause);
        }
    }
