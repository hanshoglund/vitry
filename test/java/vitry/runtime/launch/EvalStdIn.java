package vitry.runtime.launch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;

import vitry.runtime.Eval;
import vitry.runtime.Interpreter;
import vitry.runtime.Pattern;
import vitry.runtime.parse.PatternTreeAdaptor;
import vitry.runtime.parse.VitryLexer;
import vitry.runtime.parse.VitryParser;


public class EvalStdIn
    {
        public static void main(String[] args) {

            // Read lines from std in

            BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            Eval interpreter = new Interpreter(null);
            System.out.println();

            try {
                while ( (line = lineReader.readLine()) != null) {
                    try {
                        if (line.length() == 0) continue;

                        VitryLexer lexer = 
                            (new VitryLexer
                                (new ANTLRReaderStream
                                    (new StringReader("(" + line + ")"))));
                        
                        CommonTokenStream tokens = new CommonTokenStream(lexer);

                        VitryParser parser = new VitryParser(tokens);
                        parser.setTreeAdaptor(new PatternTreeAdaptor());

                        Pattern expr = (Pattern) parser.expr().getTree();
                        
                        System.out.println("Tree : " + expr);
                        Object val = interpreter.eval(expr);
                        System.out.println("Value: " + val);
                        System.out.println("Class: " + val.getClass());
                        System.out.println();
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
