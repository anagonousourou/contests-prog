function collatz_steps(n)
    if n <= 0
        throw(DomainError(n, "$n is negative or zero"))
    end
    i = 0
    while n != 1
        if iseven(n)
            n = n ÷ 2
        else
            n = 3n+1
        end
        i += 1
    end
    i
end

