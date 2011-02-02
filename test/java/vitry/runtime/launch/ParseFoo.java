package vitry.runtime.launch;

import java.io.IOException;
import java.io.StringReader;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import vitry.runtime.misc.Utils;
import vitry.runtime.parse.PatternTree;
import vitry.runtime.parse.PatternTreeAdaptor;
import vitry.runtime.parse.VitryLexer;
import vitry.runtime.parse.VitryParser;


/**
 * Parse and lex, dump Vitry AST.
 */
public class ParseFoo
    {

        /**
     * 
     */
    private static final String TEST = "(a, b, c, d)";

        public static void main(String[] args) {

            VitryLexer lexer = null;
            try {
                lexer = new VitryLexer(new ANTLRReaderStream(new StringReader(TEST)));
            } catch (IOException e1) {
            }
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            VitryParser parser = new VitryParser(tokens);
            parser.setTreeAdaptor(new PatternTreeAdaptor());

            try {
                PatternTree tree = (PatternTree) parser.expr().getTree();
//                System.out.println(Utils.prune(tree));
                System.out.println(tree);
                System.out.println(tree);

            } catch (RecognitionException e) {
                e.printStackTrace();
            }
        }


    }
