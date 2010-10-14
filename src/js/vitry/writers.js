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

// ======================================================================
// Sibelius

function SibeliusWriter(){
  
}

var files = {
  bind :            "bind",
  synchronize :     "synchronize",
  receive :         "receive",
  send :            "send"
}

var referencePrefix       = "sibobj_";

// Cached global objects.
var globals               = [];

var startTime             = new Date();
var sendTime              = null;
var synchronizationTime   = null;
var sentMessagesCount     = 0;
var receivedMessagesCount = 0;

// Listeners and taks
var bindListeners         = [];
var fileListeners         = [];
var fileMonitor;
var fileMonitorInterval = 200;
//var scriptingBindListener;

/**
 * Prints a message in the Sibelius trace window.
 */
function trace(msg) {
  getSibelius().trace(msg, function(){});
}

/**
 * Returns the global Sibelius object.
 */
function getSibelius () {
  return getGlobal("Sibelius", "Sibelius");
}

/**
 * Returns the global object of the given name.
 *
 * @param {String}
 *   name Global name of the object.
 * @param {String}
 *   type If supplied, <code>types</code> is checked for
 *   a type of this name and proxy methos are created.
 */
function getGlobal(name, type) {
  if (!globals[name]) globals[name] = new Proxy(name, type);
  return globals[name];
}

/**
 * Adds a listener for bind events. This can be used to trigger a synchronize
 * event in Sibelius automatically using any platform-dependent means.
 */
function addBindListener(event) {
  if (bindListeners.indexOf(event) < 0)  bindListeners.push(event);
}

/**
 * Removes the given bind listener.
 */
function removeBindListener(event) {
  if (bindListeners.indexOf(event) >= 0) delete bindListeners[poss];
}

/**
 * Notifies receivers of a change in the synchronize file.
 */
function fileChanged() {
  if (this.isSynchronized()) notifyFileListeners();
}

/**
 * Enable or disable file monitoring.
 */
function setFileMonitoring(status) {
  var Thread = Packages.java.lang.Thread;
  var Runnable = Packages.java.lang.Runnable;
  
  if (status) {
    if (!fileMonitor || !fileMonitor.isAlive()) {
      fileMonitor = new Thread(
        new Runnable({ run : function() {
          try {
            while(true) {
              Thread.sleep(fileMonitorInterval);
              fileChanged();                  
            }
          } catch (e if e instanceof JavaException){}
        }})
      );      
      fileMonitor.start();                     
    }
  } else {
    fileMonitor.interrupt();
  }
}


// function useSynchronizeScript(status) {
  // TODO
  
  // var stdIn;
  // 
  // if (status) {
  //   stdIn = new Shell().getInputStream()
  //   scriptingBindListener = function() {
  //       // Echo to prevent "no output" message
  //       stdIn("osascript " + synchronizeScript)
  //   }
  //   addBindListener(scriptingBindListener)
  // } else {
  //   removeBindListener(scriptingBindListener)
  // }
// }

/**
 * Returns true if Sibelius has been synchronized to Vitry at least once since the
 * latest message was transmitted.
 */
function isSynchronized() {
  return sendTime !== null && sendTime < getSynchronizationTime();
}

/**
 * Returns true if Sibelius has been synchronized to Vitry at least once since
 * startup time.
 */
function isSynchronizedSinceStartup() {
  return startTime < getSynchronizationTime();
}

/**
 * Returns the last time Sibelius were synchronized to Vitry.
 *
 * @returns time of last response.
 * @type Date
 */
function getSynchronizationTime() {

  var d = new Date();
  var fin;

  if (!synchronizationTime || d > synchronizationTime) {
    fin = getSynchronize();

    try {
      d.setISO8601("" + fin.readLine());
    } catch (e if (! e instanceof JavaException)) {
      // Could not parse date, usually because it is still
      // being written
      return synchronizationTime;
    } 

    // Sibelius writes local date, but we read UTC
    // Compensate by adding UTC offset
    d.setMinutes(d.getMinutes() + d.getTimezoneOffset());
    synchronizationTime = d;
  } else {
    return synchronizationTime;
  }

  fin.close();
  return d; 
}

