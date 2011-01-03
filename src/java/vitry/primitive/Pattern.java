package vitry.primitive;

/**
 * Implements non-trivial matching semantics.
 * 
 * Invariants:
 *   - !(x instanceof Pattern) -> x = y <=> x : y
 * 
 * Semantics:
 *   this.match(x)    <=> x : this
 *   this.matchFor(x) <=> this : x
 */
public interface Pattern
    {
        boolean match(Object o);
        
        boolean match(Product p);

        boolean match(Union p);

        boolean match(Set p);

        boolean match(Intersection p);

        boolean match(Type p);

        boolean match(FunctionType p);
        
        boolean matchFor(Pattern p);
    }
