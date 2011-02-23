package vitry.prelude;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;

import vitry.Build;
import vitry.runtime.Pattern;
import vitry.runtime.RestFunction;
import vitry.runtime.VitryRuntime;
import vitry.runtime.error.InvocationError;
import vitry.runtime.parse.VitryTreeAdaptor;
import vitry.runtime.parse.VitryLexer;
import vitry.runtime.parse.VitryParser;
import vitry.runtime.struct.Sequence;


public class repl extends RestFunction
    {

        private VitryRuntime rt;

        public repl(VitryRuntime rt) {
            this.rt = rt;
        }

        /**
         * args ... -> ()
         * Standard read-eval print loop.
         * 
         * TODO break into actual methods read/eval/print
         * TODO let definitions, module loading etc.
         */
        public Object applyVar(Sequence<?> args) throws InvocationError {            
            printWelcome();
            

            BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in));
            
            String line;
            try {
                while(true) {
                    System.out.print("> ");
                    line = lineReader.readLine();
                    
                    try {
                        if (line.length() == 0){
                            continue;
                        }
                        line = "(" + line + ")";
                        
                        VitryLexer lexer = new VitryLexer();
                        lexer.setCharStream(new ANTLRReaderStream(new StringReader(line)));

                        VitryParser parser = new VitryParser(new CommonTokenStream(lexer));
                        parser.setTreeAdaptor(new VitryTreeAdaptor());

                        
                        Pattern read = (Pattern) parser.expr().getTree();
                        
                        Object value = rt.getInterpreter().eval(read);
                        System.out.println(value);
                        
                    } catch (Exception e) {
                        System.err.println(e.getClass().getName() + ": " + e.getMessage());
//                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            // Never reached
            return VitryRuntime.NIL;
        }

        private void printWelcome() {
            System.out.println("Vitry v" 
                    + Build.MAJOR_VERSION + "." 
                    + Build.MINOR_VERSION + "."
                    + Build.RELEASE_VERSION);
            System.out.println("See https://github.com/hanshoglund/vitry");
        }        
    }
