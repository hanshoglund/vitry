package vitry.runtime.parse;

import vitry.runtime.Environment;
import vitry.runtime.HashEnvironment;
import vitry.runtime.Pattern;
import vitry.runtime.Symbol;
import vitry.runtime.error.ParseError;
import vitry.runtime.error.VitryError;


/**
 * Provides integers identifiers representing token types.
 */
public class VitryTokenTypes
    {

        public static final Environment<Pattern, Integer> SYMBOLIC_TOKENS = (new HashEnvironment<Pattern, Integer>()
                .define(Symbol.intern("Ang"), VitryParser.Ang)
                .define(Symbol.intern("Apply"), VitryParser.Apply)
                .define(Symbol.intern("Assign"), VitryParser.Assign)
                .define(Symbol.intern("Bra"), VitryParser.Bra)
                .define(Symbol.intern("Do"), VitryParser.Do)
                .define(Symbol.intern("Fn"), VitryParser.Fn)
                .define(Symbol.intern("If"), VitryParser.If)
                .define(Symbol.intern("Left"), VitryParser.Left)
                .define(Symbol.intern("Let"), VitryParser.Let)
                // .define(Symbol.intern("Loop"), VitryParser.Loop)
                .define(Symbol.intern("Match"), VitryParser.Match)
                .define(Symbol.intern("Module"), VitryParser.Module)
                .define(Symbol.intern("Ops"), VitryParser.Ops)
                .define(Symbol.intern("Par"), VitryParser.Par)
                .define(Symbol.intern("Quote"), VitryParser.Quote)
                // .define(Symbol.intern("Recur"), VitryParser.Recur)
                .define(Symbol.intern("Type"), VitryParser.Type));

        public static int parserTokenType(Pattern p) {
            return ((VitryToken) p).getTokenType();
        }

        public static int symbolicTokenType(Pattern p) {
            try {
                return SYMBOLIC_TOKENS.lookup(p);
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
    }
