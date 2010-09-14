
/**
 * A simple break-point-function.                                      
 *
 * FIXME Only works for 0 < x < 1.
 *
 * @param list
 *   Even indices are y, odd are delta x.
 *   Example [0, 0, 10, 1] y goes from 0 to 10 where x goes from 0 to 1.
 */
function BPF(list) {
  this.list = list;
  this.y = [list[k] for (k in list) if (k % 2 === 0)];
  this.x = [list[k] for (k in list) if (k % 2 !== 0)];
}

Object.extend(BPF, {
  parse : function (str) {
    var code = "[" + str.replace(" ", ",", "g") + "]";                  
    return new BPF(JSON.parse(code));
  }
});

BPF.prototype = {
  get : function(search) {
    if (search <= 0) {
      return this.y[0];
    } else if (search > 1) {
      return this.y[this.y.length - 1];
    } else {
      let _;
      let i;
      let p;
      [_,_,i,p] = this.x.reduce(function([index, offset, vIndex, vPos], delta) {
        let pos = offset + delta;
        let bp = (pos > search);
// print([index,pos,value,delta]);
        return [index + 1, pos, bp ? vIndex : index, bp ? vPos : pos];
      },
      [0, 0, 0, 0]);
// print([i,p]);       
      let x = this.x;
      let y = this.y;

      if (i + 1 === y.length) {
        // Last element
        return y[y.length - 1];
      } else {
        return y[i] + (y[i+1] - y[i]) * (search - p) / x[i+1];
      }
    }      
  }
}

//======================================================================

exports.add ( BPF );