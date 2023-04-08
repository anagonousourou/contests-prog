function isarmstrong(n)
    n_str = string(n) 
    l = length(n_str)
    n_str |> collect |> x -> map(digit -> parse(Int, digit) ^ l, x) |> sum == n
end