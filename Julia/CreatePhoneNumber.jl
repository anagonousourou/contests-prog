function createphonenumber(numbers)
    "($(join(numbers[1:3]))) $(join(numbers[4:6]))-$(join(numbers[7:10]))"
end

# tests

using FactCheck

facts("Tests") do
  context("Should pass sample tests") do
    @fact createphonenumber([1, 2, 3, 4, 5, 6, 7, 8, 9, 0]) --> "(123) 456-7890"
    @fact createphonenumber([1, 1, 1, 1, 1, 1, 1, 1, 1, 1]) --> "(111) 111-1111"
    @fact createphonenumber([1, 2, 3, 4, 5, 6, 7, 8, 9, 0]) --> "(123) 456-7890"
  end
end