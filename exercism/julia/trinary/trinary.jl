const nonTrinary = r"[^012]"
function trinary_to_decimal(str::String)
    if occursin(nonTrinary, str)
        0
    else
        map(chr -> parse(Int, chr), collect(str)) |> reverse |> enumerate |> x -> map(positionDigitTuple -> positionDigitTuple[2] * (3 ^ (positionDigitTuple[1] - 1)), x) |> sum
    end 
end
