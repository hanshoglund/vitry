package vitry.prelude;

import org.antlr.runtime.*;

import vitry.runtime.*;
import vitry.runtime.error.*;
import vitry.runtime.parse.*;

public class readDecl extends StandardFunction
    {
        private VitryRuntime rt;

        public readDecl(VitryRuntime rt) {
            super(1, rt);
            this.rt = rt;
        }

        public Object apply(Object a) {
            VitryLexer lexer = new VitryLexer();
            lexer.setCharStream(new ANTLRStringStream(a.toString()));

            VitryParser parser = new VitryParser(new CommonTokenStream(lexer));
            parser.setTreeAdaptor(new VitryTreeAdaptor());

            try {
                return parser.decl().getTree();
            } catch (RecognitionException e) {
                throw new ParseError("Could not read " + a.toString());
            }   
        }
    }