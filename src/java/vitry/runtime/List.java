package vitry.runtime;

import vitry.runtime.struct.Seq;


public interface List extends Pattern, Seq<Pattern>
{

    List mapList(Function fn);

}