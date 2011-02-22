package vitry.runtime.parse;

import vitry.runtime.Environment;
import vitry.runtime.HashEnvironment;
import vitry.runtime.Pattern;
import vitry.runtime.Symbol;
import vitry.runtime.error.ParseError;
import vitry.runtime.error.VitryError;


/**
 * Provides integers identifiers representing token types.
 * 
 * TODO generate table from Vitry.tokens file (?)
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
