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

import static vitry.runtime.misc.Utils.linearSearch;

import java.util.Arrays;

import vitry.runtime.*;
import vitry.runtime.error.*;
import vitry.runtime.misc.Utils;


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

        /**
         * Terminals used in the token stream generated by the lexer.
         * These do (should?) not exist in the AST.
         */
        public static final int PL        = findToken("'('");
        public static final int PR        = findToken("')'");
        public static final int BL        = findToken("'['");
        public static final int BR        = findToken("']'");
        public static final int AL        = findToken("'{'");
        public static final int AR        = findToken("'}'");
                                          
        public static final int FN        = findToken("'fn'");
        public static final int LET       = findToken("'let'");
        public static final int DO        = findToken("'do'");
        public static final int MATCH     = findToken("'match'");
                                          
        public static final int IF        = findToken("'if'");
        public static final int ELSE      = findToken("'else'");
        public static final int EQ        = findToken("'eq'");
        public static final int MODULE    = findToken("'module'");
                                          
        public static final int IMPORT    = findToken("'import'");
        public static final int AS        = findToken("'as'");
        public static final int TYPE      = findToken("'type'");
        public static final int IMPLICIT  = findToken("'implicit'");
        public static final int FIXITY    = findToken("'fixity'");

        /**
         * Syntactic tokens used in the AST.
         * Do not exist in the token stream generated by the lexer.
         */
        static {
            def("Ang", VitryParser.Ang);
            def("Apply", VitryParser.Apply);
            def("Assign", VitryParser.Assign);
            def("Bra", VitryParser.Bra);
            def("Do", VitryParser.Do);
            def("Fn", VitryParser.Fn);
            def("If", VitryParser.If);
            def("Left", VitryParser.Left);
            def("Let", VitryParser.Let);
            def("Match", VitryParser.Match);
            def("Module", VitryParser.Module);
            def("Op", VitryParser.Op);
            def("Ops", VitryParser.Ops);
            def("Par", VitryParser.Par);
            def("Quote", VitryParser.Quote);
            def("Type", VitryParser.Type);
            def("Import", VitryParser.Import);
            def("TypeDecl", VitryParser.TypeDecl);
            def("Implicit", VitryParser.Implicit);
            def("Fixity", VitryParser.Fixity);
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

        public static int parserTokenType(Pattern p) {
            return ((VitryToken) p).getTokenType();
        }


        public static int symbolicTokenType(Pattern p) {
            try {
                return table.lookup(p);
            } catch (Exception e) {
                throw new ParseError("Unknown form: " + p);
            }
        }


        
        private static int findToken(String t) {
            int res = linearSearch(VitryParser.tokenNames, t);
            assert res >= 0;
            return res;
        }
        
        private static Env<Pattern, Integer> table;

        private static void def(String sym, int type) {
            if (table == null)
                table = new HashEnv<Pattern, Integer>();
            table.define(Symbol.intern(sym), type);
        }
    }
