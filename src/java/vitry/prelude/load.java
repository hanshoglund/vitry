package vitry.prelude;

import vitry.runtime.Function;
import vitry.runtime.Module;
import vitry.runtime.StandardFunction;
import vitry.runtime.VitryRuntime;
import vitry.runtime.error.InvocationError;


public class load extends StandardFunction
{
    private VitryRuntime rt;
    private Function compose;
    private Function readFile;
    private Function eval;

    public load(VitryRuntime rt, Module prelude) {
        super(1, prelude);
        this.rt = rt;
        this.compose = (Function) getValue("(.)");
        this.readFile = (Function) getValue("readFile");
        this.eval = (Function) getValue("eval");
    }

    public Object apply(Object a) throws InvocationError
    {
        Module m = (Module) ((Function) compose.apply(eval, readFile)).apply(a);
        throw new ModuleLoaded(m);
    }
}


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