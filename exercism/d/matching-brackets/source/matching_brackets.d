module matching_brackets;

@safe pure bool isPaired(string brackets)
{
    import std.container : SList;
    import std.algorithm.searching : find;
    import std.container.array;
    import std.range;

    immutable OPENING_BRACKETS = ['(', '{', '['];
    immutable CLOSING_BRACKETS = [')', '}', ']'];
    immutable MATCHING_BRACKETS = ['(': ')', '{': '}', '[': ']'];
    auto bracketsStack = SList!char();
    foreach (elt; brackets)
    {
        if (!OPENING_BRACKETS.find(elt).empty())
        {
            bracketsStack.insertFront(MATCHING_BRACKETS[elt]);
        }
        else if (!CLOSING_BRACKETS.find(elt).empty() && !bracketsStack.empty() && elt == bracketsStack.front())
        {
            bracketsStack.removeFront();
        }
        else if (!CLOSING_BRACKETS.find(elt).empty() && (bracketsStack.empty() || elt != bracketsStack.front()))
        {
            return false;
        }
    }
    return bracketsStack.empty();
}

unittest
{
    immutable int allTestsEnabled = 1;

    // Paired square brackets
    assert(isPaired("[]"));

    static if (allTestsEnabled)
    {
        // Empty string
        assert(isPaired(""));

        // Unpaired brackets
        assert(!isPaired("[["));

        // Wrong ordered brackets
        assert(!isPaired("}{"));

        // Wrong closing bracket
        assert(!isPaired("{]"));

        // Paired with whitespace
        assert(isPaired("{ }"));

        // Partially paired brackets
        assert(!isPaired("{[])"));

        // Simple nested brackets
        assert(isPaired("{[]}"));

        // Several paired brackets
        assert(isPaired("{}[]"));

        // Paired and nested brackets
        assert(isPaired("([{}({}[])])"));

        // Unopened closing brackets
        assert(!isPaired("{[)][]}"));

        // Unpaired and nested brackets
        assert(!isPaired("([{])"));

        // Paired and wrong nested brackets
        assert(!isPaired("[({]})"));

        // Paired and incomplete brackets
        assert(!isPaired("{}["));

        // Too many closing brackets
        assert(!isPaired("[]]"));

        // Math expression
        assert(isPaired("(((185 + 223.85) * 15) - 543)/2"));

        // Complex latex expression
        assert(isPaired(
                "\\left(\\begin{array}{cc} \\frac{1}{3} & x\\\\ \\mathrm{e}^{x} &... x^2 \\end{array}\\right)"));
    }
}
