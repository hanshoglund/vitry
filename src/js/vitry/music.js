/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */
 
// TODO Rewrite from scratch based on persistant classes

/**
 * Provides the music model.
 *
 * @author Hans Höglund
 * @date 2010
 */
function Event(pitch, duration) {
  if (!(this instanceof Event)) return new Event();
  
   this.duration = duration || new Rational(0)
   this.pitch    = pitch    || -1
}

Event.prototype = {
  serialize : function() {
    return {
      // type:     this.type,
      duration: this.duration.serialize(),
      pitch:    this.pitch
    }
  }
}


/**
 * A collection of musical Events indexed by time.
 */
function Score() {
  if (!(this instanceof Score)) return new Score();
  
  this.attributes   = {};
  this.events       = {};
  this.lastPosition = new Rational(0);
} 

Score.prototype = {  
  
  clear : function() {
    this.events       = {};
    this.lastPosition = new Rational(0);
  },

  note : function(pitch, duration) {  
    var dur = Rational.coerce(duration);
    this.events[this.lastPosition.toString()] = [new Event(pitch, dur)];
    incr(this, dur);
  },

  rest : function(duration) {
    incr(this, Rational.coerce(duration));
  },

  pitches : function(fn, steps, dur) {
    for ( var i = 0; i < steps; ++i)
      this.note(fn.call(null, i), dur);
  }, 
  
  serialize : function() {
    var that = this;
    return {
      attributes: this.attributes,
      events: 
        this.events.keys() .
        map(Rational.coerce) .
        // sort(Rational.compare) . 
        map(function(k) {
          return [ k.serialize(), that.events[k.toString()] ]
        })
    }
  },
  
  toString : function() {
    return "[Score score]";
  }
} 

function incr(score, dur) {
  score.lastPosition = score.lastPosition.add(dur);
}





exports.add ( Score, Event


              /*Music,
              Notation, DynamicNotation, PitchNotation, TimeNotation,
              Event, Note, Sound, Curve,
              Position, Duration,
              Pitch, PitchClass, PitchName, Accidental, Octave,
              Location,
              Key, Time, Tonality*/ );