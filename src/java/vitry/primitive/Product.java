package vitry.primitive;

import java.util.Iterator;

/**
 * The () type.
 * 
 * Invariants:
 *   - For any product p, p.tail() != null 
 *     (we can not guarantee equality to be reflexive in this case)
 * 
 */
public interface Product extends Value, Pattern, Seq<Pattern>
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
                if (!left.head().matchFor(right.head())) return false;
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

        public boolean matchFor(Pattern p) {
            return p.match(this);
        }
        
        public boolean equals(Object o) {
            if (o == this)
                return true;
            
            if (o instanceof Product) {
                Seq<Pattern> left = (Product) o;
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
        
        public Iterator<Pattern> iterator() {
            return new SeqIterator<Pattern>(this);
        }
        
        public String toString() {
            return Util.join(this, "(", ", ", ")");
        }
    }