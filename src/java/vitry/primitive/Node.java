package vitry.primitive;

/**
 * Abstracs operations on the value graph, allowing us to select different 
 * implementations and do optimization.
 * 
 * @author hans
 */
public abstract class Node {
    
    public Symbol getLabel() {
        return null;
    }

    public Node[] getParents() {
        return null;
    }
    
    public Node[] getChildren() {
        return null;
    }
}
