module grains;

ulong square(int s)
{
    if (1 <= s && s <= 64)
    {
        return 2uL ^^ (s - 1);
    }
    else
    {
        import std.string;

        throw new Exception(format("Invalid value %s", s));

    }

}

ulong total()
{
    return (2uL ^^ 64) - 1;
}

unittest
{
    import std.exception : assertThrown;

    immutable int allTestsEnabled = 1;

    // Returns the number of grains on the square
    assert(square(1) == 1);

    static if (allTestsEnabled)
    {
        assert(square(2) == 2);
        assert(square(3) == 4);
        assert(square(4) == 8);
        assert(square(16) == 32_768);
        assert(square(32) == 2_147_483_648uL);
        assert(square(64) == 9_223_372_036_854_775_808uL);

        // Square 0 raises an exception
        assertThrown(square(0));

        // Negative square raises an exception
        assertThrown(square(-1));

        // Square greater than 64 raises an exception
        assertThrown(square(65));

        // Returns the total number of grains on the board
        assert(total() == 18_446_744_073_709_551_615uL);
    }
}
