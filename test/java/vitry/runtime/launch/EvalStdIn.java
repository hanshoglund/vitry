package vitry.runtime.launch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;

import vitry.runtime.Eval;
import vitry.runtime.Eval.Prerequisites;
import vitry.runtime.Interpreter;
import vitry.runtime.Pattern;
import vitry.runtime.Product;
import vitry.runtime.misc.Utils;
import vitry.runtime.parse.PatternTree;
import vitry.runtime.parse.PatternTreeAdaptor;
import vitry.runtime.parse.VitryLexer;
import vitry.runtime.parse.VitryParser;


public class EvalStdIn
    {
        private static final Prerequisites pre = new Eval.Prerequisites(null, null, null);

        public static void main(String[] args) {

            // Read lines from std in

            BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            Eval interpreter = new Interpreter();
            System.out.println();

            try {
                while ( (line = lineReader.readLine()) != null) {
                    try {
                        if (line.length() == 0) continue;

                        VitryLexer lexer = new VitryLexer(new ANTLRReaderStream(new StringReader(
                                line)));
                        CommonTokenStream tokens = new CommonTokenStream(lexer);

                        VitryParser parser = new VitryParser(tokens);
                        parser.setTreeAdaptor(new PatternTreeAdaptor());

                        Pattern expr = (Pattern) parser.expr().getTree();
                        System.out.println("Tree : " + expr);
                        Object val = interpreter.eval(expr, pre);
                        System.out.println("Value: " + val);
                        System.out.println("Class: " + val.getClass());
                    } catch (Exception e) {
//                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
