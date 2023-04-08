"""
    count_nucleotides(strand)

The count of each nucleotide within `strand` as a dictionary.

Invalid strands raise a `DomainError`.

"""
function count_nucleotides(strand)
    freqs = Dict('A' => 0, 'C' => 0, 'G' => 0, 'T' => 0)
    for n in strand
        try
            freqs[n] += 1
        catch err
            throw(DomainError(n, "$(n) is not a nucleotide"))
        end
    end
    return freqs
end
