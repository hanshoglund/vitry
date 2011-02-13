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

import static vitry.runtime.VitryRuntime.product;
import static vitry.runtime.struct.Sequences.*;

import vitry.runtime.error.*;
import vitry.runtime.parse.*;
import vitry.runtime.struct.*;
import vitry.runtime.util.*;

/**
 * Rewrites opererator-form syntax trees into application-form.
 */        
class OperatorRewrite
    {
        public OperatorRewrite(
            Environment<Symbol, Fixity> fixities,
            Environment<Symbol, Symbol> context) 
        {
            this.fixities = fixities;
            this.context = context;
            this.delimiter = context.lookup(Interpreter.DELIMITER);
        }
        
        final Environment<Symbol, Fixity> fixities;
        
        final Environment<Symbol, Symbol> context;
        
        final Symbol delimiter;

        
        /**
         * Rewrite the given sequence of operator trees into a single
         * expression. The sequence may be headed by a non-optree expression.
         * 
         * An operator tree is an expression such as (+ 2 ...) where + is any
         * operator.
         * 
         * This algorithm proceeds by locating the highest-precedence 
         * operator tree and unify it with its antecedent. If several elements
         * compete for highest precedence, the leftmost or rightmost expression
         * is selected, based on the associativity of the operator in question.
         * 
         * The first element is never considered as it always represents a 
         * non-optree expression or a unary operator tree.
         * 
         * Returns an (Apply, +, ...) expression.
         */
        public Product rewrite(Sequence<Pattern> seq) {
            
            /*
             * If the expression is in normal form, convert it to application
             * form and return
             */
             
            if (length(seq) == 1) {
                return rewriteAsApplication((Product) seq.head());
            }
            
            /*
             * Find the element of highest precedence.
             * 
             * Also store its direct predecessor element, all other preceding elements,
             * and all following elements.
             */
            
            Fixity fix = null;
            Product before = null;
            Pattern pred = null;
            Pattern prim = null;
            Product after = null;
            
            SequenceIterator<Pattern> it = iterate(seq);
            int max = -1;
            
            
            for (Pattern now = null, last = null; it.hasNext();) {
                last = now;
                now = it.next();
                
                /*
                 * Skip expressions that are not operator trees.
                 * This may include already normalized expressions.
                 * 
                 * Always skip the first value.
                 */
                
                if (last == null || !isOpTree(now)) continue;
                
                fix = getFixity(now);
                if (fix != null 
                    && (fix.getPrecedence() > max 
                        || (fix.getPrecedence() == max 
                            && !fix.getAssociativity()))) {

                    prim = (Product) now;
                    pred = last;
                    after = product(it.following());
                    max = fix.getPrecedence();
                }
            }
            if (prim == null || fix == null) throw new ParseError("Correputed operator tree " + seq);
            
            /*
             * Find preceding elements by backtracking
             */
            before = product(pred == null ? null : untilElement(seq, pred));
            
            /*
             * Now we have (before ++ pred ++ prim ++ after) == seq
             */
            
            Pattern hoist;
            Product insert, unify = null;
            
            if (hasSameOperator(prim, pred) && fix.isGathering()) {
                // Gathering operator, just concatenate
                unify = product(append((Product) pred, ((Product) prim).tail()));

            } else if (isOpTree(pred) && isShallow(pred) && length((Product) pred) <= 2) {
                // Both preceding and primary are unprocessed
                // Hoist and reinsert
                
                // (append (init preceding, ((insert (last preceding) primary) . nil)))
                
                hoist = last((Product) pred);
                insert = insert(hoist, (Product) prim);
                
                unify = product(append(init((Product) pred), product(single((Pattern) insert))));
            } else {
                // Primary is processed or non-op expression
                // Simply insert
                insert = insert(pred, (Product) prim);
                unify = insert;
            }

            return rewrite(product(append(before, cons((Pattern) unify, after))));
        }

        private static Product insert(Pattern hoist, Product primary) {
            return product(cons(primary.head(), cons(hoist, primary.tail())));
        }

        /**
         * If the given value is list on the form (Op, _), return the fixity of the operator.
         * Otherwise return null.
         */
        private Fixity getFixity(Pattern p) {
            if (p instanceof Sequence) {
                return getFixity((Product) p);
            }
            return null;
        }

        private Fixity getFixity(Product p) {
            return fixities.lookup(Interpreter.evalOperator(p.head(), delimiter));
        }

        /**
         * Predicate matching sequences of length 2 or greater whose first 
         * element is an operator.
         */
        private static boolean isOpTree(Pattern p) {
            if (p instanceof Sequence) {
                Sequence<?> s = (Sequence<?>) p;
                
                if (length(s) < 2) return false;
                if (!isOperator(first(s))) return false;
                
                return true;
            }
            return false;
        }
        
        /**
         * Predicate matching any sequence s where all elements in s are not
         * headed by an operator.
         */
        private static boolean isShallow(Pattern p) {
            if (p instanceof Sequence) {
                Sequence<?> s = (Sequence<?>) p;
                return foldl(new StandardFunction(1){
                    public Object apply(Object a, Object b) throws InvocationError {
                        if (!(Boolean) a) return false;
                        if (b instanceof Sequence) {
                            return !isOperator(first((Sequence<?>) b));
                        }
                        return true;
                    }
                }, true, s.tail());
            }
            return false;
        }

        /**
         * Predicate matching operator tokens.
         */
        private static boolean isOperator(Object o) {
            if (o instanceof Pattern) {                
                return VitryTokenTypes.tokenType((Pattern) o) 
                    == Interpreter.TYPE_OP;
            } 
            return false;
        }

        /**
         * Returns whether two sequences have the same head operator.
         */
        private static boolean hasSameOperator(Object a, Object b) {
            if (a instanceof Sequence && b instanceof Sequence) {
                Object ah = ((Sequence<?>) a).head();
                Object bh = ((Sequence<?>) b).head();
                // TODO check it is op type
                return ah.toString().equals(bh.toString());
            }
            return false;
        }
        
        /**
         * Deep-walks a sequence of patterns and/or sequences and replaces
         * all elements (+,...) with (Apply,+,...).
         */
        private static Product rewriteAsApplication(Product seq) {
            
            if (!isOperator(first(seq))) {
                return seq;
            }
            
            Sequence<Pattern> map = seq.map(new StandardFunction(1) {
                public Object apply(Object s) throws InvocationError {
                    if (s instanceof Sequence) {
                        return rewriteAsApplication((Product) s);
                    } else {
                        return s;
                    }
                }
            });
            return product(cons(Apply, map));
        }
        
        private static final Symbol Apply = Symbol.intern("Apply");

    }
