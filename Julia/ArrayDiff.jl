function arraydiff(a, b)
    filter(i -> i ∉ b, a)
end

using FactCheck

facts("Sample tests") do
  context("Should pass Sample tests") do
    @fact arraydiff([], [4,5]) --> []
    @fact arraydiff([3,4], [3]) --> [4]
    @fact arraydiff([1,8,2], []) --> [1,8,2]
    @fact arraydiff([1,2,3], [1, 2]) --> [3]
  end
end