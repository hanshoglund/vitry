package vitry.primitive;

/**
 * Instances represent values in the Vitry language, including atoms, functions
 * and types.
 * 
 * 
 * The equational reasoning used in Vitry is somewhat unconventional, based on a
 * a conceptual value graph. Here is an informal summary:
 * 
 * - Types, functions and values are dynamic entities created upon loading of
 * modules (pre-runtime) or function execution (runtime). - Values are
 * conceptually represented as nodes in a directed, labeled graph, called the
 * value graph. The structure of this graph determinate the semantics of each
 * value. - Nodes may have a unique label, represented by a symbol. - Acess to
 * nodes is controlled though these labels TODO - Nodes may have class label,
 * determining its semantics. - The graph may be rewritten for optimization, but
 * its semantics must not change. - The type system is structural, but suppports
 * nominal tags for matching purposes. - Equality <=> Identity. However equality
 * implies structural AND nominal equality. - Nominal equality is required for
 * matching and function application, but may be overridden by implicit
 * functions. - Types are predicates that match values.
 * 
 * 
 * - Concrete values represent computed lambda terms. These are atoms or
 * products containing other products and/or atoms. - Singleton products are
 * structurally equivalent to the contained value (these are used to represent
 * references).
 * 
 * - By adding types to the value graph we obtain subgraphs representing types.
 * Types may be enumerated by walking the type subgraph, or checked by searching
 * it. - Unions contains any number of values greater than one. - FunctionTypes
 * contains two values, representing its domain and codomain.
 * 
 * TODO kinds
 * 
 * 
 * Java representation: - Edges and labels are implemented by
 * vitry.primitive.Node - Nodes are represented as instances of
 * vitry.primitive.Value
 * 
 * Optimizations: - Flattening nested unions to a single level. - Removing
 * structurally equivalent values, redirecting its references. - Allthough the
 * value tree is not allowed to change *conceptually* we will of course garbage
 * collect every value that becomes non-reachable from user code.
 * 
 * @author hans
 */
public abstract class Value extends Node {

    @Override
    public boolean equals(Object o) {
        return false;
    }

    public boolean hasValue(Value v) {
        return false;
    }

    public boolean isConcrete() {
        return false;
    }

    @Override
    public Symbol getLabel() {
        return null;
    }

    @Override
    public Value[] getParents() {
        return null;
    }

    @Override
    public Value[] getChildren() {
        return null;
    }
}
