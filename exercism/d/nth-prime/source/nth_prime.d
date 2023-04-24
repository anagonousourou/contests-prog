module nth_prime;

int prime(int n)
in
{
    if (n <= 0)
    {
        throw new Exception("parameter must be superior to zero.");
    }
}
do
{
    import std.range;
    import std.algorithm;

    /*int counter = 0;
    for (int i = 2;; i++)
    {
        if (isPrime(i))
        {
            counter++;
        }
        if (counter == n)
        {
            return i;
        }
    }*/
    auto naturalNumbers = recurrence!((a, i) => i)(0);
    return naturalNumbers.filter!isPrime().take(n).drop(n - 1).front();
}

bool isPrime(long n)
{
    import std.math : sqrt;

    if (n <= 1)
    {
        return false;
    }
    int limit = cast(int) sqrt(cast(float) n);
    for (int i = 2; i <= limit; i++)
    {
        if (n % i == 0)
        {
            return false;
        }
    }
    return true;
}

unittest
{
    import std.exception : assertThrown;

    immutable int allTestsEnabled = 1;

    // First prime
    assert(prime(1) == 2);

    static if (allTestsEnabled)
    {
        // Second prime
        assert(prime(2) == 3);

        // Sixth prime
        assert(prime(6) == 13);

        // Big prime
        assert(prime(10_001) == 10_4743);

        // There is no zeroth prime
        assertThrown(prime(0));
    }

}
