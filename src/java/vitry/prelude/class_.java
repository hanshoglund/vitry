package vitry.prelude;

import vitry.runtime.StandardFunction;
import vitry.runtime.Symbol;
import vitry.runtime.VitryRuntime;
import vitry.runtime.error.InvocationError;
import vitry.runtime.error.ResolveError;
import vitry.runtime.struct.Seqs;


public class class_ extends StandardFunction
{
    private static final String[] AUTO_PREFIXES = { 
        "", 
        "java.lang.", 
        "vitry.runtime.",
        "vitry.prelude." 
    };

    final VitryRuntime rt;

    public class_(VitryRuntime rt) {
        super(1);
        this.rt = rt;
    }


    /**
     * type class = symbol
     * 
     * class : str -> class
     * 
     * Loads the given class using reflection and returns a symbol
     * referencing it.
     */
    public Object apply(Object nameStr) throws InvocationError
    {
        Object res = null;
        for (String p : AUTO_PREFIXES)
        {
            try
            {
                res = Seqs.first(rt.internSymbolAndClass(p + ((String) nameStr)));
            }
            catch (ClassNotFoundException _)
            {
            }
        }
        if (res != null)
            return res;
        else
            throw new ResolveError("Could not find class " + nameStr);
    }
}