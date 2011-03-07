package vitry.runtime.struct;

import vitry.runtime.Function;
import vitry.runtime.Native;

public class LeftUnfoldSeq<T> extends AbstractSeq<T>
{
    private final Function f;
    private T init;
    private T x;
    private T y;
    private boolean done;
    
    public LeftUnfoldSeq(Function f, T init) {
        this.f = f;
        this.init = init;
    }

    public T head()
    {
        if (!done) calculate();
        return x;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Seq<T> tail()
    {
        if (!done) calculate();
        return new LeftUnfoldSeq(f, y);
    }

    @SuppressWarnings("unchecked")
    private void calculate()
    {
        Seq<?> ys = (Seq<?>) this.f.apply(this.init);
        this.x = (T) Native.unwrap(Seqs.first(ys));
        this.y = (T) Native.unwrap(Seqs.second(ys));
        this.done = true;
    }

    public boolean hasTail()
    {
        return true;
    }
}
