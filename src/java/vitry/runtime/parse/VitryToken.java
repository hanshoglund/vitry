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
package vitry.runtime.parse;

import org.antlr.runtime.*;
import vitry.runtime.*;


/**
 * Simple wrapper for CommonToken that displays, equals and matches as
 * its text. The string constructor is used to construct dummy tokens
 * (for matching).   
 *
 * @author Hans Hoglund 
 */
public class VitryToken extends Atom
{
    final Token tok;
    final String str;

    public VitryToken(Token tok) {
        this.tok = tok;
        this.str = tok.getText();
    }

    public VitryToken(String str) {
        this.tok = null;
        this.str = str;
    }

    public boolean equals(Object o)
    {
        if (o instanceof VitryToken)
            return this.str == o.toString();
        return false;
    }

    /**
     * Returns the orginal token or null if this is a dummy.
     */
    public Token getToken()
    {
        return tok;
    }

    public int getTokenType()
    {
        return tok.getType();
    }

    public String toString()
    {
        return str;
    }
}
