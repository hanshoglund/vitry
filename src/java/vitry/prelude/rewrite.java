package vitry.prelude;

import vitry.runtime.*;
import vitry.runtime.struct.Seq;


public class rewrite extends StandardFunction
{
    private VitryRuntime rt;

    public rewrite(VitryRuntime rt) {
        super(1, rt.getPrelude());
        this.rt = rt;
    }

    public Object apply(Object a)
    {
        Rec<Symbol, Fixity> fixities = rt.getPrelude().getFixities();
        Context ctxt = ((Interpreter) rt.getInterpreter()).getStandardContext();
        
        return Rewriting.opsRewriter(fixities, ctxt).rewrite((Seq<Pattern>) a);
    }
}