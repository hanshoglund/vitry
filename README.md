##Vitry

Vitry is a functional programming language and an environment for representation and manipulation of music. The language features a succinct, expressive syntax and a powerful type system. The represented music can be output in a variety of formats, transcribed to musical notation or used as control data for sound synthesis.

The current version is an ***experimental*** implementation built on top of the Mozilla Rhino environment.


## Building and installing

Vitry targets the [Java Virtual Machine](http://en.wikipedia.org/wiki/Java_Virtual_Machine), and may be used with almost any operating system. The only dependency is the Java runtime environment. The build requirements are [Git](http://git-scm.com/) and [Apache Ant](http://ant.apache.org/). You may check if these are installed as follows:
                                 
    $ java
    $ git
    $ ant

If not, download and install from the sites above or through your package management system.

As soon as the build requirements are in place, do:

    $ git clone git@github.com:hanshoglund/vitry.git
    $ cd vitry
    $ ant
    $ sudo ant install
                      
Or if you are on Windows:

    $ git clone git@github.com:hanshoglund/vitry.git
    $ cd vitry
    $ ant
    $ ant install

You may append a directory to the install command.

         
## The interpreter

The interpreter is typically the simplest way to interact with Vitry. To run it, simply type `vitry`.


