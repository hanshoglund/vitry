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

\pagebreak

## Introduction
Vitry is a functional programming language with an inline syntax and a simple, expressive type system. It is designed to simplify representation of compund musical structures. Vitry may be used for algorithmic composition or analysis. 

Vitry includes a powerful model of standard musical notation. It performs no graphical rendering of music on its own, but it built for seamless integration with standard score-editing tools, such as [Sibelius](http://www.sibelius.com/) and [LilyPond](http://lilypond.org/). It also reads and generates standard file formats used for musical representation, such as MusicXML and standard MIDI files. 




\pagebreak

## First steps

### Install

Vitry targets the [Java Virtual Machine](http://en.wikipedia.org/wiki/Java_Virtual_Machine), and thus runs on most operating system. On OS X, Java is preinstalled by default.

You may download a pre-compiled version of Vitry from [http://vitry.github.com/downloads](http://vitry.github.com/downloads).

To compile the latest version yourself, Git and ANT is required. In this case, use the following commands to fetch the source code and build: 
<pre>
$ git clone git@github.com:hanshoglund/vitry.git
$ cd vitry
$ ant
</pre>
              
### The interpreter
The simplest way to interact with Vitry is through the *interpreter*.

TODO starting a session
TODO the REPL mode
TODO interpreter command

### Setting up the environment

TODO the .profile.vitry file
TODO variables

### Sibelius installation


\
\
\pagebreak

## Language

TODO intro text

TODO more definitions

*Values* are pieces of data that we can retrieve and manipulate.  *Expressions*  are a series of values or other expressions that may be *evaluated*. The evaluation will produce a value, provided it succeeds. *Types* are special values that help us create and reason about other values. Types are created from type expressions.

### Basic types

#### Booleans
The boolean type is written as `bool`. 

Boolean values are written as `true` or `false`.

#### Numbers
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


#### Strings
Strings are sequences of Unicode characters. The string type is written as `string`.

String values are written inside double-quotes:

  `"Beethoven day" `\
  `"What larks"    `\
  

### Compound types
### Functions
### Sequences



\pagebreak

## Musical structures
### Time
### Pitch
### The music type
### Using notations
### Part trees
### Instrumentation functions


\pagebreak

## Input and output

### The Sibelius writer
### The LilyPond writer
### The MusicXML writer
### The MIDI writer


## Advanced features

### Other languages
### The evaluation model
### Adding notations
### Adding writers
  

*© Hans Höglund 2010. Available under the [GNU FDL](http://www.gnu.org/copyleft/fdl.html)*


</div>