/*
 * Vitry, copyright (C) Hans Hoglund 2011
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * See COPYING.txt for details.
 */
package vitry.runtime;

import vitry.runtime.error.BindingError;


public class Context extends HashEnv<Symbol, Symbol>
{

    static final Symbol DELIMITER = Symbol.intern("delimiter");
    static final Symbol SIDE = Symbol.intern("side");
    static final Symbol QUOTED = Symbol.intern("quoted");
    static final Symbol MUTABLE = Symbol.intern("mutable");
    static final Symbol PAR = Symbol.intern("()");
    static final Symbol BRA = Symbol.intern("[]");
    static final Symbol ANG = Symbol.intern("{}");
    static final Symbol LEFT = Symbol.intern("left");
    static final Symbol RIGHT = Symbol.intern("right");
    static final Symbol TRUE = Symbol.intern("true");
    static final Symbol FALSE = Symbol.intern("false");

    public Context() {
        super();
    }

    public Context(Context context) {
        super(context);
    }

    public Context define(Symbol key, Symbol val) throws BindingError {
        super.define(key, val);
        return this;
    }

    public Context extend() {
        return new Context(this);
    }

    public Context extend(Symbol key, Symbol val) {
        return extend().define(key, val);
    }

    public boolean isLeftSide() {
        return this.lookup(SIDE) == LEFT;
    }

    public boolean isMutable() {
        return this.lookup(MUTABLE) == TRUE;
    }

    public boolean isQuoted() {
        return this.lookup(QUOTED) == TRUE;
    }

    public Symbol getDelimiter() {
        return this.lookup(DELIMITER);
    }

    public boolean shouldLookup() {
        return !this.isLeftSide() && !this.isQuoted();
    }

}