function getPendingMessages() {
  return sentMessagesCount - receivedMessagesCounts;
}

/*
 * Notifies (calls) and removes all file listeners.
 */
function notifyFileListeners() {
  while (fileListeners.length > 0) {
    fileListeners.shift().call(this);
  }
}

/*
 * Notifies (calls) all file listeners.
 */
function notifyBindListeners() {
  var i;
  for (i in bindListeners) {
    if (bindListeners.hasOwnProperty(i)) {
        bindListeners[i].call(this);
    }
  }
}


/**
 * Represents a Sibelius dictionary
 * @param obj
 *   Object whose properties to copy.
 */
function Dictionary(obj) {
  this.extend(obj);
}


function Expression(object, method, args) {
  this.toString = function () {                                     
    
    return "(" + object + "," + method + "," + args.join(",") + ")";
  } 
}




/**
 * A proxy object, representing a Sibelius object.
 *
 * <ul>
 * <li>Methods are accessed through member functions of the same name.</li>
 * <li>Fields are accessed through get/set methods.</li>
 * <li>Iterators are accessed through special get methods.</li>
 * </ul>
 *
 * 
 * Methods can be called directly using the call method. Fields and iterators
 * can be queried directly using the set, get and iterate methods.
 * 
 * Each method may return a primitive value, an array or another proxy object.
 *
 * @param object
 *   {String} Reference to the underlying object.
 * @param type
 *   Type of the represented object. Expected object return type. Must be
 *   defined in types.
 * @param socket
 *   {Socket} Socket for future messages.
 */
