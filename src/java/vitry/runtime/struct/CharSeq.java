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
package vitry.runtime.struct;

import vitry.runtime.Native;

public class CharSeq extends AbstractSeq<Character> implements Finite<Character>
{
    private final CharSequence source;
    
    private CharSeq(CharSequence source) {
        this.source = source;
    }

    public Character head()
    {
        return source.charAt(0);
    }

    public Seq<Character> tail()
    {
        if (!hasTail()) return null;
        return new CharSeq(source.subSequence(1, length()));
    }
    
    public boolean hasTail()
    {
        return length() > 1;
    }

    public int length()
    {
        return source.length();
    }
    
    
    
    
    public static CharSeq from(Seq<?> source) {
        // TODO unwrapping necessary?
        StringBuilder sb = new StringBuilder();
        while (!Seqs.isNil(source)) {
            sb.append((Character) Native.unwrap(source.head()));
            source = source.tail();
        }
        return new CharSeq(sb);
    }
    
    public static CharSeq from(CharSequence source) {
        if (source.length() < 1) 
            return null;
        else
            return new CharSeq(source);
    }

    public String toString()
    {
        return source.toString();
    }
    
    public static String toString(Seq<?> s) {
        return from(s).toString();
    }
}
