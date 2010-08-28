##Vitry
A music composition environment manily aimed at notated music.

*Pre-alpha and experimental*.


### Features
- Textual interface with built-in interpreter and compiler
- Various language front-end, including:
    - Java
    - JavaScript
    - VitryScript (an simple functional language)

- Powerful notation model, including:
    - Variable event types:
        - Pitched, percussion and custom
    - Music theory concepts:
        - Scales, harmony, voice leading, tuning system
        - Time model
    - Tempo with continous change        
    - Dynamics
    - Various interpolation techniques  

- Import and export music to various working environments on-the-fly
    - MusicXML
    - [Sibelius](http://www.sibelius.com/)
    - GNU LilyPond

### Requirements
- [Java SE 6](http://www.java.com/en/download/) or better
- [Apache Ant](http://ant.apache.org/) (for building)

### Build
For complete build:
<pre>
ant
</pre>

For options:
<pre>
ant -p
</pre>

