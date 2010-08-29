/*
 * Vitry, copyright (c) Hans Höglund 2010, see COPYING.txt for details
 */  
 
Object.defineProperty(exports, "addAll", {
  set : function (from) {
    for (k in from) exports[k] = from[k];
  }
});