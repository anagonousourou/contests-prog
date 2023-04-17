# https://www.codewars.com/kata/54d512e62a5e54c96200019e/
module Factors
    export prime_factors

    function prime_factors(n)
        prime_factors_decomposition(n)  |> collect |> x -> sort(x, by= y -> y.first) |>
            x ->  map(y -> y.second > 1 ? "($(y.first)**$(y.second))" : "($(y.first))", x) |> join
    end

    function prime_factors_decomposition(n::Int64)::Dict{Int64, Int64}
        i = 2
        factors = Dict{Int64, Int64}()
        while n != 1
            if n % i == 0
                factors[i] = get(factors, i, 0) + 1
                n = n ÷ i
            else
                i += 1
            end  
        end
        factors
    end
end

using FactCheck
using .Factors

facts("prime_factors") do

    function testing(n, expect)
        actual = prime_factors(n)
        println("Actual ", actual)
        println("Expect ", expect)
        println("Result ", actual == expect)
        @fact actual --> expect "prime_factors($n)"
    end

    context("fixed tests") do
        testing(7775460, "(2**2)(3**3)(5)(7)(11**2)(17)")
        testing(7919, "(7919)")
        
    end
end