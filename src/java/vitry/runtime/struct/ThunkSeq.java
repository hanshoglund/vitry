package vitry.runtime.struct;

import vitry.runtime.Function;
import vitry.runtime.VitryRuntime;

public class ThunkSeq<T> extends AbstractSeq<T>
{
    private final Function f;
    private T x;
    private Seq<T> xs;
    private boolean done;
    private boolean isNil;

    public ThunkSeq(Function f) {
        this.f = f;
    }

    public T head()
    {
        if (!this.done) calculate();
        if (this.isNil) VitryRuntime.throwDeconstructNil();
        return this.x;
    }

    public Seq<T> tail()
    {
        if (!this.done) calculate();
        if (this.isNil) VitryRuntime.throwDeconstructNil();
        return this.xs;
    }

    public boolean isNil()
    {
        if (!done) calculate();
        return this.isNil;
    }

    private void calculate()
    {
        this.done = true;
        Seq<T> res = (Seq<T>) f.apply(VitryRuntime.NIL);
        if (Seqs.isNil(res))
        {
            this.isNil = true;
        }
        else
        {
            this.x = res.head();
            this.xs = res.tail();            
        }
        
    }
}
