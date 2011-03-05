package vitry.prelude;

import vitry.runtime.Function;
import vitry.runtime.Module;
import vitry.runtime.StandardFunction;
import vitry.runtime.error.InvocationError;


public class load extends StandardFunction
{
    private Function compose;
    private Function parseFile;
    private Function eval;

    public load(Module prelude) {
        super(1, prelude);
        this.compose = (Function) getValue("(.)");
        this.parseFile = (Function) getValue("parseFile");
        this.eval = (Function) getValue("eval");
    }

    public Object apply(Object a) throws InvocationError
    {
        Module m = (Module) ((Function) compose.apply(eval, parseFile)).apply(a);
        throw new ModuleLoaded(m);
    }
}


@SuppressWarnings("serial")
final class ModuleLoaded extends RuntimeException
{
    final Module module;
    
    public ModuleLoaded(Module module) {
        this.module = module;
    }
    public synchronized Throwable fillInStackTrace()
    {
        return this;
    }
}