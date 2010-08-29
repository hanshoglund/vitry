/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */

// Some utilities for exports and require

//FIXME still only works for core
Object.defineProperty(
  exports,
  "add", 
  {
    value : function() { 
      var parent;
      var supplied = [];      
      for each (a in arguments) {
        supplied.push(a);
      }
      parent = supplied.reduce(
        (function(p, v) p || v.__parent__), null);
                
      Object.keys(parent).
      filter(function(k) supplied.indexOf(parent[k]) >= 0).
      forEach(function(k) {    
        exports[k] = parent[k];
      });        
    }
  }
);

Object.defineProperty(
  exports,
  "addAll", 
  {
    value : function(from) {
      for (k in from) exports[k] = from[k];
    }
  }
);