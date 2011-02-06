package vitry.runtime.launch;

import java.io.IOException;
import java.io.StringReader;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import vitry.runtime.Eval;
import vitry.runtime.Interpreter;
import vitry.runtime.Pattern;
import vitry.runtime.parse.PatternTreeAdaptor;
import vitry.runtime.parse.VitryLexer;
import vitry.runtime.parse.VitryParser;


/**
 * Parse and lex, dump Vitry AST.
 */
public class EvalFoo
    {

        /**
     * 
     */
    private static final String TEST = "\"test\"";

        public static void main(String[] args) {

            Eval interpreter = new Interpreter();
            
            VitryLexer lexer = null;
            try {
                lexer = new VitryLexer(new ANTLRReaderStream(new StringReader(TEST)));
            } catch (IOException e1) {
            }
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            VitryParser parser = new VitryParser(tokens);
            parser.setTreeAdaptor(new PatternTreeAdaptor());

            try {
                Pattern expr = (Pattern) parser.expr().getTree();
                System.out.println("Tree : " + expr);
                Object val = interpreter.eval(expr);
                System.out.println("Value: " + val);
                System.out.println("Class: " + val.getClass());

            } catch (RecognitionException e) {
                e.printStackTrace();
            }
        }


    }
