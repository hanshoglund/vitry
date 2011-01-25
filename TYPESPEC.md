
## Vitry type system

Vitry was designed for representation and manipulation of complex data structures. Its type system unifies the generality of a dynamic language with the precision of a statically typed language. It adopts the functional programing ideom to simplify reasoning about structure and equality independently of execution.
                              

### Core language
  
The core language of Vitry is the lambda calculus. It has the usual *equality semantics*.

We also include primitive values, such as numbers, strings and symbols. These can be defined in terms of the lambda calculus using standard reasoning.


### Patterns

We proceed by extending the core language with patterns, which are first-class values with *matching semantics*. We take *x* : *y* to mean that *x* matches *y*.

- Equality is an equivalence relation on values
- Matching (or inclusion) is a partial order on values
- It follows that for all *x* and *y*, *x* = *y* → *x* : *y*

There are two forms of compound patterns, namely *construction patterns* and *inclusion patterns*. The former is used to construct compound values and is represented by the comma.
    
    (foo, bar)
    (1, 2, 3) 
    (foo, (1, 2), ())

Inclusion patterns are written using set notation `{...,...}`. We can also use the set primitives `|` and `&` for the union or intersection respectively. Applying set primitives on a non-set value *v* is equivalent to applying it on a singleton set containing *v*.

    numbers = {1, 2, 3}     
    bool    = true | false
    bool    = {true, false}
    edibleFruits = fruits & edible
    
Constructions patterns match isomorphically while inclusion patterns match on inclusion.

    a         : a | b
    {1, 2}    : {{1, 2}, {3, 4}}
    (1, 2)    : (1, 2)
    (true, 1) : (bool, num)
    
Pattern notation is bijective: it constructs on right side and destructs on the left side:

    (a, b) = (1, 2)
    
There is also a match operation, similar to Lisp's `cond` or Haskell's `case` expression:

    match (v)
        a    -> (a + 1)
        a, b -> (a + 1, b + 1)
        
#### Any, bottom and nil

The *nil* pattern, written as `(),` is a special construction pattern representing no value.

    () = ()
    () : ()

The *bottom* pattern, or empty set, is written as `{}`. The bottom type has no  members, but it matches itself because of the inclusion semantics. It has the common semantics of the empty set.

    {} = {}
    {} = {} & a
     a = {} | a
     
The *wildcard* pattern, written as `_`, matches any value. It is primarily used in match expressions.

    match (v)
        (true, a, _) -> a
        (false, _, b) -> b

               
### Types

For complex programs, we want to extend the pattern notations with formal types. Types are similar to patterns, but with two major benefits:

- They may be inferred and checked at compile time
- They may be recursive
- They may be polymorphic

We create a type from a pattern by writing a type declaration:

    type foo = bar | baz | (foo, _)                                           
    
To get a polymorphic type, we simply add type variables:

    type pair a = (a, a)
    
Essentialy, types are lambda abstractions ranging over types instead of values.

In contrast to languages like ML and Haskell, types declarations do not define structors. Instead we use the standard list and tuple structors for all types (see below). To distinguish between isomorphic types, we use type *specifications*.

    type foo = (num, num)
    type bar = (num, num)
    (1, 2) : foo
    (1, 10) : bar

The left-hand versions of type specifications are called *restrictions*.

    match (v)
        n : num   -> n + 1
        n : [num] -> (head n) + 1
        
Specifications and restrictions may be applied to lambda abstractions as well.

    
#### Lists

The list type is built-in for convenience. The list type is defined as:

    type [a] = (a, [a]) | nil

There is a special list structor that converts products to lists in *O(1)* time.

    l = [1, 2, 3]
    [a, b, c] = l

Unfortunately, we have to overload the `[]` form to mean the list type as well as the structor, to conveniently express certan lists and patterns. For example, in the expression `l : [num]` we want the right subexpression to mean the type list of numbers, while in the expression `[1, 2] ++ [1]` we want it to mean a list containing the number 1. 

This ambiguity is resolved by context: an expression on the form [*v*] is taken to be a type application only if it is the outermost expression in  a type specification or restriction, or a structor otherwise.

For other types, there is no such ambiguity, as they have no structors.
                                                                       
    
### Predicates

The standard types are strictly structural. Sometimes, however, we want to express non-structural invariants on values. For this purpose we introduce predicate notation.

    type nat = {num where n >= 0}
    
TODO
    
    
    
    
### Implementation

This specification is agnostic to implementation. Especially it does not specify when type checking errors should occur.

Basically:                                                           

- Patterns may be compile-time or runtime
- Types may be compile-time or runtime
- Predicates must be runtime, or we have an undecidable type system
    - We may approach this through staged compilation