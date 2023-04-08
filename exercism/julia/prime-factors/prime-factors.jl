function prime_factors(n)
    i = 2
    n′ = n
    factors = Int[]
    while n′ != 1
        if n′ % i == 0
            push!(factors, i)
            n′ = n′ ÷ i
        else
            i += 1
        end  
    end
    factors
end
