package vitry.runtime.error;

class WrongNumberOfElements extends TypeError
{

    private static final long serialVersionUID = -8638773018875142506L;
    final Object value;
    private String msg;

    public WrongNumberOfElements(Object value) {
        this.value = value;
    }

    @Override
    public String getMessage()
    {
        if (msg == null)
            msg = "Mismatching number of elements in " + makeFinite(value);
        return msg;
    }
}
