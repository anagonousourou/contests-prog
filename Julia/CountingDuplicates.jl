function duplicatecount(text)
    filter(pair -> pair.second ≥ 2 , text |> lowercase |> frequency) |> length
end

function frequency(input)
    counter = Dict()
    for i in input
        if haskey(counter, i)
            counter[i] += 1
        else
            counter[i] = 1
        end
    end
    counter
end

#alternative implementation 
using DataStructures # is not built-in

function duplicatecount(text)
  c = text |> lowercase |> counter
  count(>(1), values(c))
end


using FactCheck

facts("Sample tests") do
  @fact duplicatecount("") --> 0
  @fact duplicatecount("abcde") --> 0
  @fact duplicatecount("aabbcde") --> 2
  @fact duplicatecount("aabBcde") --> 2
  @fact duplicatecount("Indivisibility") --> 1
  @fact duplicatecount("Indivisibilities") --> 2
end