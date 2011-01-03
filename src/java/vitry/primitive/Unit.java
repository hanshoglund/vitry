package vitry.primitive;

import java.util.Iterator;

public class Unit extends Atom implements Product
    {
        private Unit() {}

        private static Unit instance = new Unit();

        public static Unit getInstance() {
            return instance;
        }

        public String toString() {
            return "()";
        }
        
        public Pattern head() {
            throw new AssertionError("Attempted to read head of ().");
        }

        public Seq<Pattern> tail() {
            throw new AssertionError("Attempted sequencing over ().");
        }

        public Iterator<Pattern> iterator() {
            return new SeqIterator<Pattern>(this);
        }
    }
