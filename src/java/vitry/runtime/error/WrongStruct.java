package vitry.runtime.error;

import vitry.runtime.Function;


class WrongStruct extends TypeError
{

    private static final long serialVersionUID = -8638773018875142506L;
    final Object value;
    final Function structor;
    private String msg;

    public WrongStruct(Object value, Function structor) {
        this.value = value;
        this.structor = structor;
    }

    @Override
    public String getMessage()
    {
        if (msg == null)
            msg = "Could not destruct " + makeFinite(value) + " using " + structor;
        return msg;
    }
}
