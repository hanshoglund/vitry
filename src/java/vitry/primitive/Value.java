package vitry.primitive;

/**
 * Instances represent values in the Vitry language, including atoms, functions
 * and types.
 * 
 * 
 * The equational reasoning used in Vitry is somewhat unconventional, based on a 
 * a conceptual value graph. Here is an informal summary:
 *   
 * - The type system is structural, but suppports nominal tags for matching purposes.
 *     - Equality <=> Identity. However equality implies structural AND nominal equality.
 *     - Nominal equality is required for matching and function application, but not otherwise.
 *     - Type conversions may be carried out by implicit functions, thus providing nominal
 *       equality when needed.
 * - Types, functions and values are dynamic entities created upon loading
 *   of modules (pre-runtime) or function execution (runtime).
 * 
 * - Values are conceptually represented as nodes in a directed, labeled graph, called the 
 *   value graph. The structure of this graph represent determinate type and value semantics.
 *     - The value graph may be extended (by loading more modules) but never changed.
 *     - The graph may be rewritten for optimization, but its semantics must not change.
 *     - Nodes may have a unique label, represented by a symbol, meaning that they can
 *       be accessed from within the language. This mechanism underlies variables etc.
 *     - Nodes may have class label, being either atoms, products, unions, funtionTypes or kinds.
 * 
 * - Concrete values represent computed lambda terms. These are atoms or products containing 
 *   other products and/or atoms.
 *     - Singleton products are structurally equivalent to the contained value (these
 *       are used to represent references).
 *       
 * - By adding functionTypes and unions to the value graph we obtain subgraphs representing
 *   types. Types represent a set of concrete values. These may be enumerated by walking
 *   the graph or checked by searching it. 
 *     - A union is successed by several concrete or non-concrete values.
 *     - A functionType is successed by two vertices, representing its domain and codomain.
 * 
 * - By adding kinds to the value graph we obtain subgraphs representing type classes. 
 *     - An arrowKind is successed by two vertices, representing its domain and codomain.
 *     - A typeKind ...?
 *     
 * 
 * Java representation:
 * - Nodes are represented as instances of vitry.primitive.Value
 * - Edges and labels are implemented by vitry.primitive.GraphNode
 * 
 * Optimizations:
 * - Flattening nested unions to a single level.
 * - Removing structurally equivalent values, redirecting its references.
 *
 * @author hans
 */
public abstract class Value extends GraphNode {

    public boolean equals(Object o) {
        return false;
    }

    public boolean hasValue(Value v) {
        return false;
    }
}
