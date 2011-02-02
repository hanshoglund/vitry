package vitry.runtime;

/**
 * Represents the fixity of some operator.
 */
public class Fixity
    {
        private final Symbol operator;
        private final int precedence;
        private final boolean left;        
        
        public Fixity(Symbol operator, int precedence, boolean left) {
            this.operator = operator;
            this.precedence = precedence;
            this.left = left;
        }
        
        public Symbol operator() {
            return operator;
        }
        public int precedence() {
            return precedence;
        }
        public boolean isLeft() {
            return left;
        }
    }
