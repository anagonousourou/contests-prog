function isisogram(s)
    letters = filter(isalpha, lowercase(s))
    letters |> unique |> length == letters |> length
end

isalpha(character) = 'a' <= lowercase(character) <= 'z'
