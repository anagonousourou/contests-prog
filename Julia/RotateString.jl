function rotate(str)
    [str[i+1:end] * str[begin:i] for i in 1:length(str)]
end


using FactCheck

facts("Basic tests") do
  context("Should pass fixed tests") do
    @fact rotate("Hello") --> ["elloH", "lloHe", "loHel", "oHell", "Hello"]
    @fact rotate(" ") --> [" "]
    @fact rotate("") --> []
    @fact rotate("123") --> ["231", "312", "123"]
  end
end