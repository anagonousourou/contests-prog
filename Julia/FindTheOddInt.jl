function findodd(ns::Array{Int,1})
    reduce(xor, ns)
end

using FactCheck

facts("Tests") do
  context("Example tests") do
    @fact findodd([20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5]) --> 5
    @fact findodd([1,1,2,-2,5,2,4,4,-1,-2,5]) --> -1
    @fact findodd([20,1,1,2,2,3,3,5,5,4,20,4,5]) --> 5
    @fact findodd([10]) --> 10
    @fact findodd([1,1,1,1,1,1,10,1,1,1,1]) --> 10
    @fact findodd([5,4,3,2,1,5,4,3,2,10,10]) --> 1
  end
end