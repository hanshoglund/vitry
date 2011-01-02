package vitry.primitive;

/**
 * The () type.
 */
public interface Product extends Value, Pattern
    {
    }


abstract class AbstractProduct extends AbstractPattern implements Product
    {
        public boolean match(Object o) {
            return false;
        }

        public boolean match(Product p) {
            Seq<Pattern> left = p;
            Seq<Pattern> right = this;

            while (left != null && right != null) {
                if (!left.head().matchedBy(right.head())) return false;
                left = left.tail();
                right = right.tail();
            }
            return (left == null && right == null);
        }

        public boolean match(Union p) {
            return false;
        }

        public boolean match(Set p) {
            return false;
        }

        public boolean match(Intersection p) {
            return false;
        }

        public boolean match(Type p) {
            return false;
        }

        public boolean match(FunctionType p) {
            return false;
        }

        public boolean matchedBy(Pattern p) {
            return p.match(this);
        }
        
        public boolean equals(Object o) {
            if (o instanceof Product) {
                Product p = (Product) o;
                
                Seq<Pattern> left = p;
                Seq<Pattern> right = this;

                while (left != null && right != null) {
                    if (!left.head().equals(right.head())) return false;
                    left = left.tail();
                    right = right.tail();
                }
                return (left == null && right == null);
            }
            return false;
        }
        
        // TODO hashCode
    }