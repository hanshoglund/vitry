package vitry.runtime.struct;

import vitry.runtime.Function;
import vitry.runtime.VitryRuntime;

public class ThunkSeq<T> extends AbstractSeq<T>
{
    private final Function f;
    private T x;
    private Seq<T> xs;
    private boolean done;

    public ThunkSeq(Function f) {
        this.f = f;
    }

    public T head()
    {
        if (!done) calculate();
        return this.x;
    }

    public Seq<T> tail()
    {
        if (!done) calculate();
        return this.xs;
    }

    private void calculate()
    {
        this.done = true;
        Seq<T> res = (Seq<T>) f.apply(VitryRuntime.NIL);
        this.x = res.head();
        this.xs = res.tail();
    }
}
