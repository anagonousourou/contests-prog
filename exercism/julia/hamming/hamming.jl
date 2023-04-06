"Compute the hamming distance"
function distance(a, b)
    if length(a) != length(b)
        throw(ArgumentError("hamming distance is only defined for sequences of equal length"))
    end
    map(!=, a, b) |> count
end