function Proxy(object, type, socket) {

  // FIXME Sometimes does not set smallCaps/AllCaps names correctly

  /**
   * Reference to the underlying object.
   */
  this.object = object;
  
  var that = this;

  if (!socket) {
      socket = new Socket();
  }

  // Add proxy methods, including getters, setters and iterators
  /*
   * Adds proxy methods, including getters, setters and iterators to the Proxy
   * object being constructed.  Each proxy method will call either call,
   * set, get or iterate. 
   */
  var typeDescr = types[type];

  if (typeDescr) {
    typeDescr.methods.keys().forEach(function (name) {
      var sibName = toSibeliusName(name);
      var type    = typeDescr.methods[name];
      // print([name, sibName, type]);
      var proxy = (function () {
        var args  = parseArgs(arguments);
        var cont  = extractContinuation(args);
        return this.call(sibName, type, args, cont);
      });
      that[name]  = proxy;
      that[sibName] = proxy;
    });                    
      
      // for (field in typeDescr.fields) {
      //   (function() {
      //     var sibName  = toSibeliusName(field);
      //     var setter   = "set" + sibName;
      //     var getter   = "get" + sibName;
      //     var type     = typeDescr.fields[field];
      //     that[setter] = function (value, cont) {
      //       return that.set(sibName, value, cont);
      //     }
      //     that[getter] = function (cont) {
      //       return that.get(sibName, type, cont);
      //     }
      //   }());

  }   

  // FIXME support iterators  

  // The call, get set and iterate methods can be used to access any
  // member on the underlying object. The proxy methods are convenient
  // wrappers that call these methods.

  // Each of these methods may take and return objects (Proxy instances)
  // or JavaScript arrays.

  /**
   * Calls the given method on this object.
   *
   * 
   * If a continuation function is passed, the result is passed as the first
   * argument to that function, otherwise it is returned.
   * 
   *
   * @param name
   *          Method name.
   * @param type
   *          Expected object return type. Must be defined in types.
   * @param args
   *          Array of arguments.
   * @param cont
   *          If present, this function is called passing the result of the
   *          call.
   */
  this.call = function(name, type, args, cont) {
    // var msg = "(" + this.object + "," + name;
    // for (var i in args) {
    //   if (args.hasOwnProperty(i)) {
    //     msg += "," + processArgument(args[i]);
    //   }
    // }
    // msg += ")";
    var msg = "createMessageNode(" + 
      this.object.toString().quote() + 
      "," + 
      name.quote() + 
      "," + 
      "CreateSparseArray(" +    
      [ processArgument(a) for each (a in args) ].join(",") +
      "))";
    
    return send(msg, type, cont);
  }

  /**
   * Set the given field of this object to the given value. If the given field
   * is not modifiable, this method does nothing.
   * 
   * Setting fields may imply effects in Sibelius, see the original
   * documentation.
   * 
   *
   * @param name
   * @param value
   * @param cont
   *          If present, this function is called whenever the value has been
   *          set.
   *
   */
  this.set = function(name, value, cont) {
    var msg = "(,set," +
      this.object +
      "," + name +
      "," + processArgument(value) +
      ")";
    return send(msg, type, cont);
  }

  /**
   * Returns the value of the given field on this object.
   *
   * @param name
   * @param type
   *          Expected object return type. This must be one of the types
   *          defined in types.
   * @param cont
   *          If present, this function is called passing the result of the
   *          get operation.
   */
  this.get = function(name, type, cont) {
    var msg = "(,get," +
      this.object +
      "," + name +
      ")";    
    return send(msg, type, cont);
  }

  /**
   * Returns an iteration over this object using the given type.
   *
   * @param type
   *          Expected object return type. This must be one of the types
   *          defined in types.
   * @param cont
   *          If present, this function is called passing the result of the
   *          iteration.
   */
  this.iterate = function (type, cont) {
    var msg = "(,iterate," +
      this.object +
      "," + type +
      ")"; 
    return send(msg, type, cont);
  }

  /*
   * Sends the given message on the underlying socket.
   */
  function send(msg, type, cont) {
    var v;
    if (cont) {
      socket.blocking = false;
      socket.receiver = function (v) {
        cont.call(that, processReturnValue(v, type));
      }
      socket.send(msg);
    } else {
      socket.blocking = true;
      v = socket.send(msg);
      return processReturnValue(v, type);
    }   
  }

  /*
   * Processes the given message (argument) prior to sending it.
   */
  function processArgument(msg) {
    return unparse(contract(msg));
  }

  /*
   * Processes the given received message (return value).
   */
  function processReturnValue(msg, type) {
    return expand(parse(msg), type);
  }

  /*
   * Unparses (flattens) a string value or array of values or arrays. Returns
   * a message expression.
   */
  function unparse(value) {
      var msg = "",
          first,
          last,
          i;

      if (value instanceof Array) {
          msg += "CreateSparseArray(";
          last = value.length - 1;
          for (i = 0; i < last; i++) {
              msg += unparse(value[i]);
              msg += ",";
          }
          msg += unparse(value[last]);
          msg += ")";

      } else if (typeof value === "object") {
          if ((value !== null) &&
              (value.serialize) &&
              (typeof value.serialize === "function")) {
              msg += unparse(value.serialize());

          } else {
              msg += "CreateDictionary(";
              first = true;
              for (i in value) {
                  if (value.hasOwnProperty(i) && typeof value[i] !== "function") {
                      if (first) {
                          first = false;
                      } else {
                          msg += ",";
                      }
                      msg += unparse(i);
                      msg += ",";
                      msg += unparse(value[i]);
                  }
              }
              msg += ")";
          }

      } else if (typeof value === "function") {
          msg = "";

      } else {
        // msg = escape(String(value));
        msg = String(value).quote();
      }
      return msg;
  }

  /*
   * Parses a message and returns either a value, or an array of values or
   * arrays.
   */
  function parse(msg) {
    return msg;
  }

  /*
   * If value is a proxy object, replace with its reference. If value is an
   * array, invoke recursively on all its elements. Otherwise, return value.
   */
  function contract(value) {
      var i;
      if (value instanceof Proxy) {
          return value.object;
      } else if (value instanceof Array) {
          for (i in value) {
              if (value.hasOwnProperty(i)) {
                  value[i] = contract(value[i]);
              }
          }
          return value;
      } else {
          return value;
      }
  }           
  
  /*
   * If msg is a reference, replace with a proxy object. If msg is an array,
   * invoke recursively on all its elements. Otherwise, return msg.
   */
  function expand(msg, type) {
      var i;
      if (isReference(msg)) {
          return new Proxy(msg, type, socket);
      } else if (msg instanceof Array) {
          for (i in msg) {
              if (msg.hasOwnProperty(i)) {
                  msg[i] = expand(msg[i]);
              }
          }
          return msg;
      } else {
          return msg;
      }
  }

  function extractContinuation(args) {
    if (typeof args[args.length - 1] === "function")
      return args.pop();
    return null;      
  }   
}











