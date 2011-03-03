package vitry.runtime.struct;

import vitry.runtime.Native;

public class CharSeq extends AbstractSeq<Character> implements Finite<Character>
{
    private final CharSequence source;
    
    private CharSeq(CharSequence source) {
        this.source = source;
    }

    public Character head()
    {
        return source.charAt(0);
    }

    public Seq<Character> tail()
    {
        if (!hasTail()) return null;
        return new CharSeq(source.subSequence(1, length()));
    }
    
    public boolean hasTail()
    {
        return length() > 1;
    }

    public int length()
    {
        return source.length();
    }
    
    
    
    
    public static CharSeq from(Seq<?> source) {
        StringBuilder sb = new StringBuilder();
        while (!Seqs.isNil(source)) {
            sb.append((Character) Native.unwrap(source.head()));
            source = source.tail();
        }
        return new CharSeq(sb);
    }
    
    public static CharSeq from(CharSequence source) {
        if (source.length() < 1) 
            return null;
        else
            return new CharSeq(source);
    }

    public String toString()
    {
        return source.toString();
    }
    
    public static String toString(Seq<?> s) {
        return from(s).toString();
    }
}
