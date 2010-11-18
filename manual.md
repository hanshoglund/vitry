% Vitry manual
% © Hans Höglund 2010


# Introduction
Vitry is a functional programming language and an environment for representation and manipulation of music. The language has infix syntax and simple, expressive type system. The representation of music is abstract in the sense that it is not concerned with actual sound, but the formal structure of music. These representations can be transcribed to standard musical notation or used as control data for sound synthesis.

Vitry may be used for composition, arranging, transcription or analysis. It is built for easy integration with other environments, particularly the following:

- Lilypond
- Sibelius
- SuperCollider



# Getting started

Vitry targets the [Java Virtual Machine](http://en.wikipedia.org/wiki/Java_Virtual_Machine), and may be used with almost any operating system. The only dependency is the Java runtime environment. To check if this is installed, open a shell and type:

~~~~~~~~~~~~~~~~~~~~
$ java -version
~~~~~~~~~~~~~~~~~~~~

If not, download a suitable implemementation. There are [many alternatives](http://en.wikipedia.org/wiki/List_of_Java_virtual_machines).

## Compiled distributions
                                                                
Compiled distributions may be downloaded from the GitHub site:  [http://github.com/hanshoglund/vitry/downloads](http://github.com/hanshoglund/vitry/downloads). If a version for your operating system is not available, download and compile a source distribution.

## Source distributions                                                                                  
                                              
The build requirements are [Git](http://git-scm.com/) and [Apache Ant](http://ant.apache.org/). You may check if these are installed as follows:

~~~~~~~~~~~~~~~~~~~~
$ git
$ ant
~~~~~~~~~~~~~~~~~~~~

If not, download and install from the sites above or through your package management system.

As soon as the build requirements are in place, do:

~~~~~~~~~~~~~~~~~~~~
$ git clone git@github.com:hanshoglund/vitry.git
$ cd vitry
$ ant
$ sudo ant install
~~~~~~~~~~~~~~~~~~~~

Append any you want to the install command. The default is `/usr/bin`.
         
## Using the interpreter

The interpreter is typically the simplest way to interact with Vitry. To run it, simply type:

~~~~~~~~~~~~~~~~~~~~
$ vitry
~~~~~~~~~~~~~~~~~~~~

Vitry will print some setup information and enter a read-eval-print mode. In this mode, you may enter an expression followed by enter, and it will be evaluated and printed to you.



# The language                                                                        

Vitry is similiar to other functional programming languages. This chapter will give a brief overview of the concepts used in Vitry^[For good introduction to functional programming concepts, see *[Structure and Interpretation of Computer Programs](http://mitpress.mit.edu/sicp/)* by Abelson and Sussman].

## Values and expressions

A functional language is mainly concerened with manipulating values. Values are pieces of data that represent something. In Vitry, all values are unique and non-changing. This means that equal values always refer to the same underlying representations in memory. This is also true for compound structures, such as lists. 

Expressions are series of tokens each of which may produce a value. They may be nested using parentheses. Thus any program could be thought of as a single expression. Below are some examples of expressions along with their result^[The arrow-like sign not part of the language, but just a conventional way of wrinting what an expression evaluates to].

~~~~~~~~~~~~~~~~~~~~
1            => 1
2 + 3        => 5
(2 + 3) * 2  => 10
not true     => false
sin (pi/2)   => 1
~~~~~~~~~~~~~~~~~~~~

The most common forms of expressions are outlined below. Detailed yntax and behaviour will be described in detail later on in this manual.

### Literals

The simplest form of expression, used to create simple values like numbers and strings. Examples are:

~~~~~~~~~~~~~~~~~~~~
1
22.5
foo
"Philippe"
~~~~~~~~~~~~~~~~~~~~
 
  
### Infix expressions

Consists of other expressions, along with operators. A familiar form is the arithmetic expressions. Examples are:

~~~~~~~~~~~~~~~~~~~~
1 + 2
22 / 11
23 % 11
1, 2, 3, 4
true | false
~~~~~~~~~~~~~~~~~~~~




### Function calls

Consists of a callable expression followed by other expressions.

~~~~~~~~~~~~~~~~~~~~
print "hello world"
not true
sum 1 2 3 4 5
~~~~~~~~~~~~~~~~~~~~

The following form is also possible:

~~~~~~~~~~~~~~~~~~~~
print ("hello world")
not (true)
sum (1, 2, 3, 4, 5)
~~~~~~~~~~~~~~~~~~~~
                                              
### Do expressions

Used to carry out side-effects like input and output.

~~~~~~~~~~~~~~~~~~~~
do with buffer = []
  readLine 
  shuffle
  print
~~~~~~~~~~~~~~~~~~~~

### Other forms

~~~~~~~~~~~~~~~~~~~~
if true 1 else 2

fn x = x + 2

let a = fn x + 2, b = fn x - 2
  compare (curry a b) id nat
  
~~~~~~~~~~~~~~~~~~~~



## Types
Types are used to group and reason about values in a logical way. This help us think about the values we are manipulating and prevent us from doing mistakes. A type may be thought of as a common property of some values. Any value may be tested to see if it conforms to this property, if it does it is said to have the given type.

### Booleans
The boolean type is written as `bool`. Its values are written as `true` and `false`.

### Numbers
Vitry supports bignum natural, integer and rational numbers, as well as floating-point real and complex numbers. The types of these are written as `nat`, `int`, `rat`, `float` and `complex` respectively.

Natural, integers and rational numbers are written as sequences of digits. Vitry will automatically convert integers to rationals and vice versa:

  `152 `, `42  `, `-8  `, `3/2 `

Floating point numbers may be written in several ways:

  `0.1`, `0.12e10`, `2e-5`, `0.5/2`
  
We create a complex number by adding the suffix `i` to the imaginary part:

  `2i`, `10 + 1i`, `22.4 + 32e4i`
  
Note that to get one imaginary unit you have to write `1i`, as `i` is not a number literal. Complex numbers in polar form may be entered using the `cis` function:

  `22 * cis 4`                                                        


### Strings
Strings are sequences of Unicode characters. The string type is written as `string`. String values are written inside double-quotes:

  `"I hate music"`, `"But I love to sing"`
   

### Atoms    

TODO

### Or types

TODO

Intersection types capture the notion of *inheritance* in object-oriented languages.

### And types

TODO

Intersection types capture the notion of *composition* in object-oriented languages.
    
    

## Bindings and scopes

TODO


## Functions       

TODO



## Loops and recursion

TODO


## Sequences

TODO


## Predicates and matching

TODO


## Side effects


TODO


## Modules


TODO


## Implicitness


TODO







# Representing music

Vitry defines a musical model through a set of types and functions. All musical structures are defined in the language itself. This gives the user of the power to define custom data structures that operate on the same level of abstraction as those provided with the language. The core musical model is agnostic to musical style or writing system, instead it simply represent music as a set of events. 

clear distinction between the concepts of *music* and *notation*, much like the separation of content and presentation commonly used in text processing. By using such a separation, music can be defined and manipulated as a kind of algebraic structure, apart from notational conventions. Another benefit of this strategy is that the same music could easily be translated to any kind representation.

The process of converting a musical value to a notation is called *transcription*, while the reverse operation is called *interpretation*. These operations will be explained more fully in the next chapter.

## Music and notations
## Time
## Event
## Pitch
## Instrumentation
## Sudden change
## Continous change
## Spacialization
## Nonlinear time
## Indeterminate structures



# Transcribing and performing

## The Sibelius transcriber
## The LilyPond transcriber
## The MusicXML transcriber
## The MIDI transcriber
## Creating transcribers
## Creating performers
    
# Miscellaneous topics

## Calling foreign languages
## Setting up the environment
## Replacing the syntax
## Real-time
## Networking

# Reference

## Syntax


Operators are tokens constructed from the following characters:         

~~~~~~~~~~~~~~~~~~~~
! # $ % & \ * + , - . / ; < = > ? @ \ ^ _ ` | ~ '
~~~~~~~~~~~~~~~~~~~~

## Dictionary

Value
:   a
Token
:   a
Expression
:   a
Evaluation
:   a
Type
:   a
Function
:   a
Predicate
:   a
Sequence
:   a


