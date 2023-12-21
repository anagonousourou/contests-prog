/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function(fn) {
    result = {}
    for (const elt of this) {
        if(result[fn(elt)] === undefined){
            result[fn(elt)] = [elt]
        }else{
            result[fn(elt)].push(elt);
        }
    }
    return result;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */