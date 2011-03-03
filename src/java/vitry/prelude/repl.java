package vitry.prelude;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import vitry.Build;
import vitry.runtime.Function;
import vitry.runtime.Module;
import vitry.runtime.RestFunction;
import vitry.runtime.Scope;
import vitry.runtime.VitryRuntime;
import vitry.runtime.error.InvocationError;
import vitry.runtime.struct.Seq;


public class repl extends RestFunction
    {

        private VitryRuntime rt;
        private Function read;
        private Function print;

        public repl(VitryRuntime rt, Scope prelude) {
            super(prelude);
            this.rt = rt;
            this.read = (Function) getValue("parse");
            this.print = (Function) getValue("print");
        }

        /**
         * args ... -> ()
         * Standard read-eval-print loop.
         * 
         * TODO break into actual methods read/eval/print
         * TODO let definitions, module loading etc.
         */
        public Object applyVar(Seq<?> args) throws InvocationError {            
            printWelcome();
            

            BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in));
            Module module = rt.getPrelude();
            
            String line;
            try {
                while(true) {
                    System.out.print(module + "> ");
                    line = lineReader.readLine();
                    
                    try {
                        if (line.length() == 0){
                            continue;
                        }

                        Object tree = read.apply(line);
                        Object value = rt.getInterpreter().eval(tree, module);
                        print.apply(value);
                    } catch (ModuleLoaded e) {
                        module = e.module;
                        
                    } catch (Exception e) {
                        if (Build.DEBUG) {
                            e.printStackTrace();                            
                        } else {
                            System.err.println(e.getClass().getSimpleName() + ": " + e.getMessage());                            
                        }
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
