package vitry.primitive;

import java.util.Iterator;

/**
 * The () value.
 */
public class Unit extends Atom implements Product
    {
        private Unit() {}

        private static Unit instance = new Unit();

        public static Unit getInstance() {
            return instance;
        }

        public boolean eq(Atom o) {
            return o == this;
        }

        public String toString() {
            return "()";
        }
        
        public Product first() {
            throw new RuntimeException("() has no members");
        }
        
        public Product second() {
            throw new RuntimeException("() has no members");
        }
        
        public Pattern head() {
            throw new RuntimeException("Attempted to read head of ()");
        }

        public Seq<Pattern> tail() {
            throw new RuntimeException("Attempted sequencing over ()");
        }

        public Iterator<Pattern> iterator() {
            throw new RuntimeException("Attempted sequencing over ()");
        }
    }
