package vitry.runtime;

import vitry.runtime.struct.Seq;


public interface List extends Pattern, Seq<Pattern>
{

    List cons(Pattern p);
    List mapList(Function fn);
}