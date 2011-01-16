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

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.TreeAdaptor;


public class PatternTreeAdaptor implements TreeAdaptor
    {
        // type tree = token | [tree]
        
        Set token = NativeType.forClass(Token.class);
//        Type tree = Util.type(
//                Util.union(token, new ListType(tree)), 
//                "tree");
        
        public Pattern create(Token payload) {
            return Native.wrap(payload);
        }

        public Pattern create(int type, Token fromToken) {
            Token newToken = new CommonToken(fromToken);
            newToken.setType(type);
            return create(newToken);
        }

        public Pattern create(int type, String text) {
            return create(new CommonToken(type, text));
        }

        public void addChild(Object t, Object child) {
            if (t == null || child == null) return;
            
            // TODO
        }

        public Pattern becomeRoot(Object newRoot, Object oldRoot) {
            return null;
            // TODO Auto-generated method stub
        }

        public Pattern becomeRoot(Token newRoot, Object oldRoot) {
            return null;
            // TODO Auto-generated method stub
        }

        public Pattern create(int type, Token fromToken, String text) {
            return null;
            // TODO Auto-generated method stub
        }

        public Pattern deleteChild(Object t, int i) {
            return null;
            // TODO Auto-generated method stub
        }

        public Pattern dupNode(Object treeNode) {
            return null;
            // TODO Auto-generated method stub
        }

        public Pattern dupTree(Object tree) {
            return null;
            // TODO Auto-generated method stub
        }

        public Pattern errorNode(TokenStream input, Token start, Token stop,
                RecognitionException e) {
            return null;
            // TODO Auto-generated method stub
        }

        public Pattern getChild(Object t, int i) {
            return null;
            // TODO Auto-generated method stub
        }

        public int getChildCount(Object t) {
            return 0;
            // TODO Auto-generated method stub
        }

        public int getChildIndex(Object t) {
            return 0;
            // TODO Auto-generated method stub
        }

        public Pattern getParent(Object t) {
            return null;
            // TODO Auto-generated method stub
        }

        public String getText(Object t) {
            return null;
            // TODO Auto-generated method stub
        }

        public Token getToken(Object t) {
            return null;
            // TODO Auto-generated method stub
        }

        public int getTokenStartIndex(Object t) {
            return 0;
            // TODO Auto-generated method stub
        }

        public int getTokenStopIndex(Object t) {
            return 0;
            // TODO Auto-generated method stub
        }

        public int getType(Object t) {
            return 0;
            // TODO Auto-generated method stub
        }

        public int getUniqueID(Object t) {
            return 0;
            // TODO Auto-generated method stub
        }

        public boolean isNil(Object t) {
            return false;
            // TODO Auto-generated method stub
        }

        public Pattern nil() {
            return null;
            // TODO Auto-generated method stub
        }

        public void replaceChildren(Object parent, int startChildIndex, int stopChildIndex,
                Object t) {
            // TODO Auto-generated method stub
        }

        public Pattern rulePostProcessing(Object root) {
            return null;
            // TODO Auto-generated method stub
        }

        public void setChild(Object t, int i, Object child) {
            // TODO Auto-generated method stub
        }

        public void setChildIndex(Object t, int index) {
            // TODO Auto-generated method stub
        }

        public void setParent(Object t, Object parent) {
            // TODO Auto-generated method stub
        }

        public void setText(Object t, String text) {
            // TODO Auto-generated method stub
        }

        public void setTokenBoundaries(Object t, Token startToken, Token stopToken) {
            // TODO Auto-generated method stub
        }

        public void setType(Object t, int type) {
            // TODO Auto-generated method stub
        }

    }
