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
                
                if (!isShallow(p)) continue;
                Fixity f = getFixity(p);
                if ( 
                     f != null && 
                     (
                       (f.getPrecedence() > max) 
                       || (f.getPrecedence() == max && !f.isLeft())
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
//            if (prim == null) throw new ParseError("Could not rewrite operators in " + (Product) seq);
            assert ((primary != null));
            
            Pattern hoist;
            Product insert, unify;
            
            if ((preceding != null) && (preceding instanceof Sequence) && isShallow(preceding)) {
                Class DEBUG3 = preceding.getClass();
                hoist  = last((Product) preceding);
                insert = s2p(cons(primary.head(), s2p(cons(hoist, primary.tail()))));
                unify  = s2p(append(s2p(init((Sequence<Pattern>) preceding)), s2p(new SingleSequence(insert))));
                
            } else if (preceding != null){
                hoist  = preceding;
                insert = s2p(cons(primary.head(), s2p(cons(hoist, primary.tail()))));
                unify  = insert;

            } else {
                unify = (Product) primary;
            }
            
            return rewrite(s2p(append(before, cons(s2p(unify), after))));
        }
        
        private Product s2p (Sequence<Pattern> s) {
            return new SimpleProduct(s);
        }
        
        
        /**
         * Deep-walks a sequence of patterns and/or sequences and replaces
         * all elements (...) with (Apply, ...).
         *
         * The returned sequences are all Products.
         */
        private Product treeToApply(Sequence<Pattern> seq) {
            return (new SimpleProduct(cons(APPLY_TOKEN, seq.<Pattern>map(RECURSIVE_APPLY))));
        }                                       
        
        private Function RECURSIVE_APPLY = (new StandardFunction(1) {
                public Object apply(Object s) throws InvocationError {
                    if (s instanceof Sequence) {                                    
                        return treeToApply(Utils.<Sequence<Pattern>>unsafe(s));
                    } else {                                    
                        return s; 
                    }
                }
            });
        
        private boolean isShallow(Pattern p) {
            if (p instanceof Sequence) {
//                int DEBUG = length((Sequence<?>) p);
                return length((Sequence<?>) p) <= 2;
            }
            else
                return true;
        }
        
        /**
         * If the given value is list on the form (Op, _), return the fixity of the operator.
         * Otherwise return null.
         */
        private Fixity getFixity(Pattern p) {
            if (p instanceof Sequence) {
                Pattern op = Utils.<Sequence<Pattern>>unsafe(p).head();
                return fixities.lookup(Interpreter.evalOperator(op, delimiter));
            }
            return null;
        }

        private static final VitryToken OPS_TOKEN = new VitryToken("Ops");
        private static final Symbol APPLY_TOKEN = Symbol.intern("Apply");

    }
