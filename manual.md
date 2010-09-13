
Vitry manual
======================================================================
*By Hans Höglund*

\pagebreak

## Introduction
Vitry is a functional programming language with an inline syntax and a simple, expressive type system. It is designed to simplify representation of compund musical structures. 

The raison d'etre of Vitry is generation of music notation, but it can also be used for general procesing of musical structures, or act as as a bridge between notation and other media environments. 

Vitry includes a powerful model of standard musical notation. It performs no graphical rendering of music on its own, but it built for seamless integration with standard score-editing tools, such as [Sibelius](http://www.sibelius.com/) and [LilyPond](http://lilypond.org/). It also reads and generates standard file formats used for musical representation, such as MusicXML and standard MIDI files. 




\pagebreak

## First steps

### Download and install

#### Prerequirements
Vitry targets the [Java Virtual Machine](http://en.wikipedia.org/wiki/Java_Virtual_Machine), and thus runs on most operating system. On OS X, Java is preinstalled by default.

#### Download
You may download a pre-compiled version of Vitry from [http://vitry.github.com/downloads](http://vitry.github.com/downloads).

To compile the latest version yourself, Git and ANT is required. In this case, use the following commands to fetch the source code and build: 
<pre>
$ git clone git@github.com:hanshoglund/vitry.git
$ cd vitry
$ ant
</pre>
              
### Using the interpreter
The simplest way to interact with Vitry is through the *interpreter*.

TODO starting a session, using repl



\pagebreak

## The language

The Vitry language have a very small core. Like in most functional languages, there are no statements, instead there are *expressions*. An expression is a series of values that may be evaluated to produce a single value.


*values* and *types*.

A value is a piece of data.




Types are a powerful concept that help us create and reason about or values. Every value and expression have an associated type. 
       
### Booleans
The boolean type is written as `bool`.

The boolean values are written as `true` or `false`.

### Numbers
Vitry supports bignum natural, integer and rational numbers, as well as floating-point real and complex numbers.

The types of these are writen as `nat`, `int`, `rat`, `float` and `complex` respectively.

Natural, integers and rational numbers are written as sequences of digits. Vitry will automatically convert integers to rationals and vice versa.

  `152 `\
  `42  `\
  `-8  `\
  `3/2 `

Floating point numbers may be writen in several ways:

  `0.1     `\
  `0.12e10 `\
  `2e-5    `\
  `0.5/2   `
  
We create a complex number by adding the imaginary unit `i` to the imaginary part:

  `2i          `\
  `1 + 0i      `\
  `22.4 + 32e4i`


### Strings
Strings are sequences of Unicode characters. The string type is written as `string`.

String values are written inside double-quotes:

  `"Beethoven day" `\
  `"What larks"    `\
  

### Functions
### Sequences



\pagebreak

## Musical structures
### Time
### Pitch
### The music type
### An introduction to notations



\pagebreak

## Import and export

### The Sibelius writer
### The LilyPond writer
### The MusicXML writer
### The MIDI writer


## Advanced features

### Other languages
### The evaluation model
### Adding notations
### Adding writers