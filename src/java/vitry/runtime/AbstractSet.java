package vitry.runtime;

import vitry.runtime.misc.MiscUtil;

abstract class AbstractSet extends CompoundPattern implements Set
{
    public boolean match(Atom a) {
        for (Pattern x : this)
            if (x.eq(a)) return true;
        return false;
    }

    public boolean match(Product a) {
        for (Pattern x : this)
            if (x.eq(a)) return true;
        return false;
    }

    public boolean eqFor(Value p) {
        return p.eq(this);
    }

    public boolean matchFor(Pattern p) {
        return p.match(this);
    }

    public String toString() {
        return MiscUtil.join(this, "{", ", ", "}");
    }
}