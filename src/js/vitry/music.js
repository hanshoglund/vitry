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
   this.type     = null;
   this.duration = duration || new Rational(0)
   this.pitch    = pitch    || -1
}

Event.prototype = {
  serialize : function() {
    return {
      type:     this.type,
      duration: this.duration.serialize(),
      pitch:    this.pitch
    }
  }
}


/**
 * A collection of musical Events indexed by time.
 */
function Score() {
  this.attributes   = {};
  this.events       = new Map();
  this.lastPosition = new Rational(0);
} 

Score.prototype = {  
  
  clear : function() {
    this.events.clear();
    this.lastPosition = new Rational(0);
  },

  note : function(pitch, duration) {
    if (typeof duration === "string")
      duration = Rational.parse(duration);
    if (typeof duration === "number")
      duration = new Rational(duration);

    this.events.put(this.lastPosition.clone(), [ new Event(pitch, duration) ]);
    this.lastPosition = this.lastPosition.add(duration);
  },

  rest : function(duration) {
    if (typeof duration === "string")
      duration = Rational.parse(duration);
    if (typeof duration === "number")
      duration = new Rational(duration);

    this.lastPosition = this.lastPosition.add(duration);
  },

  pitches : function(fn, steps, dur) {
    for ( var i = 0; i < steps; ++i)
      this.note(fn.call(null, i), dur);
  }, 
  
  // 
  // chord : function(pitches, duration) {
  //   if (typeof duration === "string")
  //     duration = Rational.parse(duration);
  // 
  //   var i, chordEvents = [];
  // 
  //   for (i = 0; i < pitches.length; ++i) {
  //     chordEvents.push(new MJOS.score.Event(pitches[i], duration));
  //   }
  //   this.events.put(this.lastPosition.clone(), chordEvents);
  //   this.lastPosition = this.lastPosition.add(duration);
  // },  
  
  toString : function() {
    return "[Score score]";
  },

  serialize : function() {
    var that = this;
    return {
      attributes: this.attributes,
      events: this.events.keys().sort(Rational.compare).map(function(k) {
        return [ k.serialize(), that.events.get(k) ]
      })
    }
  }
}

              


function standardAttributes() {
  return {
    // style: "MJOS.score.WriterTreble",
    // title: "Output[" + "]",
    otherInformation: "Generated " + new Date().strftime("%Y-%m-%d %H:%M:%S")
  };
}





exports.add ( Score, Event


              /*Music,
              Notation, DynamicNotation, PitchNotation, TimeNotation,
              Event, Note, Sound, Curve,
              Position, Duration,
              Pitch, PitchClass, PitchName, Accidental, Octave,
              Location,
              Key, Time, Tonality*/ );