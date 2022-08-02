/**
 * Implement the solution in this function
 *
 * @param {string} m The first binary string.
 * @param {string} n The second binary string.
 * @returns {string} The sum of binary numbers in string format.
 */
function binaryAdd(m, n) {
    return nextDigit(m, n, 0);
}
/** 
* @param {string} remainingA The first binary string.
* @param {string} remainingB The second binary string.
* @param {number} retenue 
*/
function nextDigit(remainingA, remainingB, retenue) {
    //si les deux nombres on la même longueur
    if (remainingA.length === 0 && remainingB.length === 0) {
        if (retenue !== 0) {
            return `${retenue}`;
        } else {
            return '';
        }
    }
    //vers la fin si un des nombre est plus long que l'autre
    else if ((remainingA.length === 0 && remainingB.length !== 0)) {
        return nextDigit(remainingB, `${retenue}`, 0);
    }
    else if ((remainingA.length != 0 && remainingB.length === 0)) {
        return nextDigit(remainingA, `${retenue}`, 0);
    }
    let a = parseInt(remainingA.charAt(remainingA.length - 1));
    let b = parseInt(remainingB.charAt(remainingB.length - 1));
    //cas général
    if (a + b + retenue === 1) {
        return nextDigit(remainingA.substring(0, remainingA.length - 1), (remainingB.substring(0, remainingB.length - 1)), 0) + '1';
    } else if (a + b + retenue === 0) {
        return nextDigit(remainingA.substring(0, remainingA.length - 1), (remainingB.substring(0, remainingB.length - 1)), 0) + '0';
    }
    else if (a + b + retenue === 2) {
        return nextDigit(remainingA.substring(0, remainingA.length - 1), (remainingB.substring(0, remainingB.length - 1)), 1) + '0';
    }
    else if(a+b+retenue === 3){
        return nextDigit(remainingA.substring(0, remainingA.length - 1), (remainingB.substring(0, remainingB.length - 1)), 1) + '1';
    }
}