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
package vitry.runtime.parse;

import vitry.runtime.*;
import vitry.runtime.error.*;


/**
 * Provides integers identifiers representing token types.
 * 
 * TODO
 *     Generate from Vitry.tokens
 *
 * @author Hans Höglund 
 */
public class VitryTokenTypes
    {

        static {
            def("Ang",      VitryParser.Ang);
            def("Apply",    VitryParser.Apply);
            def("Assign",   VitryParser.Assign);
            def("Bra",      VitryParser.Bra);
            def("Do",       VitryParser.Do);
            def("Fn",       VitryParser.Fn);
            def("If",       VitryParser.If);
            def("Left",     VitryParser.Left);
            def("Let",      VitryParser.Let);
            def("Match",    VitryParser.Match);
            def("Module",   VitryParser.Module);
            def("Ops",      VitryParser.Ops);
            def("Par",      VitryParser.Par);
            def("Quote",    VitryParser.Quote);
            def("Type",     VitryParser.Type);
        }


        public static int parserTokenType(Pattern p) {
            return ((VitryToken) p).getTokenType();
        }

        public static int symbolicTokenType(Pattern p) {
            try {
                return TABLE.lookup(p);
            } catch (Exception e) {
                throw new ParseError("Unknown form: " + p);
            }
        }

        public static int tokenType(Pattern p) {
            try {
                try {
                    return parserTokenType(p);
                } catch (Exception _) {
                    return symbolicTokenType(p);
                }
            } catch (VitryError e) {
                throw e;
            }
        }



        private static final Environment<Pattern, Integer> TABLE = new HashEnvironment<Pattern, Integer>();

        private static void def(String sym, int type) {
            TABLE.define(Symbol.intern(sym), type);
        }
    }
