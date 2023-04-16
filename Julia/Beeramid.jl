# https://www.codewars.com/kata/51e04f6b544cf3f6550000c1/train/julia

function beeramid(bonus, price)
    nbbeers = bonus ÷ price
    nbtours = 0
    while sum_of_squares(nbtours + 1) <= nbbeers
        nbtours += 1
    end
    nbtours
end

"Sum the squares of the first `n` positive integers"
function sum_of_squares(n)
    n * (n + 1) * (2 * n + 1) ÷ 6
end

using FactCheck

facts("Basic tests") do
  context("Should pass fixed tests") do
    @fact beeramid(9, 2) --> 1
    @fact beeramid(10, 2) --> 2
    @fact beeramid(11, 2) --> 2
    @fact beeramid(21, 1.5) --> 3
    @fact beeramid(454, 5) --> 5
    @fact beeramid(455, 5) --> 6
    @fact beeramid(4, 4) --> 1
    @fact beeramid(3, 4) --> 0
    @fact beeramid(0, 4) --> 0
    @fact beeramid(-1, 4) --> 0
  end
end