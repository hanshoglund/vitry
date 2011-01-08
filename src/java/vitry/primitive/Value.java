package vitry.primitive;


public interface Value
    {
        boolean eq(Atom o);
        
        boolean eq(Tagged o);

        boolean eq(Product o);
        
        boolean eq(Union o);

        boolean eq(Set o);

        boolean eq(Intersection o);

        boolean eq(Type o);
        
        boolean eq(FunctionType o);

        boolean eqFor(Value o);
        
        boolean matchFor(Pattern p);
    }
