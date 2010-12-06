package vitry.primitive;

import java.util.HashMap;
import java.util.Map;

/**
 * Invariant: 
 *   Symbol.generate(S) equals Symbol.generate(S)
 * 
 * If we get memory problems, we should replace the table by a soft table,
 * trading of comparison efficiency. Note that equals will fall back on string
 * comparison in this case.
 * 
 * @author hans
 */
public class Symbol extends Atom {

    private final  String name;
    private static Map<String, Symbol> table = new HashMap<String, Symbol>();

    private Symbol(String name)
    {
        this.name = name;
    }

    public static Symbol generate(String name) {
        if (table.containsKey(name))
            return table.get(name);
        else {
            Symbol sym = new Symbol(name);
            table.put(name, sym);
            return sym;
        }
    }

    public String toString() {
        return name;
    }

    public boolean equals(Object o) {
        return o == this || o.toString() == this.name;
    }
}
