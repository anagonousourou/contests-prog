"""
    ispangram(input)

Return `true` if `input` contains every alphabetic character (case insensitive).

"""
function ispangram(input)
    input |> uppercase |> x -> filter(i -> 'A' <= i <= 'Z', x) |> unique |> length |> l -> l == 26
end

