import 'dart:math';

class DifferenceOfSquares {
  int squareOfSum(int n) {
    return pow((((1 + n) * n) ~/ 2), 2) as int;
  }

  int sumOfSquares(int n) {
    return (n * (n + 1) * (2 * n + 1)) ~/ 6;
  }

  int differenceOfSquares(int n) {
    return squareOfSum(n) - sumOfSquares(n);
  }
}
