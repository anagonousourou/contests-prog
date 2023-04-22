module hamming;

uint distance(string dna1, string dna2)
{
    if (dna1.length != dna2.length)
    {
        throw new Exception("distance not defined for dna of different length");
    }
    uint d = 0;
    foreach (i, nucleotide; dna1)
    {
        d += nucleotide != dna2[i] ? 1 : 0;
    }
    return d;
}

unittest
{
    import std.exception : assertThrown;

    immutable int allTestsEnabled = 1;

    // Empty strands
    assert(distance("", "") == 0);

    static if (allTestsEnabled)
    {
        // Single letter identical strands
        assert(distance("A", "A") == 0);

        // Single letter different strands
        assert(distance("G", "T") == 1);

        // Long identical strands
        assert(distance("GGACTGAAATCTG", "GGACTGAAATCTG") == 0);

        // Long different strands
        assert(distance("GGACGGATTCTG", "AGGACGGATTCT") == 9);

        // Disallow first strand longer 
        assertThrown(distance("AATG", "AAA"));

        // Disallow second strand longer
        assertThrown(distance("AAA", "AGTG"));

        // Disallow left empty strand
        assertThrown(distance("", "G"));

        // Disallow right empty strand
        assertThrown(distance("G", ""));
    }

}
