package vitry.prelude;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import vitry.runtime.*;
import vitry.runtime.error.*;
import vitry.runtime.parse.*;

public class parseFile extends StandardFunction
    {
        private VitryRuntime rt;

        public parseFile(VitryRuntime rt) {
            super(1, rt.getPrelude());
            this.rt = rt;
        }

        public Object apply(Object a) {
            String name = a.toString();
            name = name.replace("~", System.getProperty("user.home"));
            
            VitryLexer lexer = new VitryLexer();
            try
            {
                lexer.setCharStream(new ANTLRFileStream(name));
            } catch (IOException e)
            {
                throw new IOError(a);
            }
            Indentation indent = new Indentation(lexer);
            VitryParser parser = new VitryParser(new CommonTokenStream(indent));
            parser.setTreeAdaptor(new VitryTreeAdaptor());

            try {
                return parser.file().getTree();
            } catch (RecognitionException e) {
                throw new ParseError("Could not read " + a.toString());
            }   
        }
    }