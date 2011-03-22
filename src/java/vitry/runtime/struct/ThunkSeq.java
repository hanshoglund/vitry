package vitry.runtime.struct;

import vitry.runtime.Function;
import vitry.runtime.VitryRuntime;
import vitry.runtime.misc.Utils;

public class ThunkSeq<T> extends AbstractSeq<T>
{
    private final Function thunk;
    private Seq<T> result;
    private boolean isNil;
    private boolean done;

    public ThunkSeq(Function f) {
        this.thunk = f;
    }

    public T head()
    {
        if (!this.done) eval();
        if (this.isNil) VitryRuntime.throwDeconstructNil();
        return this.result.head();
    }

    public Seq<T> tail()
    {
        if (!this.done) eval();
        if (this.isNil) VitryRuntime.throwDeconstructNil();
        return this.result.tail();
    }

    public boolean isNil()
    {
        if (!this.done) eval();
        return this.isNil;
    }

    private void eval()
    {
        this.result = Utils . <Seq<T>> unsafe(thunk.apply(null));
        
        if (Seqs.isNil(result))
        {
            this.isNil = true;
        }
        this.done = true;
    }
}
