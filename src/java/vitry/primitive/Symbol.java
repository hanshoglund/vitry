package vitry.primitive;

import java.util.HashMap;
import java.util.Map;

/**
 * Invariants:
 *  Symbol.generate(S) = Symbol.generate(S) where S is any string
 * 
 * TODO
 *   - Change impl to use interned strings!
 * 
 * @author hans
 */
public class Symbol extends Atom
    {

        public static Symbol intern(String name) {
            if (table.containsKey(name)) return table.get(name);
            else {
                Symbol sym = new Symbol(name);
                table.put(name, sym);
                return sym;
            }
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            // return o == this || o.toString() == this.name;
            return o == this;
        }

        @Override
        public int hashCode() {
            if (cachedHashCode == 0)
                cachedHashCode = this.name.hashCode();
            return cachedHashCode;
        }

        private final String               name;
        private int                        cachedHashCode;


        private static Map<String, Symbol> table             = new HashMap<String, Symbol>();

        private Symbol(String name) {
            this.name = name;
        }
    }
