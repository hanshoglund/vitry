/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */

/**
 * Provides the music model.
 *
 * @author Hans Höglund
 * @date 2010
 */

var Music           = function(){};

var Notation        = function(){};
var DynamicNotation = function(){};
var PitchNotation   = function(){};
var TimeNotation    = function(){};

var Event           = function(){};
var Note            = function(){};
var Sound           = function(){};
var Curve           = function(){};

var Position        = function(){};
var Duration        = function(){};

var Pitch           = function(){};
var PitchClass      = function(){};
var PitchName       = function(){};
var Accidental      = function(){};
var Octave          = function(){};

var Location        = function(){};

var Key             = function(){};
var Time            = function(){};
var Tonality        = function(){};


exports.add ( Music,
              Notation, DynamicNotation, PitchNotation, TimeNotation,
              Event, Note, Sound, Curve,
              Position, Duration,
              Pitch, PitchClass, PitchName, Accidental, Octave,
              Location,
              Key, Time, Tonality );