package vitry.primitive;

/**
 * 
 * @author hans
 */
public abstract class Atom extends Value {

    public boolean isConcrete() {
        return true;
    }
}
