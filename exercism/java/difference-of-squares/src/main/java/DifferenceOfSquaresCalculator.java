class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int sum =((1 + input) * input) / 2;
        return  sum * sum;
    }

    /**
     * https://www.trans4mind.com/personal_development/mathematics/series/sumNaturalSquares.htm
     * @param input
     * @return
     */
    int computeSumOfSquaresTo(int input) {
        return (input * (input + 1) * (2 * input + 1)) / 6;
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
