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
public interface Product extends Pattern, Seq<Pattern>
    {
    }


abstract class AbstractProduct extends AbstractPattern implements Product
    {
        public boolean eq(Product o) {
            Seq<Pattern> left = o;
            Seq<Pattern> right = this;

            while (left != null && right != null) {
                if (!left.head().eqFor(right.head())) return false;
                left = left.tail();
                right = right.tail();
            }
            return (left == null && right == null);
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

        public boolean match(Intersection a) {
            for (Pattern x : a)
                if (x.matchFor(this)) return true;
            return false;
        }

        public boolean match(Type p) {
            return false;
            // TODO
        }

        public boolean match(FunctionType p) {
            return false;
            // TODO
        }

        public boolean eqFor(Value p) {
            return p.eq(this);
        }

        public boolean matchFor(Pattern p) {
            return p.match(this);
        }

        
        // Java stuff
        
        public boolean equals(Object o) {
            if (o == this) return true;
            if (o instanceof Product) return eq((Product) o);
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