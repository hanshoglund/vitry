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
exports.addAll = {
};

var core = require("vitry/core");
var Type = core.Type;


var SibeliusWriter  = Type();
var LilyPondWriter  = Type();
var MusicXMLWriter  = Type();
var MIDIWriter      = Type();
