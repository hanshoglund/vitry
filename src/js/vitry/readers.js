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
exports.all = {
};

var core = require("vitry/core");
var Type = core.Type;


var SibeliusReader  = Type();
var MusicXMLReader  = Type();
var MIDIReader      = Type();
