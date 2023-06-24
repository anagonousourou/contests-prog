nthfibo(n::Integer) = first([0 1] * [0 1; 1 1] ^ n)
t = parse(Int32, strip(readline(stdin)))

for t_itr = 1:t
    n = parse(Int64, strip(readline(stdin)))
    s = big(0)
    i = 2
    while true
        term = nthfibo(i)
        if term > n
            break
        end
        if iseven(term)
            s += term
        end
        i += 1
    end
    println(s)
end
