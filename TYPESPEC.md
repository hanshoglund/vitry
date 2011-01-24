

Vitry was designed for representation and manipulation of complex data structures. Its type system unifies the generality of a dynamic language with the precision of a statically typed language. It adopts the functional programing ideom to simplify reasoning about structure and equality independently of execution.
  
The core language of Vitry is the lambda calculus. The lamdba operation is called `fn`:

    i = fn (x) x
    k = fn (x) (fn (y) x)
    s = fn (x y z) (x z (y z))

The core language is decorated with patterns, which are first-class values with *matching semantics*. Any value is a pattern matching itself. We write equality using `=` and matching using `:`

    foo = foo
    bar : bar
    foo : bar -- error

There two forms of compound patterns are *construction patterns* and *inclusion patterns*. The former is used to construct compound values and is represented by the comma:
    
    (foo, bar)
    (1, 2, 3) 
    (foo, (1, 2), ())

The nil value `()` is a special construction representing no value.

Inclusion patterns are written using set notation. We can also use the set primitives `|` and `&` for the union or intersection respectively.

    numbers = {1, 2, 3}
    bool = true | false
    bananas = fruits & yellow
    
Inclusion patterns match isomorphically while inclusion patterns match on inclusion.

    a : a | b
    (1, 2) : (1, 2)
    (true, 1) : (bool, num)
    
Pattern notation is bijective: it constructs on right side and destructs on the left side:

    (a, b) = (1, 2)
    
There is also a match operation, similar to Lisp's `cond` or Haskell's `case` expression:

    match (val)
        a    -> (a + 1)
        a, b -> (a + 1, b + 1)
        error


For complex programs, we want to extend the pattern notations with formal types. Types are similar to patterns, but with two major benefits:

- They may be inferred and checked at compile time
- They may be polymorphic

We create a type from a pattern by writing a type declaration:

    type foo = bar | baz | (foo, _)                                           
    
To get a polymorphic type, add a type variable:

    type pair a = (a, a)
    
Essentialy, types are lambda abstractions ranging over types instead of values. Non-polymorphic types are unary abstractions.

There are two built-in types, namely:

    type a -> b = ...
    type [a]    = (a, [a]) | nil
    

