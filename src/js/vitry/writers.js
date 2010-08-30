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

// synchronizeScript = getNormalizedPath() +
// "sibelius/sync.applescript";

var files = {
  bind :            "bind",
  synchronize :     "synchronize",
  receive :         "receive",
  send :            "send"
}

var referencePrefix       = "sibobj_";

// Cached global objects.
var globals               = [];

// Listeners and taks
var fileMonitorTask       = null;
var fileMonitorInterval   = 80;
var scriptingBindListener = null;

var startTime             = new Date();
var sendTime              = null;
var synchronizationTime   = null;

var sentMessagesCount     = 0;
var receivedMessagesCount = 0;

var fileListeners         = [];
var bindListeners         = [];
var notifyFileListeners   = null;
var notifyBindListeners   = null;

var defaultAddressPart  = "vitry";
var defaultSocketPrefix = "socket";
var defaultSocketsCount = 0;
var defaultReceiver     = function(){};

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
  return getGlobal(
    /* name */ "Sibelius",
    /* type */ "Sibelius");
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
  if (!globals.hasOwnProperty[name]) {
      globals[name] = new Proxy(name, type);
  }
  return globals[name];
}

/**
 * Adds a listener for bind events. This can be used to trigger a synchronize
 * event in Sibelius automatically using any platform-dependent means.
 */
function addBindListener(event) {
  var pos = bindListeners.indexOf(event);
  if (pos < 0) 
    bindListeners.push(event);
}

/**
 * Removes the given bind listener.
 */
function removeBindListener(event) {
  var pos = bindListeners.indexOf(event);
  if (pos >= 0)
    delete bindListeners[poss];
}

/**
 * Notifies receivers of a change in the synchronize file.
 */
function fileChanged() {
  if (this.isSynchronized())
    notifyFileListeners();
}

/**
 * Enable or disable file monitoring.
 */
function setFileMonitoring(state) {
  // FIXME Max Task
  if (state) {
    if (!fileMonitorTask) {
      fileMonitorTask = new Task(function() {
        fileChanged();
      });
      fileMonitorTask.interval = fileMonitorInterval;
    }
    fileMonitorTask.repeat(-1, fileMonitorInterval);
  } else {
    fileMonitorInterval.cancel();
  }
}


function useSynchronizeScript(status) {
// FIXME depends Shell
  var stdIn;

  if (status) {
    stdIn = new Shell().getInputStream()
    scriptingBindListener = function() {
        // Echo to prevent "no output" message
        stdIn("osascript " + synchronizeScript)
    }
    addBindListener(scriptingBindListener)
  } else {
    removeBindListener(scriptingBindListener)
  }
}

/**
 * Returns true if Sibelius has been synchronized to Max at least once since the
 * latest message was transmitted.
 */
function isSynchronized() {
  return sendTime !== null &&
    sendTime < this.getSynchronizationTime();
}

/**
 * Returns true if Sibelius has been synchronized to Max at least once since
 * startup time.
 */
function isSynchronizedSinceStartup() {
  return startTime < this.getSynchronizationTime();
}

/**
 * Returns the last time Sibelius were synchronized to Max.
 *
 * @returns time of last response.
 * @type Date
 */
