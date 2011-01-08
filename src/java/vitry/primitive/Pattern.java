package vitry.primitive;

/**
 * Matching semantics.
 * 
 *   this.match(x)    <=> x : this
 *   this.matchFor(x) <=> this : x
 */
public interface Pattern extends Value
    {
        boolean match(Atom o);
        
        boolean match(Tagged o);

        boolean match(Product p);

        boolean match(Union p);

        boolean match(Set p);

        boolean match(Intersection p);

        boolean match(Type p);

        boolean match(FunctionType p);
    }
