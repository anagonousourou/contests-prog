function sieve(limit)
    sieve = fill(true, limit)
    sieve[1] = false
    sqrt_limit =  trunc(Int, sqrt(limit))
    for i in 2:sqrt_limit
        if sieve[i]
            for j in i^2:i:limit
                sieve[j] = false
            end
        end
    end
    enumerate(sieve) |> collect |> x -> filter(pair -> pair[2] , x) |> x -> map(pair -> pair[1] , x)
end
