
Vitry
Pre-alpha, not usable
By Hans Höglund


Vitry is a functional programming language and an environment for representation and manipulation of music. The language features an infix syntax and a simple, expressive type system. The represented music can be output in a variety of formats, transcribed to musical notation or used as control data for sound synthesis.

Targets the JVM, works on Windows, Linux and OS X.


Instructions

    Build
        $ ant
                 
    Build options
        $ ant -p
    
    Run 
        $ java -cp lib/js.jar:lib/jline.jar:vitry.jar vitry.main
        or
        $ ./vitry.sh