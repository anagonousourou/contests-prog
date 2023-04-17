#https://www.codewars.com/kata/56cca888a9d0f25985000036
function candiestobuy(kids::Integer)::BigInt
    lcm(big.(1:kids))
end

using FactCheck

facts("candiestobuy") do
    context("Fixed tests") do
        @fact candiestobuy(1) --> 1
        @fact candiestobuy(2) --> 2
        @fact candiestobuy(5) --> 60
        @fact candiestobuy(6) --> 60
        @fact candiestobuy(9) --> 2520
        @fact candiestobuy(10) --> 2520
    end
end