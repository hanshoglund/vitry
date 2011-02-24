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

        /**
         * Terminals used by lexer. Do not confuse with the AST variants.
         * These do not exist in the syntax tree.
         */
        public static final int PL = VitryParser.T__38;
        public static final int PR = VitryParser.T__39;
        public static final int BL = VitryParser.T__47;
        public static final int BR = VitryParser.T__48;
        public static final int AL = VitryParser.T__49;
        public static final int AR = VitryParser.T__50;
        
        public static final int FN = VitryParser.T__37;
        public static final int LET = VitryParser.T__40;
        public static final int DO = VitryParser.T__43;
        public static final int MATCH = VitryParser.T__44;
        
        public static final int IF = VitryParser.T__41;
        public static final int ELSE = VitryParser.T__42;
        public static final int EQ = VitryParser.T__45;
        public static final int MODULE = VitryParser.T__52;
        
        public static final int IMPORT = VitryParser.T__53;
        public static final int AS = VitryParser.T__54;
        public static final int TYPE = VitryParser.T__55;
        public static final int IMPLICIT = VitryParser.T__56;
        public static final int FIXITY = VitryParser.T__57;

        /**
         * The syntactic tokens used in the AST. These are members of
         * the generated lexer and parser, but we reify them here to provide
         * a symbol lookup.
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


        private static Env<Pattern, Integer> table;

        private static void def(String sym, int type) {
            if (table == null)
                table = new HashEnv<Pattern, Integer>();
            table.define(Symbol.intern(sym), type);
        }
    }
