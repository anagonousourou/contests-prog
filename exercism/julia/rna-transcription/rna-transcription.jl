const nucleotideComplements = Dict('G' => 'C', 'C' => 'G', 'T' => 'A', 'A' => 'U')
const nonDNARegex = r"[^GCTA]"
function to_rna(dna)
    if occursin(nonDNARegex, dna)
        throw(ErrorException("$dna is not a valid dna string"))
    else
        map(n -> nucleotideComplements[n], dna)
    end
end

