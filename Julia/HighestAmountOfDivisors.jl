# https://www.codewars.com/kata/55ef57064cb8418a3f000061/train/julia
struct NumberInfo
    value
    isprime
    divisors
end

function proc_arrInt(arr)
    summary = map(n ->NumberInfo(n, isprime(n), getdivisors(n)), arr)
    maxnbdivisors = map(x -> length(x.divisors) , summary) |> maximum
    numberWithMaxNbDivisors = filter(x -> length(x.divisors) == maxnbdivisors, summary) |> x -> map(i -> i.value , x) |> sort
    [length(arr), count(n -> n.isprime, summary), [maxnbdivisors, numberWithMaxNbDivisors ]]
end

function isprime(n::Int64)
    sqrt_n = sqrt(n) |> trunc |> Int64
    !any(i -> n % i == 0, 2:sqrt_n)
end

function getdivisors(n)::Set{Int64}
    sqrt_n =  sqrt(n) |> trunc |> Int64
    divisors = Set([])
    for i in 1:sqrt_n
        if n % i == 0
            push!(divisors, i)
            push!(divisors, n ÷ i)
        end
    end
    divisors
end



using FactCheck

facts("Example Tests") do
  arr1 = [66,36,49,40,73,12,77,78,76,8,50,20,85,22,24,68,26,59,92,93,30]
  arr2 = [267,273,271,145,275,150,487,169,428,50,314,444,445,67,458,211,58,95,357,486,359,491,108,493,247,379]
  
  @fact proc_arrInt(arr1) --> [21, 2, [9, [36]]]
  @fact proc_arrInt(arr2) --> [26, 7, [12, [108, 150, 444, 486]]]
end