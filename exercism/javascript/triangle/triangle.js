//
// This is only a SKELETON file for the 'Triangle' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

/**
 * 
 * @param {number[]} sides 
 */
function isTriangle(sides) {
  if (sides.some(n => n <= 0)) {
    return false;
  }
  const sidesSum = sides.reduce((a, b) => a + b, 0);
  return sides.every(n => sidesSum - n >= n);
}
export class Triangle {
  constructor(...sides) {
    this.sides = sides;
  }

  get isEquilateral() {
    return isTriangle(this.sides) && this.sides.every(side => side === this.sides[0]);
  }

  get isIsosceles() {
    return isTriangle(this.sides) && (this.sides[0] === this.sides[1] || this.sides[1] === this.sides[2] ||
      this.sides[0] === this.sides[2]);
  }

  get isScalene() {
    return isTriangle(this.sides) && !this.isIsosceles;
  }
}
