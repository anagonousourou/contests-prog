#https://www.codewars.com/kata/55ea170313b76622b3000014

function same_fact_rev(n_max)
    filter(n -> reverse(string(n)) != string(n) && prime_factors(n) == parse(Int, reverse(string(n))) |> prime_factors , 1:n_max-1) 
end

function prime_factors(n)
    i = 2
    factors = Set([])
    while n != 1
        if n % i == 0
            push!(factors, i)
            n = n ÷ i
        else
            i += 1
        end  
    end
    factors
end


using FactCheck

facts("Example Tests") do
  @fact same_fact_rev(1100) --> [1089]
  @fact same_fact_rev(2500) --> [1089, 2178]
  @fact same_fact_rev(5000) --> [1089, 2178, 4356]
end