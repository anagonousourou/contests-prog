module perfect_numbers;

enum Classification
{
    DEFICIENT,
    PERFECT,
    ABUNDANT
}

Classification classify(int n)
{
    if (n <= 0)
    {
        throw new Exception("Need parameter > 0");
    }
    int s = factors_sum(n);

    if (s == n)
    {
        return Classification.PERFECT;
    }
    else if (s < n)
    {
        return Classification.DEFICIENT;
    }
    else
    {
        return Classification.ABUNDANT;
    }
}

uint factors_sum(uint n)
{
    import std.algorithm;
    import std.range;

    return iota(1, (n / 2) + 1).filter!(a => n % a == 0).sum();
}

unittest
{
    import std.exception : assertThrown;

    immutable int allTestsEnabled = 1;

    // Perfect numbers

    // Smallest perfect number is classified correctly
    assert(classify(6) == Classification.PERFECT);

    // Medium perfect number is classified correctly
    assert(classify(28) == Classification.PERFECT);

    // Large perfect number is classified correctly
    assert(classify(33_550_336) == Classification.PERFECT);

    static if (allTestsEnabled)
    {
        // Abundant numbers

        // Smallest abundant number is classified correctly
        assert(classify(12) == Classification.ABUNDANT);

        // Medium abundant number is classified correctly
        assert(classify(30) == Classification.ABUNDANT);

        // Large abundant number is classified correctly
        assert(classify(33_550_335) == Classification.ABUNDANT);

        // Deficient numbers

        // Smallest prime deficient number is classified correctly
        assert(classify(2) == Classification.DEFICIENT);

        // Smallest non-prime deficient number is classified correctly
        assert(classify(4) == Classification.DEFICIENT);

        // Medium deficient number is classified correctly
        assert(classify(32) == Classification.DEFICIENT);

        // Large deficient number is classified correctly
        assert(classify(33_550_337) == Classification.DEFICIENT);

        // Edge case (no factors other than itself) is classified correctly
        assert(classify(1) == Classification.DEFICIENT);

        // Invalid inputs

        // Zero is rejected (not a natural number)
        assertThrown(classify(0));

        // Negative integer is rejected (not a natural number)
        assertThrown(classify(-1));
    }

}
