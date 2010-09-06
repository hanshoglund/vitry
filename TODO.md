
- Core
    - Proper Integer / Ratio types
    - Perstistant structures

- In-environment interpreter/compiler interface
    - vitry.core.load() 
        - Loads and interprets a js or vs file
        - Script is executed at top-level
        - Standard require
        - Exports/module is vitry.core
    - vitry.core.compile()            
        - Compiles a js or vs file
        - Each js and vs file becomes an JVM class implementing org.mozilla.javascript.Script
        - This script uses require/module/exports as usual
    - Vitry checks for compiled scripts using a custom ClassLoader, which searches
        - Java classpath supplied when invoking Vitry
        - vitry.core.load.paths
    - Vitry checks for non-compiled scripts in
        - Java classpath supplied when invoking Vitry
        - vitry.core.load.paths
    
    - Probable bootstrapping procedure:
        - Ant invokes javac/jsc to compile basic parts of vitry.core
        - Ant invokes vitry.core.compile() to compile .vitry parts
        - Everything goes to bin
        - Jar is constructed (optional)
        
- Better way to invoke jsc from ANT (now we pass source files individually)
    - Possibly: Pass main + core, then do everything else through call 
    to vitry.core.load(), see also above
    
- Simple homebrewn doc system
- GUI? Swing, SWT, Canvas?