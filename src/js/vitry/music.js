/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */

/**
 * Provides the music model.
 *
 * @author Hans Höglund
 * @date 2010
 */
exports.all = [   
  Music
  , Notation
]   

var core = require("vitry/core");
var Type = core.Type;


var Music           = Type();

var Notation        = Type();
var DynamicNotation = Type();
var PitchNotation   = Type();
var TimeNotation    = Type();

var Event           = Type();
var Note            = Type();
var Sound           = Type();
var Curve           = Type();

var Position        = Type();
var Duration        = Type();

var Pitch           = Type();
var PitchClass      = Type();
var PitchName       = Type();
var Accidental      = Type();
var Octave          = Type();

var Location        = Type();

var Key             = Type();
var Time            = Type();
var Tonality        = Type();
