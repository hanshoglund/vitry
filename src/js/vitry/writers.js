/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */

/**
 * Provides means of writing music notation to other environments or the file
 * system.
 *
 * @author Hans Höglund
 * @date 2010
 */

var SibeliusWriter  = function(){};
var LilyPondWriter  = function(){};
var MusicXMLWriter  = function(){};
var MIDIWriter      = function(){};


exports.add ( SibeliusWriter, LilyPondWriter, MusicXMLWriter, MIDIWriter);