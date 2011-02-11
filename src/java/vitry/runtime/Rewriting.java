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

import static vitry.runtime.struct.Sequences.*;

import vitry.runtime.misc.Utils;
import vitry.runtime.parse.VitryToken;
import vitry.runtime.parse.VitryTokenTypes;
import vitry.runtime.struct.Sequence;
import vitry.runtime.struct.SequenceIterator;
import vitry.runtime.struct.SingleSequence;

/**
 * Rewrites opererator-form syntax trees into application-form.
 * 
 * Input:
 *      A sequence of (Op, Expr)-tuples representing an unprocessed sequence
 *      of operatator-value pairs. The first expression may be a single value.
 *      (a (+ b) ...)
 *      ((+ b) ...)
 *      
 * Output:
 *      A single apply tree, possibly containing nested apply trees.
 *      (Apply, (Par, +), a ...)
 *      (Apply, (Par, +), b ...)
 */        
class OperatorRewrite
    {
        public OperatorRewrite(
                Environment<Symbol, Fixity> fixities,
                Environment<Symbol, Symbol> context) {
            this.fixities = fixities;
            this.context = context;
            this.delimiter = context.lookup(Interpreter.DELIMITER);
        }
        final Environment<Symbol, Fixity> fixities;
        final Environment<Symbol, Symbol> context;
        final Symbol delimiter;

        
        @SuppressWarnings("unchecked")
        public Product rewrite(Sequence<Pattern> seq) {
            String DEBUG = printable(seq).toString();
            Utils.nothing(null);
            
            if (length(seq) == 1) {
                // Expression is in normal form
                Object DEBUG2 = treeToApply((Sequence<Pattern>) seq.head());
                Utils.nothing(DEBUG2);
                return treeToApply((Sequence<Pattern>) seq.head());
            }
            
            /*
             * Find the leftmost or rightmost item of maximum precedence,
             * based on the associativity of that element.
             * 
             * Also store its direct predecessor element, all other preceding elements,
             * and all following elements.
             */
            
            Sequence<Pattern> primary = null;
            Pattern preceding = null;
            Sequence<Pattern> before = null;
            Sequence<Pattern> after = null;
            int     max = -1;
            
            SequenceIterator<Pattern> it = iterate(seq);
            for (Pattern p = null, pp = null; it.hasNext();) {
                pp = p;
                p = it.next();
                
                // Only consider non-processed operator trees
                // If the first value is non-processed, use the second
                boolean shallowOpTree = isShallowOpTree(p);
                if (pp == null || !shallowOpTree) continue;
                
                Fixity f = getFixity(p);
                if ( 
                     f != null && 
                     (
                       (f.getPrecedence() > max) 
                       || (f.getPrecedence() == max && !f.getAssociativity())
                     )
                   ) 
                {
                    primary = (Sequence<Pattern>) p;
                    preceding = pp;
                    before = (preceding == null ? null : untilElement(seq, preceding));
                    after = it.following();
                    max = f.getPrecedence();
                }
            }
            if (primary == null && preceding != null) throw new ParseError("Could not rewrite operators in " + seq);
//            assert ((primary != null));
            
            Pattern hoist;
            Product insert, unify = null;
            
            if (sameOp(primary, preceding) && getFixity(primary).isGathering()) {
                // Gathering operator, just concatenate
                unify = s2p(append(p2s(preceding), primary.tail()));

            } else if (isShallowOpTree(preceding) && length(p2s(preceding)) <= 2) {
                // Both preceding and primary are unprocessed
                // Hoist and reinsert
                // (append (init preceding, ((insert (last preceding) primary) . nil)))
                hoist = last((Product) preceding);
                insert = insert(hoist, primary);
                unify = s2p(append(s2p(init(p2s(preceding))),
                        s2p(single((Pattern) insert))));
            } else {
                // Primary is processed or non-op expression
                // Simply insert
                insert = insert(preceding, primary);
                unify = insert;
            }

            return rewrite(s2p(append(before, cons(s2p(unify), after))));
        }

        private Product insert(Pattern hoist, Sequence<Pattern> primary) {
            return s2p(cons(primary.head(), s2p(cons(hoist, primary.tail()))));
        }

        private boolean sameOp(Sequence<Pattern> primary, Pattern preceding) {
            if (preceding instanceof Sequence) {
                return ((Sequence) preceding).head().toString().equals(primary.head().toString());
            }
            return false;
        }

        /**
         * Deep-walks a sequence of patterns and/or sequences and replaces
         * all elements (+,...) with (Apply,+,...).
         *
         * The returned sequences are all Products.
         */
        private Product treeToApply(Sequence<Pattern> seq) {
            if (isOperator(first(seq)))
                return s2p(cons(APPLY_TOKEN, seq.<Pattern>map(RECURSIVE_APPLY)));
            else
                return s2p(seq);
        }                                       
        
        private Function RECURSIVE_APPLY = (new StandardFunction(1) {
                public Object apply(Object s) throws InvocationError {
                    if (s instanceof Sequence) {                                    
                        return treeToApply((Sequence<Pattern>) s);
                    } else {                                    
                        return s; 
                    }
                }
            });
        
        /**
         * Returns whether this is a sequence of length => 2, whose first element
         * is an operator and whose remaining elements are not sequences whose first
         * element is an operator.
         */
        private boolean isShallowOpTree(Pattern p) {
            if (p instanceof Sequence) {
                Sequence<Pattern> s = p2s(p);
                
                if (length(s) < 2) return false;
                if (!isOperator(first(s))) return false;
                
                return true;
//                return foldl(new StandardFunction(1){
//                    public Object apply(Object a, Object b) throws InvocationError {
//                        if (!(Boolean) a) return false;
//                        if (b instanceof Sequence) {
//                            return !isOperator(first((Sequence<Pattern>)b));
//                        }
//                        return true;
//                    }
//                }, true, s.tail());
            }
            return false;
        }

        private boolean isOperator(Pattern p) {
            return VitryTokenTypes.tokenType(p) == Interpreter.TYPE_OP;
        }
        
        /**
         * If the given value is list on the form (Op, _), return the fixity of the operator.
         * Otherwise return null.
         */
        private Fixity getFixity(Pattern p) {
            if (p instanceof Sequence) {
                return getFixity((Sequence<Pattern>) p);
            }
            return null;
        }

        private Fixity getFixity(Sequence<Pattern> p) {
            return fixities.lookup(Interpreter.evalOperator(p.head(), delimiter));
        }

        private boolean equalOps(Object primaryOp, Object hoistOp) {
            return hoistOp.toString().equals(primaryOp.toString());
        }

        private Product s2p (Sequence<Pattern> s) {
            return new SimpleProduct(s);
        }

        private Sequence<Pattern> p2s (Pattern s) {
            return (Sequence<Pattern>) s;
        }
        private static final VitryToken OPS_TOKEN = new VitryToken("Ops");
        private static final Symbol APPLY_TOKEN = Symbol.intern("Apply");

    }
