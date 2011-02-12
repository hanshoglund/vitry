///*
// * Vitry, copyright (C) Hans Hoglund 2011
// * 
// * This program is free software: you can redistribute it and/or modify
// * it under the terms of the GNU General Public License as published by
// * the Free Software Foundation, either version 3 of the License, or
// * at your option) any later version.
// * 
// * This program is distributed in the hope that it will be useful,
// * but WITHOUT ANY WARRANTY; without even the implied warranty of
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// * GNU General Public License for more details.
// * 
// * You should have received a copy of the GNU General Public License
// * along with this program.  If not, see <http://www.gnu.org/licenses/>.
// *
// * See COPYING.txt for details.
// */
//package vitry.runtime;
//
//import static vitry.runtime.struct.Sequences.*;
//
//import vitry.runtime.error.*;
//import vitry.runtime.parse.*;
//import vitry.runtime.struct.*;
//import vitry.runtime.util.*;
//
///**
// * Rewrites opererator-form syntax trees into application-form.
// * 
// * Input:
// *      A sequence of (Op, Expr)-tuples representing an unprocessed sequence
// *      of operatator-value pairs. The first expression may be a single value.
// *      (a (+ b) ...)
// *      ((+ b) ...)
// *      
// * Output:
// *      A single apply tree, possibly containing nested apply trees.
// *      (Apply, (Par, +), a ...)
// *      (Apply, (Par, +), b ...)
// */        
//class OperatorRewrite
//    {
//        public OperatorRewrite(
//                Environment<Symbol, Fixity> fixities,
//                Environment<Symbol, Symbol> context) {
//            this.fixities = fixities;
//            this.context = context;
//            this.delimiter = context.lookup(Interpreter.DELIMITER);
//        }
//        final Environment<Symbol, Fixity> fixities;
//        final Environment<Symbol, Symbol> context;
//        final Symbol delimiter;
//
//        
//        
//        
//        @SuppressWarnings("unchecked")
//        public Product rewrite(Product seq) {
////            String DEBUG = printable(seq).toString();
//            Utils.nothing(null);
//            
//            if (length(seq) == 1) {
//                // Expression is in normal form
////                Object DEBUG2 = treeToApply((Product) seq.head());
////                Utils.nothing(DEBUG2);
//                return (Product) treeToApply((Sequence<?>) seq.head());
//            }
//            
//            /*
//             * Find the leftmost or rightmost item of maximum precedence,
//             * based on the associativity of that element.
//             * 
//             * Also store its direct predecessor element, all other preceding elements,
//             * and all following elements.
//             */
//            
//            Product primary = null;
//            Pattern preceding = null;
//            Product before = null;
//            Product after = null;
//            int     max = -1;
//            
//            SequenceIterator<Pattern> it = iterate(seq);
//            for (Pattern p = null, pp = null; it.hasNext();) {
//                pp = p;
//                p = it.next();
//                
//                // Only consider non-processed operator trees
//                // If the first value is non-processed, use the second
//                boolean shallowOpTree = isOpTree(p);
//                if (pp == null || !shallowOpTree) continue;
//                
//                Fixity f = getFixity(p);
//                if ( 
//                     f != null && 
//                     (
//                       (f.getPrecedence() > max) 
//                       || (f.getPrecedence() == max && !f.getAssociativity())
//                     )
//                   ) 
//                {
//                    primary = p;
//                    preceding = pp;
//                    before = (preceding == null ? null : untilElement(seq, preceding));
//                    after = it.following();
//                    max = f.getPrecedence();
//                }
//            }
//            if (primary == null && preceding != null) throw new ParseError("Could not rewrite operators in " + seq);
////            assert ((primary != null));
//            
//            Pattern hoist;
//            Product insert, unify = null;
//            
//            if (sameOp(primary, preceding) && getFixity(primary).isGathering()) {
//                // Gathering operator, just concatenate
//                unify = append((Product) preceding, primary.tail());
//
//            } else if (isOpTree(preceding) && isShallow(preceding) && length((Product) preceding) <= 2) {
//                // Both preceding and primary are unprocessed
//                // Hoist and reinsert
//                // (append (init preceding, ((insert (last preceding) primary) . nil)))
//                hoist = last((Product) preceding);
//                insert = insert(hoist, primary);
//                unify = append(init((Product) preceding), single((Pattern) insert));
//            } else {
//                // Primary is processed or non-op expression
//                // Simply insert
//                insert = insert(preceding, primary);
//                unify = insert;
//            }
//
//            return rewrite(append(before, cons((Pattern) unify, after)));
//        }
//
//        private static Product insert(Pattern hoist, Product primary) {
//            return cons(primary.head(), cons(hoist, primary.tail()));
//        }
//
//        /**
//         * If the given value is list on the form (Op, _), return the fixity of the operator.
//         * Otherwise return null.
//         */
//        private Fixity getFixity(Pattern p) {
//            if (p instanceof Sequence) {
//                return getFixity((Product) p);
//            }
//            return null;
//        }
//
//        private Fixity getFixity(Product p) {
//            return fixities.lookup(Interpreter.evalOperator(p.head(), delimiter));
//        }
//
//        /**
//         * Deep-walks a sequence of patterns and/or sequences and replaces
//         * all elements (+,...) with (Apply,+,...).
//         *
//         * The returned sequences are all Products.
//         */
//        private static Sequence<?> treeToApply(Sequence<?> seq) {
//            if (isOperator(first(seq)))
//                return cons(APPLY_TOKEN, seq.<Pattern>map(RECURSIVE_APPLY));
//            else
//                return seq;
//        }                                       
//        
//        private static Function RECURSIVE_APPLY = (new StandardFunction(1) {
//                public Object apply(Object s) throws InvocationError {
//                    if (s instanceof Sequence) {                                    
//                        return treeToApply((Sequence<?>) s);
//                    } else {                                    
//                        return s; 
//                    }
//                }
//            });
//        
//        /**
//         * Returns whether this is a sequence of length => 2, whose first element
//         * is an operator and whose remaining elements are not sequences whose first
//         * element is an operator.
//         */
//        private static boolean isOpTree(Pattern p) {
//            if (p instanceof Sequence) {
//                Sequence<?> s = (Sequence<?>) p;
//                
//                if (length(s) < 2) return false;
//                if (!isOperator(first(s))) return false;
//                
//                return true;
//            }
//            return false;
//        }
//        
//        private static boolean isShallow(Pattern p) {
//            if (p instanceof Sequence) {
//                Sequence<?> s = (Sequence<?>) p;
//                return foldl(new StandardFunction(1){
//                    public Object apply(Object a, Object b) throws InvocationError {
//                        if (!(Boolean) a) return false;
//                        if (b instanceof Sequence) {
//                            return !isOperator(first((Sequence<?>) b));
//                        }
//                        return true;
//                    }
//                }, true, s.tail());
//            }
//            return false;
//        }
//
//        private static boolean isOperator(Object o) {
//            if (o instanceof Pattern)
//                return VitryTokenTypes.tokenType((Pattern) o) 
//                    == Interpreter.TYPE_OP;
//            return false;
//        }
//
//        private static boolean sameOp(Sequence<?> primary, Pattern preceding) {
//            if (preceding instanceof Sequence) {
//                return ((Sequence<?>) preceding).head().toString().equals(primary.head().toString());
//            }
//            return false;
//        }
//
////        private static Pattern s2p (Product s) {
////            return new SimpleProduct(s);
////        }
////
////        private static Product p2s (Pattern s) {
////            return (Product) s;
////        }
//        
//        private static final VitryToken OPS_TOKEN = new VitryToken("Ops");
//        private static final Symbol APPLY_TOKEN = Symbol.intern("Apply");
//
//    }
