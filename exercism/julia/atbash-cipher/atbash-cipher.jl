const english = "abcdefghijklmnopqrstuvwxyz"
const cipher = "zyxwvutsrqponmlkjihgfedcba"
const englishToAtbash = Dict(zip(english, cipher))
const atbashToEnglish = Dict(zip(cipher, english))

function encode(input)
    input = input |> lowercase |> x -> filter(character -> isletter(character) || isdigit(character), x)
    input |> x -> map(chr -> get(englishToAtbash, chr, chr), x) |> x -> Iterators.partition(x, 5) |>
          groups -> map(group -> join(group) , groups) |> x -> join(x, " ")
end

function decode(input)
    filter(chr -> !isspace(chr), input) |> x -> map(chr -> get(atbashToEnglish, chr, chr), x)
end
