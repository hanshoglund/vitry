/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */

/**
 * Provides means of reading music notation from other environments or the file
 * system.
 *
 * @author Hans Höglund
 * @date 2010
 */

var SibeliusReader  = function(){};
var MusicXMLReader  = function(){};
var MIDIReader      = function(){};


exports.add ( SibeliusReader, MusicXMLReader, MIDIReader );