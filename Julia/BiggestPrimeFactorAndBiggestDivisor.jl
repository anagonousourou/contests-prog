#https://www.codewars.com/kata/5646ac68901dc5c31a000022/
function big_primefac_div(n)
    trunc(n) != n && return "The number has a decimal part. No Results"
    n = convert(Int, trunc(abs(n)))
    isprime(n) && return []
    [max_prime_factor(n), maxdivisor(n)]
end

function isprime(n::Int)::Bool
    n <= 1 && return false
    limit = convert(Int, trunc(sqrt(n)))
    all(x -> n % x != 0 , 2:limit)
end

function max_prime_factor(n::Int64)::Int64
    i = 2
    factor = 1
    while n != 1
        if n % i == 0
            factor = max(factor, i)
            n = n ÷ i
        else
            i += 1 
        end
  
    end
    factor
end

function maxdivisor(n::Int)
    limit = convert(Int, trunc(sqrt(n)))
    divisor = 1
    for i in 1:limit
        if iszero(n % i)
            if i != n
                divisor = max(divisor, i)
            end
            if n ÷ i != n
                divisor = max(divisor, n ÷ i)
            end
        end
    end
    divisor
end

using FactCheck

facts("Example Tests") do
  
  @fact big_primefac_div(100) --> [5, 50]
  @fact big_primefac_div(1969) --> [179, 179]
  @fact big_primefac_div(997) --> []
  @fact big_primefac_div(-1800.00) --> [5, 900]
  @fact big_primefac_div(-1800.1) --> "The number has a decimal part. No Results"

end