##Vitry
A music composition environment manily aimed at notated music.

*Pre-alpha and experimental*.


### Features
- Textual interface with built-in interpreter and compiler
- Various language front-end, including:
    - JavaScript
    - VitryScript (an simple functional language)
- Runs on all platform

- Powerful notation model, including:
    - Variable event types (pitched, percussion etc)
    - Music theory concepts: scales, harmony, voice leading, tuning systems
    - Powerful time model        
    - Various interpolation techniques  

- Import and export music to various working environments on-the-fly:
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