function getSynchronizationTime() {

  // TODO Should not reopen file for each invocation, just reset position

  var d = new Date();
  var f;
  var fin;

  if (d > synchronizationTime) {
    f = getSynchronizeFile();

    try {
      fin = f.readline();
      d.setISO8601(fin);
    } catch (e) {
      // Could not parse date, usually because it is still
      // being written
      return synchronizationTime;
    }

    // Sibelius writes local date, but Max reads UTC
    // Compensate by adding UTC offset
    d.setMinutes(d.getMinutes() + d.getTimezoneOffset());
    synchronizationTime = d;
  } else {
    return synchronizationTime;
  }

  f.close();
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

function getBindFile() {
  var name = vitry.music.setup.sibelius.socketDir + "/" + files.bind;
  return openFile(name, "readwrite", "Could not open bind file");
}

function getSynchronizeFile() {
    var name = vitry.music.setup.sibelius.socketDirectory + "/" + files.synchronize;
    return openFile(name, "read", "Could not open synchronization file");
}

function getReceiveFile(address) {
    var name = vitry.music.setup.sibelius.socketDirectory + "/" +
            address + "_" + files.receive,
        msg = "Could not open receive file on address " + address;
    return openFile(name, "write", msg);
}

function getSendFile(address) {
    var name = vitry.music.setup.sibelius.socketDirectory + "/" +
            address + "_" + files.send,
        msg = "Could not open send file on address " + address;
    return openFile(name, "read", msg);
}

function openFile(name, mode, errorMessage) {
  // FIXME Depends on MAx
    var f = new File(name, mode);
    if (f.isopen) {
        return f;
    }
    throw new Error(errorMessage || "Could not open file");
}




/**
 * Represents a Sibelius dictionary
 * @param obj
 *   Object whose properties to copy.
 */
function Dictionary(obj) {
  this.extend(obj);
}


/**
 * A message expression.
 * @param object
 *   {String} Name of object.
 * @param method
 *   {Strign} Name of method.
 * @param args
 *   {Array}
 */
function Expression(object, method, args) {
  
  /**
   * Returns the string representation of this message.
   */
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
 * <p>
 * Methods can be called directly using the call method. Fields and iterators
 * can be queried directly using the set, get and iterate methods.
 * </p>
 *
 * <p>
 * Each method may return a primitive value, an array or another proxy object.
 * </p>
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

  var that    = this;

  if (!socket) {
      socket = new Socket();
  }

  // Add proxy methods, including getters, setters and iterators
  /*
   * Adds proxy methods, including getters, setters and iterators to the Proxy
   * object being constructed. <p> Each proxy method will call either call,
   * set, get or iterate. </p>
   */
  (function () {
    var typeDescr = types[type];
    var method;
    var field;

    if (typeDescr) {
      for (method in typeDescr.methods) {
        (function () {
          var sibName = toSibeliusName(method);
          var type    = typeDescr.methods[method];
          var method  = function () {
            var args  = parseArgs(arguments);
            var cont  = extractContinuation(args);
            return that.call(sibName, type, args, cont);
          }
          that[method]  = method;
          that[sibName] = method;
        }());
      }

      for (field in typeDescr.fields) {
        (function() {
          var sibName  = toSibeliusName(field);
          var setter   = "set" + sibName;
          var getter   = "get" + sibName;
          var type     = typeDescr.fields[field];
          that[setter] = function (value, cont) {
            return that.set(sibName, value, cont);
          }
          that[getter] = function (cont) {
            return that.get(sibName, type, cont);
          }
        }()); 
      }  
      // FIXME support iterators
    }       
  }());

  // The call, get set and iterate methods can be used to access any
  // member on the underlying object. The proxy methods are convenient
  // wrappers that call these methods.

  // Each of these methods may take and return objects (Proxy instances)
  // or JavaScript arrays.

  /**
   * Calls the given method on this object.
   *
   * <p>
   * If a continuation function is passed, the result is passed as the first
   * argument to that function, otherwise it is returned.
   * </p>
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
    msg = "(" + this.object + "," + name;
    for (var i in args) {
      if (args.hasOwnProperty(i)) {
        msg += "," + processArgument(args[i]);
      }
    }
    msg += ")";
    return send(msg, type, cont);
  }

  /**
   * Set the given field of this object to the given value. If the given field
   * is not modifiable, this method does nothing.
   * <p>
   * Setting fields may imply effects in Sibelius, see the original
   * documentation.
   * </p>
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
          msg += "(,array,";
          last = value.length - 1;
          for (i = 0; i < last; i++) {
              msg += unparse(value[i]);
              msg += ",";
          }
          msg += unparse(value[last]);
          msg += ")";

      } else if (typeof value === "object") {

          if ((value !== null) &&
              (typeof value.serialize === "function")) {
              msg += unparse(value.serialize());

          } else {
              msg += "(,dictionary,";
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
          msg = escape(String(value));
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
  if (str === "trace")
    return str;
  else
    return str.substr(0, 1).toUpperCase() + str.substr(1);
}

/*
 * Returns the given string with the special characters '(', ',', ')' and '\'
 * escaped by '\'.
 */
function escape(str) {
  return str.replace(/([(,)\\])/g, "\\$1");
}








/**
 * @class A socket communicating with Sibelius.
 *        <p>
 *        Socket objects read and write messages in text format. The expression
 *        syntax defined by the Sibelius API plugin is supported for sent
 *        messages. Received messages may contain object references array
 *        expressions, and escaped strings.
 *        </p>
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
  this.address    = address || (defaultAddressPart + "_" + defaultSocketPrefix + (defaultSocketsCount++));
  
  /**
   * Called whenever a message is received in non-blocking mode.
   */
  this.receiver = receiver || defaultReceiver;
  
  /**
   * If true, the send and listen methods will block until the synchronize file
   * has been updated.
   */
  this.blocking = blocking || false;
  
  /**
   * Timeout in milliseconds. Only applies if this socket is in blocking mode.
   */
  this.timeOut    = timeOut    || 3200;
  
  /**
   * Interval in milliseconds.
   */
  this.interval = 30;  
    
    
  /**
   * Sends the given messages.
   *
   * <p>
   * If this socket is in blocking mode, this method does not return until a
   * response has been received. If the timeout is exceeded, this method throws an
   * error.
   * </p>
   * <p>
   * If this socket is in non-blocking mode, this method returns directly. Any
   * response message will be passed to the receiver function.
   * </p>
   *
   * @param msg
   *          A message string, or an array of message strings.
   */   
  this.send = function (msg) {
    internal.sibelius.sendTime = new Date();
    ++internal.sibelius.sentMessagesCount;

    // Write message to socket, then create binding
    write(msg);
    bind();

    return accept();
  }  
    
  /**
   * Listen for an incoming message.
   * <p>
   * If this socket is in blocking mode, it will return the first received
   * message. If the timeout is exceeded, it throws an error.
   * </p>
   * <p>
   * If this socket is in non-blocking mode, incoming messages will be passed to
   * the receiver function.
   * </p>
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
      ++internal.sibelius.receivedMessagesCount;
      return read();
    } else {
      internal.sibelius.fileListeners.push(function () {
          ++internal.sibelius.receivedMessagesCount;
          that.receiver.call(that, read());
      });
    } 
  }   
    
  /*
   * Binds this socket to be read by Sibelius.
   */
  function bind() {
    // @depends Max uses Max file object
    //TODO Should not reopen file for each invocation, just reset position
    var f = internal.sibelius.getBindFile();

    f.position = f.eof;
    f.writeline(that.address);

    internal.sibelius.notifyBindListeners();
    f.close();
  }     
    
  /*
   * Reads a message from this socket.
   */
  function read() {
    // @depends Max uses Max file object
    var f = internal.sibelius.getSendFile(that.address);
    var msg = f.readline();
    f.close();
    return msg;
  }   
     
  /*
   * Writes the given message, or array of messages, to this socket.
   */
  function write(msg) {
    var f = internal.sibelius.getReceiveFile(that.address);
    var i;
    // @depends Max uses Max file object
    // XXX f.position = 0;
    if (typeof msg === "object") {
      for (i in msg) {
        if (msg.hasOwnProperty(i)) {
          f.writeline(msg[i]);
        }  
      }      
    } else {
      f.writestring(msg);
    }
    f.eof = f.position;
    f.close();   
  }
    
  /*
   * Blocks for the given duration (in milliseconds).
   */
  function wait(time) {
    // TODO
  }     
}





// ======================================================================
// TODO

var LilyPondWriter  = function(){};
var MusicXMLWriter  = function(){};
var MIDIWriter      = function(){};


// ======================================================================

exports.add ( SibeliusWriter, LilyPondWriter, MusicXMLWriter, MIDIWriter);