/**
 * @class A socket communicating with Sibelius.
 *        
 *        Socket objects read and write messages in text format. The expression
 *        syntax defined by the Sibelius API plugin is supported for sent
 *        messages. Received messages may contain object references array
 *        expressions, and escaped strings.
 *        
 *
 * @param address
 *          {String} Socket address.
 * @param receiver
 *          {Function} If this socket is in non-blocking mode, this function is
 *          called whenever a message is received and passed that message.
 * @param blocking
 *          Whether or not this socket is in blocking mode. If true, the send
 *          and listen methods will block until the synchronize file has been
 *          updated
 * @param timeOut
 *          Time out value in milliseconds. Only applies if this socket is in
 *          blocking mode.
 */
Socket = function (address, receiver, blocking, timeOut) {
  
  var that                = this;
  var listening           = false;
            
  /**
   * Socket address.
   */
  this.address  = address || generateSocketAddress();
  
  /**
   * Called whenever a message is received in non-blocking mode.
   */
  this.receiver = receiver || function(){};
  
  /**
   * If true, the send and listen methods will block until the synchronize file
   * has been updated.
   */
  this.blocking = blocking || false;
  
  /**
   * Timeout in milliseconds. Only applies if this socket is in blocking mode.
   */
  this.timeOut  = timeOut    || 3200;
  
  /**
   * Interval in milliseconds.
   */
  this.interval = 30;  
    
    
  /**
   * Sends the given messages.
   *
   * 
   * If this socket is in blocking mode, this method does not return until a
   * response has been received. If the timeout is exceeded, this method throws an
   * error.
   * 
   * 
   * If this socket is in non-blocking mode, this method returns directly. Any
   * response message will be passed to the receiver function.
   * 
   *
   * @param msg
   *   A message string, or an array of message strings.
   */   
  this.send = function (msg) {
    sendTime = new Date();
    ++sentMessagesCount;

    // Write message to socket, then create binding
    write(msg);
    bind();
    
    return accept();
  }  
    
  /**
   * Listen for an incoming message.
   * 
   * If this socket is in blocking mode, it will return the first received
   * message. If the timeout is exceeded, it throws an error.
   * 
   * 
   * If this socket is in non-blocking mode, incoming messages will be passed to
   * the receiver function.
   * 
   */
  this.listen = function () {
    listening = true;
    return accept();
  }   
    
  /*
   * If in blocking mode, this method returns the first received value; else this
   * method returns null and the first received value is passed to the receiver
   * method.
   */
  function accept() {
    if (that.blocking) {
      var time = 0;
      while (!isSynchronized()) {
        if (time >= that.timeOut) {
            throw new Error("Sibelus: socket timed out " + address);
        }
        time += that.interval;
        wait(that.interval);
      } 
      ++receivedMessagesCount;
      return read();
    } else {
      fileListeners.push(function () {
          ++receivedMessagesCount;
          that.receiver.call(that, read());
      });
    } 
  }   
    
  /*
   * Binds this socket to be read by Sibelius.
   */
  function bind() {
    var fout = getBind();
    fout.write(that.address + "\n");
    fout.close();    
    notifyBindListeners();
  }     
    
  /*
   * Reads a message from this socket.
   */
  function read() {
    var fin = getSend(that.address);
    var msg = fin.readLine();
    fin.close();
    return msg;
  }   
     
  /*
   * Writes the given message, or array of messages, to this socket.
   */
  function write(msg) {
    var fout = getReceive(that.address);
    var i;

    if (Object.isObject(msg)) {
      for each (m in msg) {
        fout.write(m + "\n");
      }      
    } else {
      fout.write(msg + "\n");
    }
    fout.close();   
  } 
}

