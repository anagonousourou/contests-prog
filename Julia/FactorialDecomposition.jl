# https://www.codewars.com/kata/5a045fee46d843effa000070
module Fact
    export decomp
    function decomp(n::Int64)::String
       map(prime_factors, 2:n) |> x -> mergewith!(+, x...) |> collect |> x -> sort(x, by= y -> y.first) |>
                               x ->  map(y -> y.second > 1 ? "$(y.first)^$(y.second)" : string(y.first), x) |>
                               x -> join(x, " * ")
    end
    function prime_factors(n::Int64)::Dict{Int64, Int64}
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
using Printf
using .Fact

facts("decomp") do

    function testing(n, expect)
        actual = decomp(n)
        println("Actual ", repr(actual))
        println("Expect ", repr(expect))
        @fact actual --> expect "decomp($(n))"
    end

    context("fixed tests") do
        testing(17, "2^15 * 3^6 * 5^3 * 7^2 * 11 * 13 * 17")
        testing(5, "2^3 * 3 * 5")
        testing(22, "2^19 * 3^9 * 5^4 * 7^3 * 11^2 * 13 * 17 * 19")
        testing(14, "2^11 * 3^5 * 5^2 * 7^2 * 11 * 13")
        testing(25, "2^22 * 3^10 * 5^6 * 7^3 * 11^2 * 13 * 17 * 19 * 23")

    end
end
