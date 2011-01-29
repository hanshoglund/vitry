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

import vitry.runtime.parse.VitryParser;
import vitry.runtime.parse.VitryToken;
import vitry.runtime.struct.Seq;


public class Interpreter implements Eval
    {

        public Value eval(
            Pattern e, 
            ClassLoader cl, 
            Seq<Module> link,
            Properties systemProperties) 
            throws ParseError, LinkageError {

            VitryToken op = null; 
            Seq<Pattern> args = null; 

            try {
                op = (VitryToken) ((Product) e).head();
                args = ((Product) e).tail();
            } catch (ClassCastException t) {
                t.printStackTrace();
                // TODO
            }
            
            switch(op.getType()) {
                
                case VitryParser.Par:
                
                case VitryParser.Bra:
                
                case VitryParser.Ang:
                
                case VitryParser.Module:
                    // TODO typecheck
                    return new InterpretedModule();
                
                case VitryParser.Fn: 
                    // TODO typecheck
                    // TODO store expr etc.
                    return new InterpretedFunction();
                
                case VitryParser.Let:
                
                case VitryParser.Where:
                
                case VitryParser.Assign:
                
                case VitryParser.Left:
                
                case VitryParser.Quote:

                
                case VitryParser.Apply:
                
                case VitryParser.Type:
                
                case VitryParser.If:
                
                case VitryParser.Match:
                
                case VitryParser.Loop:
                
                case VitryParser.Recur:
                
                case VitryParser.Do:
                
                case VitryParser.Ops:
                
                default:
            }
            
            
            // TODO
            return null;
        }
        
        
        
        
        // TODO Deconstruction, type restrictions
        public Value match(final Value input, Seq<Pattern> left, Seq<Pattern> right) {
            while (left != null && right != null) {
                if (input.matchFor(left.head())) {
                    return right.head();
                }
                left = left.tail();
                right = right.tail();
            }
            throw new MatchingError(input);
        }

    }


class InterpretedFunction extends Function {
        
        
}


class InterpretedModule extends Module {
        

}