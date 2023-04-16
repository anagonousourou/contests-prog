function nextbigger(n::Int64)
    #get the digits of the number
    chiffres = digits(n)
    for i in 1:length(chiffres) - 1
        if chiffres[i] > chiffres[i+1]
            index, _ = filter(p -> p.second > chiffres[i+1], pairs(chiffres[begin:i])) |> x -> sort(collect(x), by= y -> y[2]) |> first
            # _, index = findmin(x -> x > chiffres[i+1] ? x - chiffres[i+1] : 100, chiffres[begin:i]) # Needs Julia 1.7
            chiffres[i+1], chiffres[index] = chiffres[index], chiffres[i+1]
            return parse(Int, join(reverse([sort(chiffres[begin:i], rev = true);chiffres[i+1:end]]))) 
        end
    end
    -1
end



using FactCheck
context("Basic tests") do
  facts("Small numbers") do
    @fact nextbigger(12) == 21
    @fact nextbigger(513) == 531
    @fact nextbigger(2017) == 2071
    @fact nextbigger(414) == 441
    @fact nextbigger(144) == 414
  end
  
  facts("Bigger numbers") do
    @fact nextbigger(123456789) == 123456798
    @fact nextbigger(1234567890) == 1234567908
    @fact nextbigger(9876543210) == -1
    @fact nextbigger(9999999999) == -1
    @fact nextbigger(59884848459853) == 59884848483559
  end
end