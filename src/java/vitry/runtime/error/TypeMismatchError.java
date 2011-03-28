package vitry.runtime.error;

public class TypeMismatchError extends TypeError
{

    private static final long serialVersionUID = -8638773018875142506L;
    final Object left;
    final Object right;
    private String msg;

    public TypeMismatchError(Object left, Object right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String getMessage()
    {
        if (msg == null)
        {
            msg = ("" + makeFinite(left) + " does not conform to " + makeFinite(right));            
        }
        return msg;
    }
}
