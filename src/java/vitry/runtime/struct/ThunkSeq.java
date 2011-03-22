package vitry.runtime.struct;

import vitry.runtime.Function;
import vitry.runtime.VitryRuntime;
import vitry.runtime.misc.Utils;

public class ThunkSeq<T> extends AbstractSeq<T> implements Thunk
{
    private final Function f;
    private T x;
    private Seq<T> xs;
    private boolean isNil;
    private boolean done;

    public ThunkSeq(Function f) {
        this.f = f;
    }

    public T head()
    {
        if (!this.done) eval();
        if (this.isNil) VitryRuntime.throwDeconstructNil();
        return this.x;
    }

    public Seq<T> tail()
    {
        if (!this.done) eval();
        if (this.isNil) VitryRuntime.throwDeconstructNil();
        return this.xs;
    }

    public boolean isNil()
    {
        if (!done) eval();
        return this.isNil;
    }

    private void eval()
    {
        Seq<T> ys = (Seq<T>) f.apply(VitryRuntime.NIL);
        
        if (Seqs.isNil(ys))
        {
            this.isNil = true;
        }
        else
        {
            this.x = ys.head();
            this.xs = ys.tail();            
        }        
        this.done = true;
    }

    public boolean isDone()
    {
        return done;
    }
}
