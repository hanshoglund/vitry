package vitry.primitive;

/**
 * 
 * @author hans
 */
public abstract class Atom extends Value {

    @Override
    public boolean hasValue(Value v) {
        return equals(v);
    }
    
    @Override
    public boolean isConcrete() {
        return true;
    }
}
