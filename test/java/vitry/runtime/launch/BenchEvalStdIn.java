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


public class BenchEvalStdIn
    {
        static final Timer timer = new Timer();
        
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

                        VitryLexer lexer = 
                            (new VitryLexer
                                (new ANTLRReaderStream
                                    (new StringReader("(" + line + ")"))));
                        
                        CommonTokenStream tokens = new CommonTokenStream(lexer);

                        VitryParser parser = new VitryParser(tokens);
                        parser.setTreeAdaptor(new PatternTreeAdaptor());

                        timer.start();
                        Pattern expr = (Pattern) parser.expr().getTree();
                        timer.time();
                        timer.report("Parsing");

                        timer.start();
                        Object val = interpreter.eval(expr);
                        timer.time();
                        timer.report("Evaluation");
                        System.out.println("Value: " + val);
                        
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
