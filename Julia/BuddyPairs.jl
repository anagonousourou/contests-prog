# https://www.codewars.com/kata/59ccf051dcc4050f7800008f/train/julia
module Buddy
    export buddy
    function buddy(start::Int, nd::Int)::String
        for n in start:nd
            sn = divisorssum(n)
            if sn - 1 > n
                sm = divisorssum(sn - 1)
                (sm == n + 1  && n != sn - 1) && return "($n $(sn - 1))"
            end

        end
        "Nothing"
    end

    function divisorssum(n::Int)
        limit = convert(Int, trunc(sqrt(n)))
        divisors = Set()
        for i in 1:limit
            if iszero(n % i)
                if i != n
                    push!(divisors, i)
                end
                if n ÷ i != n
                    push!(divisors, n ÷ i)
                end
            end
        end
        # sum(divisors, init=0) # Keyword argument init requires Julia 1.6 or later.
        reduce(+, divisors, init=0) 
    end
end 


using FactCheck
using Printf
using .Buddy

facts("buddy") do

    function testing(start, nd, expect)
        actual = buddy(start, nd)
        println("Actual ", repr(actual))
        println("Expect ", repr(expect))
        @fact actual --> expect "buddy($start, $nd)"
    end
    context("fixed tests") do
        testing(1071625, 1103735, "(1081184 1331967)")
        testing(2382, 3679, "Nothing")
        testing(1, 100, "(48 75)")
        
    end
end