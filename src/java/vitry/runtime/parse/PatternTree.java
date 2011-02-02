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

import java.util.Iterator;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;

import vitry.runtime.Apply;
import vitry.runtime.Atom;
import vitry.runtime.Bijection;
import vitry.runtime.Function;
import vitry.runtime.Arrow;
import vitry.runtime.Intersection;
import vitry.runtime.InvocationError;
import vitry.runtime.Pattern;
import vitry.runtime.Product;
import vitry.runtime.SetLike;
import vitry.runtime.SimpleProduct;
import vitry.runtime.Tagged;
import vitry.runtime.Type;
import vitry.runtime.Union;
import vitry.runtime.Value;
import vitry.runtime.struct.IterableSequence;
import vitry.runtime.struct.MapSequence;
import vitry.runtime.struct.Sequence;
import vitry.runtime.struct.SequenceIterator;


/**
 * Reflects ANTLR-generated trees into Vitry.
 * 
 * Trees such as ^(a b c d) becomes (a, b, c, d) etc.
 * Currently assumes that ANTLR's list of children contains only PatternTrees.
 */
public class PatternTree extends CommonTree implements Product
    {

        private final Product delegee         = new SimpleProduct(this);
        
        private Sequence<Pattern> childSeq         = null;
        private boolean generatedSeq          = false;

        
        public PatternTree(Token payload) {
            super(payload);
        }
        
        public Pattern head() {
            if (!generatedSeq) generateSeq();
            
            if (hasPayload()) {
                return wrap(token);
            } else {
                return (childSeq == null) ? null : childSeq.head();
            }
        }

        public Sequence<Pattern> tail() {
            if (!generatedSeq) generateSeq();
            
            if (hasPayload()) {
                return (childSeq == null) ? null : childSeq;
            } else {
                return (childSeq == null) ? null : childSeq.tail();
            }
        }
        
        public boolean hasPayload() {
            return token != null;
        }
        
        public boolean hasTail() {
            if (hasPayload()) {
                return childSeq != null;
            } else {
                return childSeq != null && childSeq.tail() != null;
            }        
        }
        
        
        
        
        private void generateSeq() {
            
            if (children != null) {
                // Make a seq out of the ANTLR child list
                @SuppressWarnings("unchecked") // ANTLR api is non-generic
                Sequence<Pattern> itSeq = new IterableSequence<Pattern>(this.children);
                this.childSeq = new MapSequence<Pattern,Pattern>(new Function(1, null){
                    
                    // Replace singletons with their contained token
                    public Object apply(Object o) throws InvocationError {
                        CommonTree t = (CommonTree) o;
                        if (t.getChildCount() == 0 && t.getToken() != null) {
                            return wrap(t.getToken());
                        }
                        return t;
                    }
                }, itSeq);
            }
            generatedSeq = true;
        }
        
        private VitryToken wrap(Token t) {
            return new VitryToken(t);
        }

        public Iterator<Pattern> iterator() {
            return new SequenceIterator<Pattern>(this);
        }
        
        


        // Delegate rest of implementation

        public String toString() {
            return delegee.toString();
        }

        public boolean isDestructible() {
            return delegee.isDestructible();
        }


        public Sequence<Pattern> destruct() {
            return delegee.destruct();
        }


        public boolean match(Object o) {
            return delegee.match(o);
        }


        public boolean eq(Object o) {
            return delegee.eq(o);
        }


        public Pattern first() {
            return delegee.first();
        }


        public Pattern second() {
            return delegee.second();
        }


        public Sequence<Pattern> cons(Pattern head) {
            return delegee.cons(head);
        }


        public boolean match(Tagged o) {
            return delegee.match(o);
        }


        public boolean eq(Atom o) {
            return delegee.eq(o);
        }


        public boolean match(Product p) {
            return delegee.match(p);
        }


        public boolean eq(Tagged o) {
            return delegee.eq(o);
        }


        public boolean match(Union p) {
            return delegee.match(p);
        }


        public boolean eq(Product o) {
            return delegee.eq(o);
        }


        public boolean match(SetLike p) {
            return delegee.match(p);
        }


        public boolean eq(Union o) {
            return delegee.eq(o);
        }


        public boolean match(Intersection p) {
            return delegee.match(p);
        }


        public boolean eq(SetLike o) {
            return delegee.eq(o);
        }


        public boolean match(Type p) {
            return delegee.match(p);
        }


        public boolean eq(Intersection o) {
            return delegee.eq(o);
        }


        public boolean eq(Type o) {
            return delegee.eq(o);
        }


        public boolean eq(Arrow o) {
            return delegee.eq(o);
        }


        public boolean eqFor(Value o) {
            return delegee.eqFor(o);
        }


        public <U> Sequence<U> map(Apply fn) {
            return delegee.map(fn);
        }


        public boolean match(Atom o) {
            return delegee.match(o);
        }


        public boolean match(Arrow p) {
            return delegee.match(p);
        }


        public boolean matchFor(Pattern p) {
            return delegee.matchFor(p);
        }

        public Bijection structor() {
            return delegee.structor();
        }
    }
