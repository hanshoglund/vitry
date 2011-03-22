package vitry.runtime.struct;

class ConcedSeq<T> extends AbstractSeq<T>
{
    final Seq<T> xs; // Always non-nil
    final Seq<T> ys;
    
    ConcedSeq(Seq<T> xs, Seq<T> ys) {
        this.xs = xs;
        this.ys = ys;
    }

    public T head()
    {
        return xs.head();
    }

    public Seq<T> tail()
    {
        return Seqs.concat(xs.tail(), ys);
    }

    public boolean hasTail()
    {
        return !Seqs.isNil(ys) || !Seqs.isNil(xs.tail());
    }
}