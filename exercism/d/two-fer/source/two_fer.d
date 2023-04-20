module two_fer;

string twoFer(string name = "you")
{
    import std.string;

    return format("One for %s, one for me.", name);
}

unittest
{
    immutable int allTestsEnabled = 1;

    // No name given
    assert(twoFer() == "One for you, one for me.");

    static if (allTestsEnabled)
    {
        // A name given
        assert(twoFer("Alice") == "One for Alice, one for me.");

        // Another name given
        assert(twoFer("Bob") == "One for Bob, one for me.");
    }

}
