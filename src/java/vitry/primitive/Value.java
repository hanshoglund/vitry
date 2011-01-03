package vitry.primitive;

/**
 * Eq semantics.
 */
public interface Value
    {
        public boolean eq(Atom o);

        public boolean eq(Product o);
        
        public boolean eq(Union o);

        public boolean eq(Set o);

        public boolean eq(Intersection o);

        public boolean eq(Type o);

        public boolean eq(FunctionType o);

        public boolean eqFor(Value o);
    }
