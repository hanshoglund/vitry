package vitry.primitive;

import java.util.Iterator;

public class Unit extends Atom implements Product
    {
        private Unit() {}

        private static Unit instance = new Unit();

        public static Unit getInstance() {
            return instance;
        }

        public Iterator<Pattern> iterator() {
            throw new UnsupportedOperationException();
        }

        public String toString() {
            return "()";
        }

        public Pattern head() {
            return null;
        }

        public Seq<Pattern> tail() {
            return null;
        }
    }
