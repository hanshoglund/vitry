package vitry.prelude;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import vitry.runtime.Native;
import vitry.runtime.StandardFunction;
import vitry.runtime.VitryRuntime;
import vitry.runtime.error.IOError;
import vitry.runtime.error.InvocationError;
import vitry.runtime.struct.Seq;


/**
 * Utility to replace text in a file.
 */
public class replaceFile extends StandardFunction
{

    public replaceFile() {
        super(3);
    }

    public Object apply(Object name, Object xs, Object ys) throws InvocationError
    {
        String name2 = (String) name;
        Seq<String> xs2 = Native.<String>unwrapAll((Seq<?>) xs);
        Seq<String> ys2 = Native.<String>unwrapAll((Seq<?>) ys);

        name2 = name2.replace("~", System.getProperty("user.home"));
        
        {
            try
            {
                File file = new File(name2);
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = "", text = "";
                while ( (line = reader.readLine()) != null)
                {
                    Iterator<String> x = xs2.iterator();
                    Iterator<String> y = ys2.iterator();
                    while (x.hasNext() && y.hasNext())
                    {
                        line = line.replaceAll(x.next(), y.next());                    
                    }
                    text += line + "\n";
                }
                reader.close();

                FileWriter writer = new FileWriter(file);
                writer.write(text);
                writer.close();
            }
            catch (IOException ioe)
            {
                throw new IOError(ioe);
            }
        }
        return VitryRuntime.NIL;
    }


}
