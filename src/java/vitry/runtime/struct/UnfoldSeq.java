//package vitry.runtime.struct;
//
//import vitry.runtime.Function;
//import vitry.runtime.Native;
//
//public class UnfoldSeq<T> extends AbstractSeq<T>
//{
//    private final Function f;
//    private T z;
//    private T x;
//    private T y;
//    private boolean done;
//    
//    public UnfoldSeq(Function f, T init) {
//        this.f = f;
//        this.z = init;
//    }
//
//    public T head()
//    {
//        if (!done) calculate();
//        return x;
//    }
//
//    @SuppressWarnings({ "rawtypes", "unchecked" })
//    public Seq<T> tail()
//    {
//        if (!done) calculate();
//        return new UnfoldSeq(f, y);
//    }
//
//    @SuppressWarnings("unchecked")
//    private void calculate()
//    {
//        Seq<?> ys = (Seq<?>) this.f.apply(this.z);
//        this.x = (T) Native.unwrap(Seqs.first(ys));
//        this.y = (T) Native.unwrap(Seqs.second(ys));
//        this.done = true;
//    }
//
//    public boolean hasTail()
//    {
//        return true;
//    }
//}
