/**
 * Implement the solution in this function
 *
 * @param {number} d The distance in centimeters. It will be a multiplier of 5.
 * @returns {number} The number of ways the frog can move that distance
 */
function jumpingFrog(d) {
    return hop(d)+jump(d);
}

function hop(d) {
    d -= 5;
    if (d === 0) {
        return 1;
    } else if (d > 0) {
        return hop(d) + jump(d);
    }
    else { //d < 0
        return 0;
    }
}
function jump(d) {
    d-=10;
    if(d ===0){
        return 1;
    }
    else if( d> 0){
        return hop(d)+jump(d);
    }
    else{
        return 0;
    }
}
let t1 = new Date().getTime()
console.log(jumpingFrog(200))
console.log(new Date().getTime()-t1, 'milliseconds')
t1 = new Date().getTime()
console.log(jumpingFrog(215))
console.log(new Date().getTime()-t1, 'milliseconds')