module series;

import std.algorithm.comparison : equal;

int[] digits(string input)
in
{
    import std.algorithm : any;
    import std.ascii : isDigit;

    if (input.any!(a => !a.isDigit()))
    {
        throw new Exception("Invalid input, there is a non-digit");
    }
}
do
{
    import std.algorithm : map;
    import std.array : array;

    return input.map!(a => cast(int) a - '0').array;

}

int[][] slice(string input, int offset)
in
{
    import std.algorithm : any;
    import std.ascii : isDigit;

    if (offset > input.length)
    {
        throw new Exception("Offset superior to input length");
    }
    if (input.any!(a => !a.isDigit()))
    {
        throw new Exception("Invalid input, there is a non-digit");
    }
}
do
{

    int[][] results;
    auto digs = digits(input);
    for (size_t i = 0; i <= digs.length - offset; i++)
    {
        results ~= digs[i .. i + offset].dup;
    }
    return results;

}

unittest
{
    import std.exception : assertThrown;

    immutable int allTestsEnabled = 0;

    // short_digits
    {
        const int[] expected = [0, 1, 2, 3, 4, 5];
        const int[] actual = digits("012345");

        assert(equal(actual, expected));
    }

    // long_digits
    {
        const int[] expected = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
        const int[] actual = digits("0123456789");

        assert(equal(actual, expected));
    }

    // keeps_the_digit_order_if_reversed
    {
        const int[] expected = [9, 8, 7, 6, 5, 4, 3, 2, 1, 0];
        const int[] actual = digits("9876543210");

        assert(equal(actual, expected));
    }

    // keeps_arbitrary_digit_order
    {
        const int[] expected = [9, 3, 6, 9, 2, 3, 4, 6, 8];
        const int[] actual = digits("936923468");

        assert(equal(actual, expected));
    }

    // can_slice_by_1
    {
        const int[][] expected = [[0], [1], [2], [3], [4]];
        const int[][] actual = slice("01234", 1);

        assert(equal(actual, expected));
    }

    // can_slice_by_2
    {
        const int[][] expected = [
            [9, 8], [8, 2], [2, 7], [7, 3], [3, 4], [4, 6], [6, 3]
        ];
        const int[][] actual = slice("98273463", 2);

        assert(equal(actual, expected));
    }

    // can_slice_by_3
    {
        const int[][] expected = [[0, 1, 2], [1, 2, 3], [2, 3, 4]];
        const int[][] actual = slice("01234", 3);

        assert(equal(actual, expected));
    }

    // can_slice_by_3_with_duplicate_digits
    {
        const int[][] expected = [[3, 1, 0], [1, 0, 0], [0, 0, 1]];
        const int[][] actual = slice("31001", 3);

        assert(equal(actual, expected));
    }

    // can_slice_by_4
    {
        const int[][] expected = [[3, 1, 0], [1, 0, 0], [0, 0, 1]];
        const int[][] actual = slice("31001", 3);

        assert(equal(actual, expected));
    }

    // can_slice_by_5
    {
        const int[][] expected = [[8, 1, 2, 2, 8]];
        const int[][] actual = slice("81228", 5);

        assert(equal(actual, expected));
    }

    // exception_if_not_enough_digits_to_slice
    {
        assertThrown(slice("01032987583", 12));
    }

    // exception_if_invalid_input
    {
        assertThrown(slice("01032i987583", 12));
    }

    // exception_if_invalid_input_2
    {
        assertThrown(digits("01032i987583"));
    }
    static if (allTestsEnabled)
    {

    }

}
