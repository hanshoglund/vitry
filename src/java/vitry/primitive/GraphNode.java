package vitry.primitive;

/**
 * Abstracts away operations on the value graph.
 * 
 * TODO 
 * 
 * @author hans
 */
public abstract class GraphNode {
    
    public Symbol getLabel() {
        return null;
    }

    public Value[] getParents() {
        return null;
    }
    
    public Value[] getChildren() {
        return null;
    }
}
