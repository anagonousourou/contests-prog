module Kata
  export likes
  
  function likes(names::Vector{String}) :: String
    if isempty(names)
        "no one likes this"
    elseif length(names) == 1
        "$(names[1]) likes this"
    elseif length(names) == 2
        "$(names[1]) and $(names[2]) like this"
    elseif length(names) == 3
        "$(names[1]), $(names[2]) and $(names[3]) like this"
    else
        "$(names[1]), $(names[2]) and $(length(names) - 2) others like this"
    end
  end
end

using FactCheck
using .Kata

facts("Basic tests") do
  @fact likes(Vector{String}()) --> "no one likes this"
  @fact likes(["Peter"]) --> "Peter likes this"
  @fact likes(["Jacob", "Alex"]) --> "Jacob and Alex like this"
  @fact likes(["Max", "John", "Mark"]) --> "Max, John and Mark like this"
  @fact likes(["Alex", "Jacob", "Mark", "Max"]) --> "Alex, Jacob and 2 others like this"
end

