function isperfect(n)
    n <= 0 && throw(DomainError(n, "$n is zero or negative"))
    factors_sum(n) == n
end

function isabundant(n)
    n <= 0 && throw(DomainError(n, "$n is zero or negative"))
    factors_sum(n) > n
end

function isdeficient(n)
    n <= 0 && throw(DomainError(n, "$n is zero or negative"))
   factors_sum(n) < n  
end

function factors_sum(n)
    filter(i -> n % i == 0, 1:(n ÷ 2)) |> sum
end

