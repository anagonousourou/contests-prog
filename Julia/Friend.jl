# https://www.codewars.com/kata/5547cc7dcad755e480000004/train/julia
module Friend
    export remove_nb

    "find tuples (a, b) such that a*b == ∑1:n - a - b"
    function remove_nb(n)::Vector{Tuple{Int64,Int64}}
        #get the sum from 1 to n
        thesum = sum(1:n)
        # ∑(1:n) - a - b = a*b
        # have each element i from 1 to n remove itself from ∑1:n
        # find the remainder when we divide (∑1:n - i) by i
        # 
        abs = rem.((thesum .- collect(1:n)), collect(1:n)) |> enumerate |> collect |>
                            x -> filter(t -> t[1] * t[2] == (thesum - t[1] - t[2]), x)
        # we only get the tuples (a,b) where a > b
        # so we create the (b, a) tuples
        sort([abs; reverse.(abs)], by= y -> y[1]) 
    end  

end


using FactCheck
using .Friend

facts("remove_nb") do

    function testing(n, expect)
        actual = remove_nb(n)
        println("Actual ", actual)
        println("Expect ", expect)
        @fact actual --> expect "remove_nb($n)"
    end 

    context("fixed tests") do
        testing(26, [(15, 21), (21, 15)])
        testing(100, Tuple{Int64,Int64}[])
        testing(101, [(55, 91), (91, 55)])
        
    end    
end
