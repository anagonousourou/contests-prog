# https://www.codewars.com/kata/5813d19765d81c592200001a/train/julia
function dont_give_me_five(start_,end_)
    count(n -> 5 ∉ abs.(digits(n)), start_:end_)
end

using FactCheck

facts("Basic tests") do
  context("Should pass example tests") do
    @fact dont_give_me_five(1,9) --> 8
    @fact dont_give_me_five(4,17) --> 12
  end
  context("Should pass negative tests") do
    @fact dont_give_me_five(1,90) --> 72
    @fact dont_give_me_five(-4,17) --> 20
    @fact dont_give_me_five(-4,37) --> 38
    @fact dont_give_me_five(-14,-1) --> 13
    @fact dont_give_me_five(-14,-6) --> 9
  end
end