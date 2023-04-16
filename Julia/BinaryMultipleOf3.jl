# https://math.stackexchange.com/questions/140283/why-does-this-fsm-accept-binary-numbers-divisible-by-three
module Solution
export multipleof3regex

## NOT FINISHED
multipleof3regex = r"^0*101*010*$|^0*[11]*0*$|^0*$"
  
end


using FactCheck
if VERSION < v"1"
  using Solution
  occursin = ismatch
else
  multipleof3regex = Solution.multipleof3regex
end

facts("Example test cases") do
  @fact occursin(multipleof3regex::Regex, " 0") --> false
  @fact occursin(multipleof3regex, "abc") --> false
  @fact occursin(multipleof3regex, "000") --> true
  @fact occursin(multipleof3regex, "110") --> true
  @fact occursin(multipleof3regex, "111") --> false
  @fact occursin(multipleof3regex,"101111000110000101001110") --> true
end