package vitry.prelude;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import vitry.Build;
import vitry.runtime.StandardFunction;
import vitry.runtime.VitryRuntime;
import vitry.runtime.error.IOError;

public class writeFile extends StandardFunction
    {
        private VitryRuntime rt;

        public writeFile(VitryRuntime rt) {
            super(2, rt.getPrelude());
            this.rt = rt;
        }

        public Object apply(Object name, Object contents) {
            try
            {
                String name2 = ((String) name).replaceFirst("~", System.getProperty("user.home"));
                Writer w = new FileWriter(name2);
                w.write((String) contents);
                w.close();
            } 
            catch (IOException e)
            {
                if (Build.DEBUG) {
                    e.printStackTrace();
                } else {
                    throw new IOError("Could not write file " + name);                    
                }
            }
            return VitryRuntime.NIL;
        }
    }