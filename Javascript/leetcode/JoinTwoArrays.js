/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    const dict1 = new Map();
    for (const elt of arr1) {
        dict1.set(elt.id, elt);
    }

    const dict2 = new Map();
    for (const elt of arr2) {
        dict2.set(elt.id, elt);
    }

    const result = [];
    for(const key of dict1.keys()){
        if(!dict2.has(key)){
            result.push(dict1.get(key));
        }
    }

    for(const key of dict2.keys()){
        result.push(Object.assign(dict1.get(key) ?? {},dict2.get(key)));
    }

    result.sort((a, b) => a.id - b.id);

    return result;
};