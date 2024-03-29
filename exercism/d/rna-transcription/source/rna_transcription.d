module rna_transcription;


string toRna(string dna){
    import std.algorithm.iteration: map;
    import std.array: join;
    immutable string[dchar] dnaToRna = ['G': "C", 'C': "G", 'T': "A", 'A': "U"];
    return dna.map!(a =>  dnaToRna[a]).join();
}

unittest
{
    import std.exception : assertThrown;

    immutable int allTestsEnabled = 1;

    // Empty RNA sequence
    assert(toRna("") == "");

    static if (allTestsEnabled)
    {
        // RNA complement of cytosine is guanine
        assert(toRna("C") == "G");

        // RNA complement of guanine is cytosine
        assert(toRna("G") == "C");

        // RNA complement of thymine is adenine
        assert(toRna("T") == "A");

        // RNA complement of adenine is uracil
        assert(toRna("A") == "U");

        // RNA complement
        assert(toRna("ACGTGGTCTTAA") == "UGCACCAGAAUU");
    }

}
