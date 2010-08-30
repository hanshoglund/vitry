/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */

/** 
 * Utility functions for the module system.
 * 
 * Pre-core, only standard JavaScript here.
 */
 
(function() {

  Object.defineProperties(
    exports,
    {
      /*
       * Adds all the specified values to the exports object. All given values must
       * be defined in the same lexical context, or this method will throw an error.
       */
      "add" : {     
        value : function() {
          var parent;       
          var supplied = [];
        
          Array.prototype.push.apply(supplied, arguments);
          parent = supplied.reduce((function(p, v) p || getParent(v)), null);

          if (parent) {
            Object.keys(parent).
            filter(function(k) supplied.indexOf(parent[k]) >= 0).
            forEach(function(k) {
              exports[k] = parent[k];
            });
          }
        }
      },
        
      /*
       * Adds all given values, using the given names. This method accepts an enumerable
       * object and copies its names and values to the exports object.
       */
      "addNamed" : {
        value : function(from) {
          for (k in from) exports[k] = from[k];
        }
      }
    }
  );

  function getParent(obj) {
    return obj.__parent__;
  }  
  
}());