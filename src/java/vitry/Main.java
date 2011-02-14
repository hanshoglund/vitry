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
package vitry;

import static vitry.runtime.VitryRuntime.*;

import java.util.Properties;

import vitry.runtime.*;
import vitry.prelude.*;

public class Main
    {

        public static void main(String[] args) {
            // TODO exec from shell
            // TODO other options
            
            Interpreter interpreter = new Interpreter();
            Properties properties = System.getProperties();
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            
            VitryRuntime rt = new VitryRuntime(properties, classLoader, interpreter);
            
            Function repl = (Function) rt.getPreludeValue("repl");
            repl.apply(NIL);
        }
    }
