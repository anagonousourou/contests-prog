module difference_of_squares;

struct Result
{
    ulong squareOfSum;
    ulong sumOfSquares;
    long difference;
}

Result squares(int n){
    auto squareOfSum = ((1 + n) * n / 2) ^^ 2;
    auto sumOfSquares = (n * (n + 1) * (2 * n + 1)) / 6;
    return Result(squareOfSum, sumOfSquares, squareOfSum - sumOfSquares);
}


unittest
{
    immutable int allTestsEnabled = 1;

    // Square of sum 1
    assert(squares(1).squareOfSum == 1);

    static if (allTestsEnabled)
    {
        // Square of sum 5

        assert(squares(5).squareOfSum == 225);

        // Square of sum 100
        assert(squares(100).squareOfSum == 25_502_500);

        // Sum of squares 1
        assert(squares(1).sumOfSquares == 1);

        // Sum of squares 5
        assert(squares(5).sumOfSquares == 55);

        // Sum of squares 100
        assert(squares(100).sumOfSquares == 338_350);

        // Difference of squares 100
        assert(squares(100).difference == 25_164_150);
    }

}
