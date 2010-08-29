/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */

/**
 * Provides the music model.
 *
 * @author Hans Höglund
 * @date 2010
 */
exports.addAll = {
  Music : Music,
  Notation : Notation,
  Notation : Notation,
  Notation : Notation,
  Notation : Notation,
  Notation : Notation,
  Notation : Notation,
  Notation : Notation,
  Notation : Notation,
  Notation : Notation,
  Notation : Notation,
  Notation : Notation,  
};

Music           = Type();

Notation        = Type();
DynamicNotation = Type();
PitchNotation   = Type();
TimeNotation    = Type();

Event           = Type();
Note            = Type();
Sound           = Type();
Curve           = Type();

Position        = Type();
Duration        = Type();

Pitch           = Type();
PitchClass      = Type();
PitchName       = Type();
Accidental      = Type();
Octave          = Type();

Location        = Type();

Key             = Type();
Time            = Type();
Tonality        = Type();
