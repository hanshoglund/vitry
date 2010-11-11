% Vitry manual
% Hans Höglund
% 2010




## Preface
Vitry is a functional programming language with an infix syntax and simple, expressive type system. Its is primarily built for representation and manipulation of musical structures of all kinds. Vitry may be used for composition, arranging, transcription or analysis.

Vitry includes a standard set of types and functions making up the so-called musical model. This includes information such as pitch, onset, duration, dynamics, tone color or location. However, the user may modify, extend or even replace the musical model to contain any kind of information. Data in the musical domain may be transcribed to standard notation using various backends. It may also be used to generate control data for sound synthesis.



## 1. First steps

Vitry targets the [Java Virtual Machine](http://en.wikipedia.org/wiki/Java_Virtual_Machine), and may be used with almost any operating system. A Java runtime environment is required. Vitry is a standalone programming language, so a shell and a text editor is required to use it. All other dependencies are included in the source distributions. 
                                                                
Precompiled distributions of Vitry may be downloaded from [here](http://github.com/hanshoglund/vitry/downloads). If an installer is not available for your operating system, you have to download and compile a source distribution.
                                                                                               
                                              
The build requirements are [Git](http://git-scm.com/) and [Apache Ant](http://ant.apache.org/). You may check if these are installed as follows:
<pre>
$ git
$ ant
</pre>                         
If not, download and install from the sites above or through your package management system.

As soon as the build requirements are in place, do:

<pre>
$ git clone git@github.com:hanshoglund/vitry.git
$ cd vitry
$ ant
$ ant install /usr/bin
</pre>
You may of course substitute any directory you want for `/usr/bin`.

The interpreter is typically the simplest way to interact with Vitry. To run it, simply type:
<pre>
$ vitry
</pre>

Vitry will print some setup information and enter a read-eval-print mode. In this mode, you may enter an expression followed by enter, and it will be evaluated and printed to you.



## 2. The language                                                                        

### Introduction

Being a functional language, Vitry is based on the notion of *functions, values and types*. Understanding these basic concepts is the key to understanding how to use the language[^1].

A functional program consists of *expressions*, each of which may produce a value. Consider for example the expression `2 + 3` which evaluates to `5`. Expressions may be nested using parentheses. Thus any program could be thought of as a single expression, usually containing several levels of nested subexpressions.
<pre>
1            => 1
2 + 3        => 5
(2 + 3) * 2  => 10
not true     => false
not (not true) => true
</pre>

Values are the pieces of data that represent something. From the point of a computer, values are numbers. However, programming languages let us reprent other kinds of data by encoding it as numbers behind the scenes. Thus they allow us to think of the computer as operating on characters, pitches, text strings or melodies, or even complex structures such as musical scores.

This power of representation also faces us with a problem: How do we keep track of what the values manipulated inside the computer acutally represents? Different kinds of data need different treatment, and mixups can cause great confusion on both the human and the computers part. The answer to this problem is *types*, a special kind of value representing classes[^2] of other values. Examples of types are `int`, representing integers and `string`, representing text.
                    
Technically, any program could be represented as a number of nested expressions. However, to build more complex program we need a way to represents procedures that could operate on different input values. Such a procedure is called a function. Functions expression contain variables, which are placeholders to which input data may be bound. Thus the value of a function always depends on its input. Examples of functions are `+` which performs addition, `sqrt`, which returns the square root of its input.


TODO types, type <-> function dictonomy
* : a -> bool


    
#### Overview

Value
:   an unmodifiable piece of data.
Type
:   a special value used to create and reason about other values.
Function
:   a value defining a procedure that binds its input to parameters.
Sequence
:   a special value representing sequences or lists of values.
Atom type
:   a unique single type.
Compound type
:   a type constructed from one or more other types.

### Basic types

#### Booleans
The boolean type is written as `bool`. Its values are written as `true` and `false`.

#### Numbers
Vitry supports bignum natural, integer and rational numbers, as well as floating-point real and complex numbers. The types of these are written as `nat`, `int`, `rat`, `float` and `complex` respectively.

Natural, integers and rational numbers are written as sequences of digits. Vitry will automatically convert integers to rationals and vice versa:

  `152 `, `42  `, `-8  `, `3/2 `

Floating point numbers may be written in several ways:

  `0.1`, `0.12e10`, `2e-5`, `0.5/2`
  
We create a complex number by adding the suffix `i` to the imaginary part:

  `2i`, `10 + 1i`, `22.4 + 32e4i`
  
Note that to get one imaginary unit you have to write `1i`, as `i` is not a number literal. Complex numbers in polar form may be entered using the `cis` function:

  `22 * cis 4`                                                        


#### Strings
Strings are sequences of Unicode characters. The string type is written as `string`. String values are written inside double-quotes:

  `"I hate music"`, `"But I love to sing"`


### Functions 
                     
#### Creating functions
#### Applying functions
#### Infix expressions
#### Higher-order functions

#### Values and variables
Values always represent something unique and non-changing, such as the number 2 or Beethoven's Fifth Symphony. However, the current outdoor temperature in Stockholm is not a value but a variable.                                                                  


Functions contain expressions which are not be evaluated immediately, but converted to a function value for later evaluation. The expression it defines is evaluated when the function is applied. Functions may take parameters which are placeholders for values to be supplied when
the function is evaluated. A function may also refer to values defined in the environment where it was created, using [lexical scope resolution](http://en.wikipedia.org/wiki/Scope_%28programming%29#Lexical_scoping).





### Creating types
#### Atoms    
#### Or types

TODO

Intersection types capture the notion of *inheritance* in object-oriented languages.

#### And types

TODO

Intersection types capture the notion of *composition* in object-oriented languages.

     




### Implicitness


### Sequences

Sequence values are special values containing other values in a given order.
                                                                 
TODO



### Modules

Types and functions form the basic units of abstraction in the Vitry language. Using Vitry for any task but the simplest will involve defining new types and/or functions.

#### Using import       

  

### Language grammar


## 3. Representing music

Vitry defines a musical model through a set of types and functions. All musical structures are compound types, defined in the language itself. This gives the user of the power to define custom data structures that operate on the same level of abstraction as those provided with the language. The core musical model is agnostic to musical style or writing system, instead it simply represent music as a set of events[^3]. 

In any general musical representation system, a balance has to be achieved between using reasonably familiar terminology and not limiting the model by making it biased toward the theory one particular style. One solution to this problem is to make a clear distinction between the concepts of *music* and *notation*, much like the separation of content and presentation commonly used in text processing. By using such a separation, music can be defined and manipulated as a kind of algebraic structure, apart from notational conventions. Another benefit of this strategy is that the same music could easily be translated to any kind representation.

The process of converting a musical value to a notation is called *transcription*, while the reverse operation is called *interpretation*. These operations will be explained more fully in the next chapter.

###A word of caution

The various levels of representation used in any kind musical programming may be confusing. It is important to understand that `music` type by no means correspond to real-world sound or digital audio. Thus, in the context of this programming language "transcribing music" means creating a representation of music notation from an abstract representation of sounding music, not from the sound of the music itself. Likewise, "performing" means creating a representation of music from a representation of some notation.

Also note that some other environments, use *music* where Vitry uses *notation*. The reason we do not use this naming is that the point of Vitry is to define a musical representation that is more general than common notation.[^4][^5]


TODO 

### Basic example

TODO

### Time                     
The type time is a synonym for the rational number. This allow us to encode conventional note lengths such as whole half notes, quarter notes, etc.

  `1, 1/2, 1/4 `\                            
  
Using sequence operators, we can make sequences run i different relative tempos, i.e:

  `[1 1/2 1/2]`  `[1 1/2 1/2] * 2`



### Pitch
### Other events
### Representing music
### Notations
### Part trees
### Instrumentations
### Continuous events
### Repetition and nonlinearity




## 4. Transcribing and performing

### The Sibelius transcriber
### The LilyPond transcriber
### The MusicXML transcriber
### The MIDI transcriber
### Creating transcribers
### Creating performers
    
## 5. Advanced usage

### Laziness
### Calling foreign languages
### Setting up the environment
### Replacing the syntax
### Real-time
### Networking




[^1]: For a thorough description of functional programming concepts, study a textbook such as [Structure and Interpretation of Computer Programs](http://mitpress.mit.edu/sicp/) by Abelson and Sussman or [On Lisp](http://www.paulgraham.com/onlisptext.html) by Paul Graham.

[^2]: In the general sense. Beware of overloaded OOP terminology.
[^3]: This is akin to Edgar Varèse's broad definition of music as "organized sound".
[^4]: [Haskore](http://www.haskell.org/haskore/) defines a *music* type that captures the essence of common practice notation. This type can be converted to a *performance*, which is similar to Vitry's *music* type. Haskore uses a notation of "literal performance equivalence" which in Vitry parlour would be described as different notations of the same music.
[^5]: Compare the "meta-level" described by Rick Taube in his *Notes from the meta-level* and the "algrebra of music" described by Paul Hudak in *The Haskore Computer Music System*.