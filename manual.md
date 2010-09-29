<script type="text/javascript">
var tocVisible = false;

function toc(status) {
    document.getElementById("TOC").style.display = ( status ? "block" : "none" );
    document.getElementById("main").style.marginLeft = ( status ? "220px" : "0px" );
    tocVisible = status;    
}

function toggle() {
    toc(!tocVisible);
}
   
toc(true);      

</script>
<div id="toggle">
---                                                     ---
[Vitry on Github](http://github.com/hanshoglund/Vitry)  [Toggle contents](javascript:toggle())  
---                                                     ---
</div>
<div id="main">


Vitry manual
======================================================================
<small>*© Hans Höglund 2010*</small>

\
\pagebreak

## Introduction
Vitry is a programming language with an inline syntax and simple, expressive type system. It is designed to allow easy representation of all kinds of musical structures. Vitry may be used for algorithmic composition or analysis. 

Vitry includes a powerful model of standard musical notation. It performs no graphical rendering of music on its own, but it built for seamless integration with standard score-editing tools, such as [Sibelius](http://www.sibelius.com/) and [LilyPond](http://lilypond.org/).



\
\pagebreak

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
\pagebreak

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
  
We create a complex number by adding the imaginary unit `i` to the imaginary part:

  `2i          `\
  `1 + 0i      `\
  `22.4 + 32e4i`


#### Strings
Strings are sequences of Unicode characters. The string type is written as `string`. String values are written inside double-quotes:

  `"Beethoven day" `\
  `"What larks"    `\
  

### Compound types
### Functions
### Sequences



\
\pagebreak

## Musical structures

Vitry provide a representation of the structures typically found in musical scores. All musical structures are defined in terms of type expressions, which are also exposed to structures representing any kind of musical transcription.

As will be clear at the end of this chapter, Vitry makes a clear distinction between the representations of *music* and its *notation*. Loosely, we may think of music as structured data, and of notations as presentations of this data according to the given structure. This allows Vitry to associate identical musical structures with different notations.

The separation of music and notation allow the representation of simple musical values (such as pitch and time) to be precise and inherently relative. Vitry accomplish this by usign rational numbers for such values.



### Time                     


### Pitch
### Other events
### Representing music
### Notations
### Part trees
### Instrumentations
### Continuous events
### Repetition and nonlinearity


\pagebreak

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
  


</div>