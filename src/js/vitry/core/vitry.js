/* 
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */

/**
 * Vitry, a non-realtime composition environment.                        
 *
 * This module creates the environment runs the command-line-interpreter. Before 
 * it is loaded, the bootstrap code will create the module system and define
 * the following global variables (only accessible to this module):
 *     CLASSPATH
 *     JAVA
 *     LANG                                     
 *
 * It then calls the main method of this module.
 *
 * @author Hans Höglund 
 * @date 2010
 */
var beautifier  = require( "/vitry/core/beautifier" );

// TODO not like this...
exports = {    
    
    
}


function main (args) {
  print("Welcome!");
}                 
     


