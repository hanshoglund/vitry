

Vitry manual
======================================================================
Copyright © Hans Höglund 2010

\


## Introduction
Vitry is a programming language with an inline syntax and simple, expressive type system. It is designed to allow easy representation of musical structures of all kinds. Vitry may be used for algorithmic composition or analysis. 

Vitry includes a powerful model of standard music notation. It performs no graphical rendering of music on its own, but it built for integration with score-editing software such as [Sibelius](http://www.sibelius.com/) and [LilyPond](http://lilypond.org/). It may also be used to generate data for audio-synthesis software.



\


## First steps

### Install

Vitry targets the [Java Virtual Machine](http://en.wikipedia.org/wiki/Java_Virtual_Machine), and may be used with many different operating systems. On Mac OS X systems, Java is preinstalled by default. For other systems, refer to [this page](www.java.com) or the documentation specific to your systems for installation options. 




You may download a pre-compiled version of Vitry from [http://github.com/hanshoglund/vitry/downloads](http://github.com/hanshoglund/vitry/downloads).

To compile the latest version yourself, [Git](http://git-scm.com/) and [Apache ANT](http://ant.apache.org/) is required. In this case, use the following commands to fetch the source code and build: 
<pre>
$ git clone git@github.com:hanshoglund/vitry.git
$ cd vitry
$ ant
</pre>
              
### The interpreter
The interpreter is typically the simplest way to interact with Vitry. To run it, move into the Vitry directory and launch vitry through the `vitry` script.

<pre>
$ cd vitry
$ ./vitry
</pre>



TODO starting a session
TODO the REPL mode
TODO interpreter command

### Setting up the environment

TODO the `~/.vitry` file
TODO variables

### Sibelius installation



\


## Language

TODO intro text

TODO more definitions

*Values* are pieces of data that we can retrieve and manipulate.  *Expressions*  are a series of values or other expressions that may be *evaluated*. The evaluation will produce a value, provided it succeeds. *Types* are special values that help us create and reason about other values. Types are created from type expressions.

### Basic types

#### Booleans
The boolean type is written as `bool`. Its values are written as `true` and `false`.

#### Numbers
Vitry supports bignum natural, integer and rational numbers, as well as floating-point real and complex numbers. The types of these are writen as `nat`, `int`, `rat`, `float` and `complex` respectively.

Natural, integers and rational numbers are written as sequences of digits. Vitry will automatically convert integers to rationals and vice versa:

  `152 `\
  `42  `\
  `-8  `\
  `3/2 `

Floating point numbers may be writen in several ways:

  `0.1     `\
  `0.12e10 `\
  `2e-5    `\
  `0.5/2   `
  
We create a complex number by adding the suffix `i` to the imaginary part:

  `2i          `\
  `10 + i      `\
  `22.4 + 32e4i`


#### Strings
Strings are sequences of Unicode characters. The string type is written as `string`. String values are written inside double-quotes:

  `"Beethoven day" `\
  `"What larks"    `\
  

### Atoms

### Creating types



### Functions

Functions contains expressions which are not be evaluated immediatly, but converted to a special kind of value called a function value. This value may be passed around and used as an argument to other functions. The expression it defines is evaluated when the function is applied.

Functions expressions may contain parameters which are placeholders for values to be supplied when
the function is evaluated.  A function may also refer to values defined in the environment where it was created, using [lexical scope resolution](http://en.wikipedia.org/wiki/Scope_%28programming%29#Lexical_scoping).


### Sequences

A sequence capture the general notion of values following values.
                                                                 
TODO



                                                                                 

As should be clear by now, functions, sequences and type expressions are the basic units of abstraction in the Vitry language.


\


## Musical structures

Vitry provide a representation of the structures typically found in musical scores. All musical structures are compound types, defined as standard type expressions. This gives the user of the power to define custom structures that operate on the same level of abstraction as the standard structures.

A distinction is made between musical information (such as pitch or duration) from notational (such as key or time signatures). This allow us to decouple decisions made on the musical level from the practical considerations of notation.

TODO 

### Time                     
The type time is a synonym for the rational number. This allow us to encode conventional note lengths such as whole half notes, quarter notes, etc.

  `1, 1/2, 1/4 `\                            
  
Using sequence operators, we can make sequences run i different relative tempos, i.e:

  `[1 1/2 1/2]`\
  `[1 1/2 1/2] * 2`



### Pitch
### Other events
### Representing music
### Notations
### Part trees
### Instrumentations
### Continuous events
### Repetition and nonlinearity




## Input and output

### The Sibelius writer
### The LilyPond writer
### The MusicXML writer
### The MIDI writer
    
## Advanced language features
### Laziness
### The evaluation model

## Other
### Other languages
### Adding notations
### Adding writers
  

