package vitry.primitive;

/**
 * Values that may appear on the right side of a match expression.
 * 
 * this.match(x)     <=> x : this
 * this.matchedBy(x) <=> this : x
 * 
 */
public interface Pattern extends Seq<Pattern>
    {
        boolean match(Object o);
        
        boolean match(Product p);

        boolean match(Union p);

        boolean match(Set p);

        boolean match(Intersection p);

        boolean match(Type p);

        boolean match(FunctionType p);
        
        boolean matchedBy(Pattern p);
    }
