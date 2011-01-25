package vitry.runtime.launch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;

import vitry.runtime.parse.VitryLexer;


public class LexStdIn
    {
        public static void main(String[] args) {

            // Read lines from std in
            
            BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in));
            String line;

            try {
                while ( (line = lineReader.readLine()) != null) {
                    
                    // Run through VitryLexer
                    VitryLexer lexer = new VitryLexer(new ANTLRReaderStream(new StringReader(line)));
                    CommonTokenStream tokens = new CommonTokenStream(lexer);

                    // Print tokens per line
                    for (Object t : tokens.getTokens()) {
                        System.out.println(t);
//                        System.out.println(((CommonToken) t).getText());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
