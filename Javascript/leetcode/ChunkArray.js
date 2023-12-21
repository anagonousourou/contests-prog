/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function(arr, size) {
    let result = [];

    let currentChunk = [];
    for (const element of arr) {
        currentChunk.push(element);
        
        if(currentChunk.length == size){
            result.push(currentChunk);
            currentChunk = [];
        }
        
    }
    if(currentChunk.length !== 0){
        result.push(currentChunk);
    }
    return result;
    
};