function getBind() {
  try {
    return vitry.core.getWriter(
      vitry.writers.setup.sibelius.socketDir + "/" + files.bind);
  } catch (e) {
    throw new Error("Could not open bind file");
  }
}

function getSynchronize() {
  try {
    return vitry.core.getReader(
      vitry.writers.setup.sibelius.socketDir + "/" + files.synchronize);
  } catch (e) {
    throw new Error("Could not open synchronization file");
  }
}

function getReceive(address) {
  try {
    return vitry.core.getWriter(                                                              
      vitry.writers.setup.sibelius.socketDir + "/" + address + "_" + files.receive);
  } catch (e) {
    throw new Error("Could not open receive file on address " + address);
  }
}

function getSend(address) {
  try {
    return vitry.core.getReader(
      vitry.writers.setup.sibelius.socketDir + "/" + address + "_" + files.send);
  } catch (e) {
    throw new Error("Could not open send file on address " + address);
  }
}


// Definately top-level:


var defaultAddressPart  = "vitry";
var defaultSocketPrefix = "socket";
var defaultSocketsCount = 0;

function generateSocketAddress() {
  return defaultAddressPart + defaultSocketPrefix + (defaultSocketsCount++);
}

/*
 * Blocks for the given duration (in milliseconds).
 */
function wait(time) {
  Packages.java.lang.Thread.sleep(time || 0); 
}

/*
 * Returns true if the given string is a Sibeius object reference.
 */
function isReference(str) {
  return typeof str === "string" &&
    str.match("^" + referencePrefix) === referencePrefix;
}

/*
 * Converts a standard element name (likeThis) to a Sibelius style element name
 * (LikeThis).
 */
function toSibeliusName(str) {
  if (str == "trace") return str;
  return str.substr(0, 1).toUpperCase() + str.substr(1);
}

/*
 * Returns the given string with the special characters '(', ',', ')' and '\'
 * escaped by '\'.
 */
function escape(str) {
  return str.replace(/([(,)\\])/g, "\\$1");
}  

function parseArgs(a) {
  var given = [];
  Array.prototype.push.apply(given, a);
  return given;
}  




