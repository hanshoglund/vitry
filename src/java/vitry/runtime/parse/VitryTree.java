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

import vitry.runtime.*;
import vitry.runtime.error.*;
import vitry.runtime.struct.*;
import vitry.runtime.util.*;


/**
 * Reflects antlr syntax trees into Vitry. Each node is a Product containing
 * its children. The head token is the first child.
 *
 * @author Hans Höglund
 */
public class VitryTree extends CommonTree implements Product
    {
        private final Product delegee      = VitryRuntime.productFrom(this);
        private Sequence<Pattern> childSeq = null;
        private boolean generatedSeq       = false;
        
        public VitryTree(Token payload) {
            super(payload);
        }
        
        public Pattern head() {
            if (!generatedSeq) generateSeq();
            if (hasPayload())
                return wrap(token);
            else
                return (childSeq == null) ? null : childSeq.head();
        }

        public Sequence<Pattern> tail() {
            if (!generatedSeq) generateSeq();
            if (hasPayload())
                return (childSeq == null) ? null : childSeq;
            else
                return (childSeq == null) ? null : childSeq.tail();
        }

        public Iterator<Pattern> iterator() {
            return new SequenceIterator<Pattern>(this);
        }

        public boolean hasTail() {
            if (hasPayload()) {
                return childSeq != null;
            } else {
                return childSeq != null && childSeq.tail() != null;
            }
        }

        public boolean hasPayload() {
            return token != null;
        }
        
        /**
         * Converts the child list to a sequence, and replace singletons nodes
         * with the token they contain.
         */
        private void generateSeq() {

            if (children != null) {
                Sequence<Pattern> itSeq = 
                    new IterableSequence<Pattern>(Utils.<Iterable<Pattern>> unsafe(this.children));

                this.childSeq = new MapSequence<Pattern, Pattern>(new StandardFunction(1)
                    {
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



        // Delegate rest of interface

        public boolean eq(Object o) {
            return delegee.eq(o);
        }

        public Product mapProduct(Function fn) {
            return delegee.mapProduct(fn);
        }

        public boolean eq(Atom o) {
            return delegee.eq(o);
        }

        public Product cons(Pattern p) {
            return delegee.cons(p);
        }

        public boolean eq(Tagged o) {
            return delegee.eq(o);
        }

        public boolean eq(Product o) {
            return delegee.eq(o);
        }

        public <U> Sequence<U> map(Function fn) {
            return delegee.map(fn);
        }

        public boolean eq(Function p) {
            return delegee.eq(p);
        }

        public boolean eq(List p) {
            return delegee.eq(p);
        }

        public SequenceIterator<Pattern> sequenceIterator() {
            return delegee.sequenceIterator();
        }

        public boolean eq(Set o) {
            return delegee.eq(o);
        }

        public boolean eq(Union o) {
            return delegee.eq(o);
        }

        public boolean eq(Intersection o) {
            return delegee.eq(o);
        }

        public boolean eq(Type o) {
            return delegee.eq(o);
        }

        public boolean match(Object o) {
            return delegee.match(o);
        }

        public boolean match(Atom o) {
            return delegee.match(o);
        }

        public boolean match(Tagged o) {
            return delegee.match(o);
        }

        public boolean match(Product p) {
            return delegee.match(p);
        }

        public boolean match(Function p) {
            return delegee.match(p);
        }

        public boolean match(List p) {
            return delegee.match(p);
        }

        public boolean match(Set p) {
            return delegee.match(p);
        }

        public boolean match(Union p) {
            return delegee.match(p);
        }

        public boolean match(Intersection p) {
            return delegee.match(p);
        }

        public boolean match(Type p) {
            return delegee.match(p);
        }

        public boolean eqFor(Pattern o) {
            return delegee.eqFor(o);
        }

        public boolean matchFor(Pattern p) {
            return delegee.matchFor(p);
        }

        public String toString() {
            return delegee.toString();
        }    
    }
