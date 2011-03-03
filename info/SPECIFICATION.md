
 


### Table of Contents

- Introduction
    - Definitions

- Parsing
    - Stages
    - Pragmas
    - Lexing
    - Token operations
        - Indentation
        - Comments and meta-expressions
    - Syntax tree operations
        - Operators
        - Parentheses  
        - Overloading
        - Application and fixity
        - Quoting
    - Left and right

- Bindings and scope
    - Local definitions
    - Top-level definitions
        - Types
        - Implicitness
        - Fixity
- Atoms
    - Functions
    - Symbols
    - Numbers
    - Strings
    
- Patterns
    - Construction patterns
        - Products
        - Lists
    - Inclusion patterns
        - Sets
        - Unions
        - Intersections
        - Comprehensions
    - Matching
    - Enumeration

- Types   
    - Specifications and restrictions
    - Polymorphism
    - Implicit conversion

- Literate language

- Module language    
    - Imports and resolution
    - Function extensions
    - Data extensions

- Imperative language
    - Do-expressions

- Evaluation
    - Loading stage
    - Typing stage
    - Execution stage


## Introduction

This paper gives a concise overview of the Vitry programming language.

Vitry is a functional, structurally typed programming language. It was concieved to be used for representation and manipulation of music, but can also be used for general-purpose programming. Vitry allows most parts of its syntax and semantics to be overloaded or extended by the user. It combines static type checking with dynamic techinques such as predicate matching and first class patterns.


### Definitions

#### Values

- A *value* is a fixed, unmodifiable datum. 

- A *function* is a value that associates each value in a set with some other, or the same value.

- A *sequence* is an ordered collection of values.

#### Patterns

- A *pattern* is a value with matching semantics. By *matching* or *inclusion* we mean set inclusion. Thus, pattern can be seen as values representing sets or values.

- An a *atom* is a non-destructible value with trivial matching semantics.

- A *compound* is a destructible value with non-trivial matching semantics.

- A *type* is a pattern that can be determined by static analysis of a program.

#### Other

- *Tagging* is the process of obtaining a value from two other values, known as the *form* and the *tag* respectively.

- An *error* is a special value representing a problem encountered in a program. Errors may or may not cause the execution of a program to finish abnormally.

- A *character* is a Unicode character, or a Vitry value representing a Unicode character.



### Data types and values

Programming languages commonly defines a set of simple data types that model the underlying capabilities of the machine, such as integers (arithmetic), booleans (logic) or pointers (memory). These *primitives* are usually finite, and quite distinct from *composite types* they are used to construct.

To a Vitry program, the underlying machine types are just atoms, on which certain operations are very efficient (i.e. addition on integers). However, there are no assumptions on which values this should be: semantically values like integers and booleans are no different from other values. Similarly, nothing prevents implementations from representing compound types are primitive machine types if this provides more efficient operations (i.e. tuples of booleans may be represented as machine words).



## Parsing and evaluation

Using Vitry consists of writing text, known as source code. Such text may be stored in files or entered directly on the command-line. Implementations of the language will process this text in two stages, known as *parsing* and *evaluation*.

Parsing is the process of transforming a sequence of characters into a value according to *lexical rules*. The resulting value may be an atom or a compound. Such a value is also known as an expression tree, as it typically consist of a tree-like structure.

Evaluation is the process of transforming an expression tree into a value according to certain *syntactical rules*. Evaluation is a surjective function, meaning that for any value there is at least one expression tree that, when evaluated, yields this value.

### Lexing

        - Stages
        - Pragmas
        - Lexing
        - Token operations
            - Indentation
            - Comments and meta-expressions
        - Syntax tree operations
            - Operators
            - Parentheses  
            - Overloading
            - Application and fixity
            - Quoting
        - Left and right

## Bindings

Binding is the process of associating values with identifiers. For identifiers we use symbols.

An environment is tuple consisting of a set of bindings and a parent scope. There is an implicit top-level scope which has no bindings and no parent.

        - Local definitions
        - Top-level definitions
            - Types
            - Implicitness
            - Fixity
    - Atoms
        - Functions
        - Symbols
        - Numbers
        - Strings
    
    - Patterns
        - Construction patterns
            - Products
            - Lists
        - Inclusion patterns
            - Sets
            - Unions
            - Intersections
            - Comprehensions
        - Matching
        - Enumeration

    - Types   
        - Specifications and restrictions
        - Polymorphism
        - Implicit conversion

    - Literate language

    - Module language    
        - Imports and resolution
        - Function extensions
        - Data extensions

    - Imperative language
        - Do-expressions

    - Evaluation
        - Loading stage
        - Typing stage
        - Execution stage 



