//https://leetcode.com/problems/memoize/

/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    let known = new Map();

    return function(...args) {
       let key = args.join(',') ;
       if(known.has(key)){
        return known.get(key);
       }else{
        let result = fn(...args);
        known.set(key, result);
        return result;
       }
    }
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */