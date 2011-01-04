package vitry.primitive;

/**
 * The core runtime environment.
 * 
 * @author hans
 */
public class Vitry
    {
        public static final Function eq = new Function(2, null)
            {
                public Object apply(Object a, Object b) {
                    if (a instanceof Value) 
                        return ((Value) a).eqFor((Pattern) b);
                    else
                        return PrimitiveValue.wrap(a).eqFor(PrimitiveValue.wrap(b));
                }
            };

        public static final Function match = new Function(2, null)
            {
                public Object apply(Object a, Object b) {
                    return ((Value) a).matchFor((Pattern) b);
                }
            };


        // ; Special forms
        // () [] {} = : `
        // fn if let do match delay force loop recur
        //
        // ; Basic types
        // type 
        //   bool
        //   nat     = [bool]
        //   int     = bool, nat
        //   rat     = int, int
        //   float   = [bool]
        //   double  = [bool]
        //   complex = double, double
        //   char    = nat
        //   string  = [char]
        //
        // implicit
        //   bool  -> nat
        //   nat   -> int
        //   int   -> rat
        //   int   -> float
        //   float -> complex 
        //   
        //   [a]           <-> int -> a
        //   [(a, b)]      ->  a -> b
        //   {a}           <-> a -> bool
        //   a, b ...      <-> [a | b ...]
        //   
        //   ; Set vs type ??                   
        //   [a]           -> {a}
        //   {a}           -> [a]
        //   {a}, a -> int -> [a]
        //   [{a}], a -> int -> [a]
        //   
        // ; Basic logic
        // (==)
        // (/=)
        // not
        // true
        // false
        // 
        // 
        // ; Functions
        // arity     : (->) -> nat
        public static final Function arity = new Function(1, null)
            {
                public Object apply(Object a) {
                    return ((Function) a).arity;
                }
            };

        //
        // id        : (a -> a)
        public static final Function id = new Function(1, null)
            {
                public Object apply(Object a) {
                    return a;
                }
            };


        // const     : a -> (? -> a)
        public static final Function const_ = new Function(1, null)
            {
                public Object apply(final Object a) {
                    return new Function(1, null)
                        {
                            public Object apply(Object b) {
                                return a;
                            }

                            public int arity() {
                                return 1;
                            }

                            public FunctionType type() {
                                return null;
                            }
                        };
                }
            };

        // compose   : (b -> c), (a -> b) -> (a -> c)
        // sequence  : (a -> b), (b -> c) -> (a -> c)
        // flip      : (a, b -> c) -> (b, a -> c)
        // 
        // apply     : (a -> b), a -> b
        // curry     : a, b -> c -> (a -> b -> c)
        // uncurry   : (a -> b -> c) -> a, b -> c
        // power     : (a -> b), int -> (a -> b)
        // 
        // implicit                              
        //   curry
        //   uncurry
        //   const
        //   
        //   
        // ; Arithmetic
        // (+)
        public static final Function add = new Function(2, null)
            {
                public Object apply(Object a, Object b) {
                    return ((Number) a).intValue() + ((Number) b).intValue();
                }
            };

        // (-)
        public static final Function sub = new Function(2, null)
            {
                public Object apply(Object a, Object b) {
                    return ((Number) a).intValue() - ((Number) b).intValue();
                }
            };

        // (*)
        public static final Function mul = new Function(2, null)
            {
                public Object apply(Object a, Object b) {
                    return ((Number) a).intValue() * ((Number) b).intValue();
                }
            };


        // (/)
        public static final Function div = new Function(2, null)
            {
                public Object apply(Object a, Object b) {
                    return ((Number) a).intValue() / ((Number) b).intValue();
                }
            };


        // (%)
        public static final Function mod = new Function(2, null)
            {
                public Object apply(Object a, Object b) {
                    return ((Number) a).intValue() % ((Number) b).intValue();
                }
            };

        // (%%)
        // (^)
        // add
        // sub
        // mul
        // div
        // mod
        // modp
        // exp
        // log
        // ln
        // sin
        // cos
        // asin
        // acos
        // round
        // ceil
        // floor
        // repr
        // succ
        // sum
        // prod
        // gcd
        // lcm
        // 
        // odd
        // even
        // prime
        //           
        // ; Standard notion of bounds and enumerable seqs (Haskell-like?)
        // 
        // ; Well-known sequences (lazy seqs)
        // fibbonaci : [nat]
        // harmonic  : [nat]
        // prime     : [nat]
        //
        // 
        //
        // ; Sets
        // union         : {a} -> {a}
        // public static final Function union = new Function(){
        //     public Object apply(Object a, Object b) {
        //         return Util.union(a, b);
        //     }
        //     public int arity() {
        //         return 2;
        //     }
        //     public FunctionType type() {
        //         throw new UnsupportedOperationException();
        //     }
        // };

        // intersect     : {a} -> {a}
        // public static final Function intersection = new Function(){
        //     public Object apply(Object a, Object b) {
        //         return Util.intersection(a, b);
        //     }
        //     public int arity() {
        //         return 2;
        //     }
        //     public FunctionType type() {
        //         throw new UnsupportedOperationException();
        //     }
        // };

        // symdif        : {a} -> {a}
        // powerset      : {a} -> {a}
        // subset        : {a} -> {a}
        // propsubset    : {a} -> {a}
        // superset      : {a} -> {a}
        // propsuperset  : {a} -> {a}
        // 
        // ; Randomness                 
        // rand : [int]
        // 
        // ; TODO overloads with ability to select seed and distribution
        // ; pink, brown, low, high, middle, gauss, exp, beta, gamma, cauchy, poisson                                             
        //
        // ; Each take a random sequence or use default (rand with no args, meaning 
        // ; random seed).
        // pick        : [a]         -> a
        // pick        : [a], [int]  -> a
        // pick        : [int], [a]  -> a
        // shuffle     : [a]         -> [a]
        // shuffle     : [a], [int]  -> [a]
        // shuffle     : [int], [a]  -> [a]
        //
        // 
        //   
        // ; Sequences
        // 
        // fist        : [a] -> a
        // rest        : [a] -> [a]
        // last        : [a] -> a
        // init        : [a] -> [a]
        // conj        : a, [a] -> a
        // 
        // length      : [a] -> nat
        // rank        : [a] -> nat
        // empty       : [a] -> bool
        // single      : [a] -> bool
        // 
        // nth         : [a], int    -> a
        // apply       : [a], [a] -> b -> b
        // fold        : [a], (b, a -> b), b -> b
        // foldr       : [a], (a, b -> b), b -> b
        // 
        // ; ... arithmetic ops and fns ...
        //
        //                                 
        // ; How about partial application ([a] should not be first arg). Use flip?
        // concat      : [a], [a] -> [a]
        // append      : [a], a -> [a]
        // prepend     : [a], a -> [a]
        // remove      : [a], int -> [a]
        // insert      : [a], int, a -> [a]
        // subst       : [a], int, a -> [a]
        // subseq      : [a], int, int -> [a]
        // drop        : [a], int    -> [a]
        // take        : [a], int    -> [a]
        // map         : [a], a -> b -> [b]
        // remove      : [a], (a -> bool) -> [a]
        // retain      : [a], (a -> bool) -> [a]
        // 
        // reverse     : [a] -> [a]
        // sort        : [a] -> [a]
        // search      : [a], a -> int
        // shuffle     : [a] -> [a]
        // permute     : [a] -> [[a]]
        // permute     : [a], int -> [[a]]
        // partition   : [a], int -> [[a]]
        // 
        // zip
        // zipn ; ??
        //
        // some        : [a], (a -> bool) -> ([a] -> bool) 
        // every       : [a], (a -> bool) -> ([a] -> bool)
        // 
        // 
        // ; "Pdef"-style lazy sequences
        // interleave  : [a] -> [a]                          
        // cycle
        // palindrome
        // repeat
        // rotation
        //
        // 
        // 
        // 
        // 
        // 
        // ; Environment
        // require     : string -> module
        // load        : string ->
        // print       : string ->
        // error       : string ->
        // now         : int
        // version     : [nat]
        // versionStr  : string                         
        // 
        // show        : ? ->
        // read        : -> ?
        // help        : ->
        // quit        : ->
        // 
        //odule seq.stack
        // push
        // pop
        //                             

    }
