
Vitry manual
======================================================================
*By Hans Höglund*

\pagebreak

## Introduction
Vitry is a programming language and environment for music composition and analysis, primarily in a non-realtime context.  It is designed to simplify representation of compund musical structures. The main purpose is generation of music notation, but it can also be used for general procesing of musical structures, or act as as a bridge between notation and other media environments. It performs no graphical rendering of music on its own, but it built for seamless integration with standard score-editing tools, such as [Sibelius](http://www.sibelius.com/) and [LilyPond](http://lilypond.org/). 

Vitry includes a powerful model of standard musical notation, which may be interactively read and written to the standard score writing applications Sibelius and Lilypond. It also reads and generates standard file formats used for musical representation, such as MusicXML and standard MIDI files.

Vitry shares many traits with the [PWGL](http://www2.siba.fi/PWGL/) and [OpenMusic](http://recherche.ircam.fr/equipes/repmus/OpenMusic/) environments. However, there are also some differences:

- It is not graphical
- It is not based on CommonLisp/CLOS.
- It emphasizes interaction with scorewriter software

The Vitry language is a simple functional language with an inline syntax. 



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

### Values and expressions
Like most functional languages, Vitry consists almost solely of expressions.



### Basic types

#### Booleans
The boolean values are `true` or `false`.

#### Numbers
Vitry supports bignum natural, integer and rational numbers, as well as floating-point real and complex numbers.

TODO

#### Strings
Strings are sequences of 16-bit Unicode characters.

#### Functions
#### Sequences



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