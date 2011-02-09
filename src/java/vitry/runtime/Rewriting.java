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
import static vitry.runtime.Build.*;

import vitry.runtime.misc.Utils;
import vitry.runtime.parse.VitryToken;
import vitry.runtime.struct.Sequence;
import vitry.runtime.struct.SequenceIterator;

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

        
        public Product rewrite(Sequence<Pattern> seq) {
            
            if (length(seq) == 1) {
                // Expression is in normal form
                Object debug = treeToApply(seq);
                Utils.nothing(debug);
                return treeToApply(seq);
            }
            
            Pattern prim = null;
            Pattern pred = null;
            Sequence<Pattern> tail = null;
            int     max = -1;
            
            SequenceIterator<Pattern> it = seq.sequenceIterator();
            for (Pattern p = null, pp = null; it.hasNext();) {
                pp = p;
                p = it.next();
                Fixity f = getFixity(p);
                if ( 
                     f != null && 
                     (
                       (f.getPrecedence() > max) 
                       || (f.getPrecedence() == max && !f.isLeft())
                     )
                   ) 
                {
                    prim = p;
                    pred = pp;
                    tail = it.currentSequence();
                    max = f.getPrecedence();
                }
            }
            if (prim == null) throw new ParseError("No fixity rules found");
            
            // TODO
            // Hoist from prim to pred
            // Reinsert in original seq, how?
            
            return null;
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
