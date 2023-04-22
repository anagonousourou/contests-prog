# alternative solution from unnamed https://www.codewars.com/users/Unnamed
sumcubes(n) = (n * (n + 1) / 2) ^ 2

function sumcubes(n)
    map(x -> x^3, 1:n) |> sum
end