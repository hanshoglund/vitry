package vitry.primitive;

import java.util.HashMap;
import java.util.Map;

/**
 * Invariants:
 *  Symbol.generate(S) = Symbol.generate(S) where S is any string
 * 
 * If we get memory problems, we should replace the table by a soft table,
 * trading of comparison efficiency. In this case equals must fall back on
 * string comparison.
 * 
 * @author hans
 */
public class Symbol extends Atom {

    public static Symbol intern(String name) {
        if (table.containsKey(name))
            return table.get(name);
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
        if (!hasCachedHashCode) {
            cachedHashCode = this.name.hashCode();
            hasCachedHashCode = true;
        }
        return cachedHashCode;
    }

    private final String name;
    private boolean hasCachedHashCode = false;
    private int cachedHashCode;
    private static Map<String, Symbol> table = new HashMap<String, Symbol>();

    private Symbol(String name)
    {
        this.name = name;
    }
}
