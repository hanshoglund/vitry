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
import org.antlr.runtime.tree.Tree;

import vitry.runtime.Apply;
import vitry.runtime.Atom;
import vitry.runtime.FunctionType;
import vitry.runtime.Intersection;
import vitry.runtime.Native;
import vitry.runtime.Pattern;
import vitry.runtime.Product;
import vitry.runtime.Set;
import vitry.runtime.SimpleProduct;
import vitry.runtime.Tagged;
import vitry.runtime.Type;
import vitry.runtime.Union;
import vitry.runtime.Value;
import vitry.runtime.struct.IterableSeq;
import vitry.runtime.struct.Seq;
import vitry.runtime.struct.SeqIterator;


/**
 * Reflects ANTLR-generated trees into Vitry.
 * 
 * Trees such as ^(a b c d) becomes (a, b, c, d) etc.
 */
public class PatternTree extends CommonTree implements Product
    {

        private final Product delegee         = new SimpleProduct(this);
        
        private IterableSeq<Pattern> childSeq = null;
        private boolean generatedChildSeq     = false;

        
        public PatternTree(Token payload) {
            super(payload);
        }
        
        private void generateChildSeq() {
            if (children != null) {
                // Assume that ANTLR's list of children only contains
                // PatternTrees
                this.childSeq = new IterableSeq<Pattern>(this.children);
            }
            generatedChildSeq = true;
        }

        public Pattern head() {
            if (!generatedChildSeq) 
                generateChildSeq();
            
            // Check if we have payload
            if (token == null) {
                return (childSeq == null) ? null : childSeq.head();
            } else {
                return Native.wrap(token.getText());
            }
        }

        public Seq<Pattern> tail() {
            if (!generatedChildSeq) 
                generateChildSeq();

            if (childSeq == null) 
                return null;
            
            if (token == null) {
                return childSeq.tail();
            } else {
                return childSeq;
            }
        }
        
        
        


        // Delegate rest of implementation
        
        public Iterator<Pattern> iterator() {
            return new SeqIterator<Pattern>(this);
        }

        public String toString() {
            return delegee.toString();
        }

        public boolean isDestructible() {
            return delegee.isDestructible();
        }


        public Seq<Pattern> destruct() {
            return delegee.destruct();
        }


        public boolean match(Object o) {
            return delegee.match(o);
        }


        public boolean eq(Object o) {
            return delegee.eq(o);
        }


        public Pattern fst() {
            return delegee.fst();
        }


        public Pattern snd() {
            return delegee.snd();
        }


        public Pattern _1() {
            return delegee._1();
        }


        public Seq<Pattern> cons(Pattern head) {
            return delegee.cons(head);
        }


        public boolean match(Tagged<?> o) {
            return delegee.match(o);
        }


        public Pattern _2() {
            return delegee._2();
        }


        public boolean eq(Atom o) {
            return delegee.eq(o);
        }


        public Pattern _3() {
            return delegee._3();
        }


        public boolean match(Product p) {
            return delegee.match(p);
        }


        public boolean eq(Tagged<?> o) {
            return delegee.eq(o);
        }


        public Pattern _4() {
            return delegee._4();
        }


        public boolean match(Union p) {
            return delegee.match(p);
        }


        public Pattern _5() {
            return delegee._5();
        }


        public boolean eq(Product o) {
            return delegee.eq(o);
        }


        public boolean match(Set p) {
            return delegee.match(p);
        }


        public Pattern _6() {
            return delegee._6();
        }


        public boolean eq(Union o) {
            return delegee.eq(o);
        }


        public boolean match(Intersection p) {
            return delegee.match(p);
        }


        public Pattern _7() {
            return delegee._7();
        }


        public boolean eq(Set o) {
            return delegee.eq(o);
        }


        public boolean match(Type p) {
            return delegee.match(p);
        }


        public Pattern _8() {
            return delegee._8();
        }


        public boolean eq(Intersection o) {
            return delegee.eq(o);
        }


        public Pattern _9() {
            return delegee._9();
        }


        public boolean eq(Type o) {
            return delegee.eq(o);
        }


        public boolean eq(FunctionType o) {
            return delegee.eq(o);
        }


        public boolean eqFor(Value o) {
            return delegee.eqFor(o);
        }


        public <U> Seq<U> map(Apply fn) {
            return delegee.map(fn);
        }


        public boolean match(Atom o) {
            return delegee.match(o);
        }


        public boolean match(FunctionType p) {
            return delegee.match(p);
        }


        public boolean matchFor(Pattern p) {
            return delegee.matchFor(p);
        }
    }