var types = {
        
    // ManuScript
        
    "Sibelius" : {
        "iterators" : {
            "getScores" :                [ null, "Score" ]
        },        
        "methods" : {
            "close" :                    null,
            "createProgressDialog" :     null,
            "destroyProgressDialog" :    null,
            "goToEnd" :                  null,
            "goToStart" :                null,
            "isDynamicPartOpen" :        null,
            "messageBox" :               null,
            "moveActiveViewToBar" :      null,
            "moveActiveViewToSelection": null,
            "new" :                      "Score",
            "nthScore" :                 "Score",
            "open" :                     "Score",
            "play" :                     null,
            "playFromStart" :            null,
            "print" :                    null,
            "stop" :                     null,
            "trace" :                    null,
            "yesNoMessageBox" :          null
        },
        "fields" : {    
            "activeScore" :              "Score",
            "playing" :                  null,
            "scoreCount" :               null,
            "viewHighlights" :           null,
            "viewNoteVelocities" :       null,
            "viewNoteColors" :           null
        }
    },
    
    "Bar" : {
        "iterators" : {
            "getBarObjects" :            [ null,         "BarObject" ],
            "getClefs" :                 [ "Clef",     "Clef" ],
            "getLines" :                 [ "Line",     "Line" ],
            "getNoteRests" :             [ "NoteRest", "NoteRest" ],
            "getTexts" :                 [ "Text",     "Text" ]
        },
        "methods" : {
            "addGraphic" :               null,
            "addLine" :                  "Line",
            "addLyric" :                 "LyricItem",
            "addNote" :                  "Note",
            "addRehearsalMark" :         null,
            "addText" :                  "Text",
            "addTimeSignature" :         null,
            "addTimeSignatureReturnObject" : 
                                         "TimeSignature",
            "addTuplet":                 "Tuplet",
            "clear" :                    null,
            "clearNotesAndModifiers":    null,
            "delete" :                   null,
            "respace" :                  null
        },
        "fields" : {
            "barNumber" :                null,
            "breakType" :                null,
            "externamBarNumberString" :
                                         null,
            "length" :                   null,
            "parentStaff" :              "Staff",
            "selected" :                 null,
            "time" :                     null,
            "type" :                     null
        }
    },
    
    "BarObject" : {
        "iterators" : {
        },
        "methods" : {
            "delete" :                   null,
            "deselect" :                 null,
            "nextItem" :                 "BarObject",
            "previousItem" :             "BarObject",
            "removeVoice" :              null,
            "resetPosition" :            null,
            "resetDesign" :              null,
            "select" :                   null,
            "setVoice" :                 null,
            "getIsInVoice" :             null,
            "setAllVoices" :             null
        },
        "fields" : {        
            "dx" :                       null,
            "dy" :                       null,
            "hidden" :                   null,
            "parentBar" :                "Bar",
            "position" :                 null,
            "selected" :                 null,
            "time" :                     null,
            "type" :                     null,
            "voiceNumber" :              null,
            "voices" :                   null
        }
    },
    
    "Comment" : {
        "iterators" : {
        },
        "methods" : {
            "AddComment" :               null,
            "AddCommentWithName" :       null
        },
        "fields" : {
        }
    },
    
    "Line" : {
        "iterators" : {
        },
        "methods" : {
        },
        "fields" : {
            "duration" :                 null,
            "endBarNumber" :             null,
            "endPosition" :              null,
            "rhDy" :                     null,
            "styleId" :                  null,
            "styleAsText" :              null
        }
    },
    
    "NoteRest" : {
        "iterators" : {
            "getNotes" :                 [ null, "Note" ]
        },
        "methods" : {
            "addAcciaccaturaBefore" :    null,
            "addAppoggiaturaBefore" :    null,
            "addNote" :                  "Note",
            "delete" :                   null,
            "flipStem" :                 null,
            "getArticulation" :          null,
            "removeNote" :               null,
            "setArticulation" :          null,
            "transpose" :                null            
        },
        "fields" : {    
            "arpeggioDx" :               null,
            "arpeggioType" :             null,
            "arpeggioTopDy" :            null,
            "arpeggioBottomDy" :         null,
            "arpeggioHidden" :           null,
            "articulations" :            null,
            "beam" :                     null,
            "doubleTremolos" :           null,
            "duration" :                 null,
            "fallDx" :                   null,
            "fallType" :                 null,
            "featheredBeamType" :        null,
            "hasStemlet" :               null,
            "highest" :                  null,
            "lowest" :                   null,
            "noteCount" :                null,
            "graceNote" :                null,
            "isAcciaccatura" :           null,
            "isAppoggiatura" :           null,
            "parentTupletIfAny" :        "Tuplet",
            "positionInTuplet" :         null,
            "stemFlipped" :              null,
            "stemletType" :              null,
            "singleTremolos" :           null
        }
    },
    
    "Note" : {
        "iterators" : {
        },
        "methods" : {
            "delete" :                   null,
            "transpose" :                null
        },
        "fields" : {
            "accidental" :               null,
            "accidentalStyle" :          null,
            "bracketed" :                null,
            "diatonicPitch" :            null,
            "name" :                     null,
            "noteStyle" :                null,
            "ntoeStyleName" :            null,
            "originalDeltaSr" :          null,
            "originalDuration" :         null,
            "originalVelocity" :         null,
            "parentNoteRest" :           "NoteRest",
            "pitch" :                    null,
            "slide" :                    null,
            "tied" :                     null,
            "writtenAccidental" :        null,
            "writtenDiatonicPitch" :     null,
            "writtenName" :              null,
            "writtenPitch" :             null
        }
    },
    
    "Score" : {
        "iterators" : {
            "getStaves" :                [ null, "Staff" ]
        },
        "methods" : {
            "addBars" :                  null,
            "createInstrument" :         null,
            "createInstrumentAtBottomReturnStave" :
                                         "Staff",
            "createInstrumentAtTopReturnStave" :
                                         "Staff",
            "getLocationTime" :          null,
            "insertBars" :               null,
            "lineStyleId" :              null,
            "noteStyleIndex" :           null,
            "nthStaff" :                 "Staff",
            "removeAllHighlights" :      null,
            "save" :                     null,
            "saveAs" :                   null,
            "setPlaybackPos" :           null,
            "staveTypeId" :              null,
            "systemCount" :              null,
            "symbolIndex" :              null,
            "textStyleId" :              null
        },
        "fields" : {
            "composer" :                 null,
            "fileName" :                 null,
            "focusOnStaves" :            null,
            "partName" :                 null,
            "scoreDuration" :            null,
            "systemStaff" :              "Staff",
            "title" :                    null,
            "transposingScore" :         null
        }
    },
    
    "Staff" : {
        "iterators" : {
            "getBars" :                  [ null, "Bar" ]
        },
        "methods" : {
        },
        "fields" : {
            "barCount" :                 null,
            "channel" :                  null,
            "distance" :                 null,
            "fullInstrumentName" :       null,
            "isSystemStaff" :            null,
            "muteMode" :                 null,
            "solo" :                     null,
            "parentScore" :              "Score",
            "staffNum" :                 null,
            "volume" :                   null
        }
    },
    
    "Tuplet" : {
        "iterators" : {
        },
        "methods" : {
            "addNestedTuplet" :          "Tuplet",
            "addNote" :                  null
        },
        "fields" : {
            "bracket" :                  null,
            "fullDuration" :             null,
            "left" :                     null,
            "parentTupletIfAny" :        null,
            "playedDuration" :           null,
            "positionInTuplet" :         null,
            "right" :                    null,
            "style" :                    null,
            "text" :                     null,
            "unit" :                     null
        }
    },
    
    // External tools
    
    "ScoreWriter" : {
        "iterators" : {
        },        
        "methods" : {
            "version" : null,
            "write" : null,
            "closeAll" : null
        },
        "fields" : {
        }
    }
}




// ======================================================================
// TODO

var LilyPondWriter  = function(){};

var MusicXMLWriter  = function(){};

var MIDIWriter      = function(){};


// ======================================================================

exports.add ( 
  trace,
  getSibelius,
  getGlobal,
  addBindListener,
  removeBindListener,
  fileChanged,
  setFileMonitoring,
  isSynchronized,
  isSynchronizedSinceStartup,
  getSynchronizationTime,
  getPendingMessages,
  notifyFileListeners,
  notifyBindListeners,
  Proxy,
  Socket,  
  types,
  getBind, getSynchronize, getReceive, getSend,
  
  SibeliusWriter, LilyPondWriter, MusicXMLWriter, MIDIWriter, wait );