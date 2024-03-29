module nucleotide_count;

import std.string;
import std.array;
import std.algorithm.sorting : sort;
import std.algorithm.comparison : equal;
import std.algorithm.searching;

class Counter
{
    string dna;

    static immutable nucleotidesKnown = ['A', 'T', 'C', 'G'];
    this(string dna)
    {
        foreach (nucleotide; dna)
        {

            if (nucleotidesKnown.dup.find(nucleotide).empty)
            {
                throw new Exception(format("Character %s is not valid", nucleotide));
            }
        }
        this.dna = dna;
    }
}

ulong[char] nucleotideCounts(const Counter dnaInfo)
{
    ulong[char] freq = ['A': 0, 'T': 0, 'C': 0, 'G': 0];
    foreach (nucleotide; dnaInfo.dna)
    {
        freq[nucleotide] += 1;
    }
    return freq;
}

unittest
{

    // test associative array equality
    bool aaEqual(const ulong[char] lhs, const ulong[char] rhs)
    {
        auto lhs_pairs = lhs.byKeyValue.array;
        auto rhs_pairs = rhs.byKeyValue.array;
        lhs_pairs.sort!(q{a.key < b.key});
        rhs_pairs.sort!(q{a.key < b.key});

        return equal!("a.key == b.key && a.value == b.value")(lhs_pairs, rhs_pairs);
    }

    immutable int allTestsEnabled = 1;

    // Empty strand
    {
        const Counter dna = new Counter("");
        const ulong[char] expected = ['A': 0, 'T': 0, 'C': 0, 'G': 0];

        auto actual = dna.nucleotideCounts();

        assert(aaEqual(expected, actual));
    }

    // Strand with invalid nucleotides
    {
        import std.exception : assertThrown;

        assertThrown(new Counter("AGXXACT"));
    }
    static if (allTestsEnabled)
    {
        // Can count one nucleotide in single-character input
        {
            const Counter dna = new Counter("G");
            const ulong[char] expected = ['A': 0, 'T': 0, 'C': 0, 'G': 1];

            const auto actual = dna.nucleotideCounts();

            assert(aaEqual(expected, actual));
        }

        // Strand with repeated nucleotide
        {
            const Counter dna = new Counter("GGGGGGGG");
            const ulong[char] expected = ['A': 0, 'T': 0, 'C': 0, 'G': 8];

            const auto actual = dna.nucleotideCounts();

            assert(aaEqual(expected, actual));
        }

        // Strand with multiple nucleotides
        {
            const Counter dna = new Counter(
                "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC");
            const ulong[char] expected = ['A': 20, 'T': 21, 'C': 12, 'G': 17];

            const auto actual = dna.nucleotideCounts();

            assert(aaEqual(expected, actual));
        }

    }

}
