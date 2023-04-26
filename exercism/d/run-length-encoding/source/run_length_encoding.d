module run_length_encoding;

string encode(string input)
{
    import std.conv : to;
    import std.array : join;
    import std.range;

    if (input.empty())
    {
        return input;
    }
    char currentChar = input[0];
    auto currentCounter = 1U;
    string[] results;

    for (int i = 1; i < input.length; i++)
    {
        if (currentChar == input[i])
        {
            currentCounter += 1;
        }
        else
        {
            if (currentCounter > 1)
            {
                results ~= currentCounter.to!string;
            }
            results ~= currentChar.to!string;
            currentChar = input[i];
            currentCounter = 1;
        }
    }
    if (currentCounter > 1)
    {
        results ~= currentCounter.to!string;
    }
    results ~= currentChar.to!string;
    return results.join();

}

string decode(string input)
{
    import std.regex : regex, matchAll;
    import std.array : array, appender, join;
    import std.algorithm : map;
    import std.string : isNumeric;
    import std.range : repeat;
    import std.conv : to;

    auto partsRegex = r"\d+|\s+|[a-zA-z]".regex();

    auto tokens = input.matchAll(partsRegex).map!(a => a[0]).array();
    auto result = appender!string;
    foreach (i, token; tokens)
    {
        if (token.isNumeric())
        {
            auto tokenValue = token.to!int;
            result.put(tokens[i + 1].repeat(tokenValue - 1).join());
        }
        else
        {
            result.put(token);

        }

    }
    return result.data();
}

unittest
{
    immutable int allTestsEnabled = 0;

    // Run-length encode a string

    // Empty string
    assert(encode("") == "");
    // Single characters only are encoded without count
    assert(encode("XYZ") == "XYZ");

    // String with no single characters
    assert(encode("AABBBCCCC") == "2A3B4C");

    // Single characters mixed with repeated characters
    assert(encode("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB") == "12WB12W3B24WB");

    // Multiple whitespace mixed in string
    assert(encode("  hsqq qww  ") == "2 hs2q q2w2 ");

    // Lowercase characters
    assert(encode("aabbbcccc") == "2a3b4c");

    // Sun-length decode a string

    // Empty string
    assert(decode("") == "");

    // String with no single characters
    assert(decode("XYZ") == "XYZ");

    // Single characters with repeated characters
    assert(decode("2A3B4C") == "AABBBCCCC");

    // Multiple whitespace mixed in string
    assert(decode("12WB12W3B24WB") == "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB");

    // Multiple whitespace mixed in string
    assert(decode("2 hs2q q2w2 ") == "  hsqq qww  ");

    // Lower case string
    assert(decode("2a3b4c") == "aabbbcccc");

    // Encode and then decode

    // Encode followed by decode gives original string
    assert("zzz ZZ  zZ".encode.decode == "zzz ZZ  zZ");
    static if (allTestsEnabled)
    {

    }
}
