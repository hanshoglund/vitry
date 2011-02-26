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

import static vitry.runtime.VitryRuntime.*;
import static vitry.runtime.struct.Seqs.*;
import vitry.runtime.error.*;
import vitry.runtime.parse.*;
import vitry.runtime.struct.*;

   
/**
 * Combined interface and factory for syntax-tree rewriting.
 *
 * @author Hans Höglund
 */
abstract public class Rewriting
{
    abstract public Product rewrite(Seq<Pattern> seq);
    
    public static final Rewriting operators(Env<Symbol, Fixity> fix, 
                                            Env<Symbol, Symbol> ctxt) 
    {
        return new OperatorRewrite(fix, ctxt);
    }
}  


/**
 * Rewrites opererator-form syntax trees into application-form.
 */        
class OperatorRewrite extends Rewriting
{        

    final Env<Symbol, Fixity> fixities;
    final Env<Symbol, Symbol> context;
    final Symbol delimiter;

    public OperatorRewrite(Env<Symbol, Fixity> fixities,
                           Env<Symbol, Symbol> context) 
    {
        this.fixities = fixities;
        this.context = context;
        this.delimiter = context.lookup(Interpreter.DELIMITER);
    }

    
    /**
     * Rewrite the given sequence of operator trees into a single
     * expression. The sequence may be headed by a non-optree expression.
     * 
     * An operator tree is an expression such as (+ 2 ...) where + is any
     * operator.
     * 
     * This algorithm proceeds by locating the highest-precedence 
     * operator tree and unify it with its predecessor. If several elements
     * compete for highest precedence, the leftmost or rightmost expression
     * is selected, based on the associativity of the operator in question.
     * 
     * The first element is never considered as it always represents a 
     * non-optree expression or a unary operator tree.
     * 
     * Returns an (Apply, +, ...) expression.
     */
    public Product rewrite(Seq<Pattern> seq) {
        
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
        
        SeqIterator<Pattern> it = iterate(seq);
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
                        && !fix.getAssociativity()))) 
            {
                prim = (Product) now;
                pred = last;
                after = product(it.following());
                max = fix.getPrecedence();
            }
        }
        if (prim == null || fix == null)
            throw new ParseError("Correputed operator tree " + seq);
        
        /*
         * Find preceding elements by backtracking
         */
        before = product(pred == null ? null : untilElement(seq, pred));
        
        /*
         * So we have
         *  (before ++ (pred) ++ (prim) ++ after) == seq
         * 
         * Now unify pred and prim, then reapply (before ++ (unify) ++ after).
         */
        Product unify;
        
        if (hasSameOperator(prim, pred) && fix.isGathering()) 
        {    
            /*
             * Simply concatenate
             */
            unify = product(append((Product) pred, ((Product) prim).tail()));

        } 
        else 
        if (isOpTree(pred) && isShallow(pred) && length((Product) pred) <= 2) 
        {
            /*
             * Both preceding and primary are unprocessed
             * Hoist and reinsert
             */
            Pattern hoist = last((Product) pred);                
            unify = product(append
                    (init((Product) pred), 
                     product(single
                         ((Pattern) insert(hoist, (Product) prim)))));
        }
        else
        {
            /*
             * Primary is processed or non-op expression
             * Simply insert
             */
            unify = insert(pred, (Product) prim);
        }

        return rewrite(product(append(before, cons((Pattern) unify, after))));
    }
    
    
    
    

    
    // Predicates
    

    /**
     * If the given value is list on the form (Op, _), return the fixity of the operator.
     * Otherwise return null.
     */
    private Fixity getFixity(Pattern p) {
        if (p instanceof Seq) {
            return getFixity((Product) p);
        }
        return null;
    }

    private Fixity getFixity(Product p) {
        return fixities.lookup(Interpreter.evalOperator(p.head(), delimiter));
    }
    
    
    /**
     * Matches sequences of length 2 or greater whose first 
     * element is an operator.
     */
    private static boolean isOpTree(Pattern p) {
        if (p instanceof Seq) {
            Seq<?> s = (Seq<?>) p;
            
            if (length(s) < 2) return false;
            if (!isOperator(first(s))) return false;
            
            return true;
        }
        return false;
    }
    
    /**
     * Matches any sequence s where all elements in s are not
     * headed by an operator.
     */
    private static boolean isShallow(Pattern p) {
        if (p instanceof Seq) {

            return foldl(new Unary() {
                public Object apply(Object a, Object b) throws InvocationError {
                    if (!(Boolean) a) {
                        return false;
                    }
                    if (b instanceof Seq) {
                        return !isOperator(first((Seq<?>) b));
                    }
                    return true;
                }
            }, true, (tail((Seq<?>) p)));
        }
        return false;
    }

    /**
     * Matches op tokens.
     */
    private static boolean isOperator(Object o) {
        if (o instanceof Pattern) {                
            return VitryTokenTypes.tokenType((Pattern) o) == VitryParser.Op;
        } 
        return false;
    }

    /**
     * Returns whether two sequences have the same head operator.
     */
    private static boolean hasSameOperator(Object xs, Object ys) {
        if (xs instanceof Seq && ys instanceof Seq) {
            Object x = ((Seq<?>) xs).head();
            Object y = ((Seq<?>) ys).head();
           
            // TODO verify op type
            return x.toString().equals(y.toString());
        }
        return false;
    }
    




    // Helper methods
    

    private static Product insert(Pattern hoist, Product primary) {
        return product(cons(primary.head(), cons(hoist, primary.tail())));
    }


    /**
     * Deep-walks a sequence of patterns and/or sequences and replaces
     * all elements (+,...) with (Apply,+,...).
     */
    private static Product rewriteAsApplication(Product seq) {
        
        if (!isOperator(first(seq))) {
            return seq;
        }
        Seq<Pattern> map = seq.map(new Unary() {
            public Object apply(Object s) throws InvocationError {
                if (s instanceof Seq) {
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
