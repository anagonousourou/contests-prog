/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n, currentDepth = 0) {
    let result = [];
    for (const elt of arr) {
        if(Array.isArray(elt) && currentDepth < n){
           result.push(...flat(elt, n, currentDepth + 1));
        }else{
            result.push(elt);
        }
    }
    return result;
};

