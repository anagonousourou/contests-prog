module Denom
    export convert_fracts

    function convert_fracts(lst)::Array{Array{BigInt,1},1}
       # transform into rationals
       rationals = map(elt -> Rational(BigInt(elt[1]), BigInt(elt[2])),  lst)
       common_denominator = prod(denominator.(rationals))
       new_numerators = map(fraction -> (numerator(fraction) * common_denominator) ÷ denominator(fraction) , rationals)
       # reduce the fractions
       common_divisor = gcd(new_numerators..., common_denominator)
       new_numerators = new_numerators .÷ common_divisor
       common_denominator = common_denominator ÷ common_divisor
       map(n ->  [BigInt(n), BigInt(common_denominator)], new_numerators)
    end
end


using FactCheck
using Printf
using .Denom

facts("convert_fracts") do

    function testing(lst, expect)
        actual = convert_fracts(lst)
        println("Actual ", repr(actual))
        println("Expect ", repr(expect))
        @fact actual --> expect "convert_fracts($lst)"
    end

    context("fixed tests") do
        a = [[10, 20], [1, 3], [1, 4]]
        b = [[6, 12], [4, 12], [3, 12]]
        testing(a, b)
        a = [[2, 7], [2, 6], [1, 12]]
        b = [[24, 84], [28, 84], [7, 84]]
        testing(a, b)
        
    end
end
