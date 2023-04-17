# https://major-prepa.com/mathematiques/suite-fibonacci-nombre-or/
# https://www.codewars.com/kata/53d40c1e2f13e331fc000c26/
# https://www.codewars.com/kata/53d40c1e2f13e331fc000c26/solutions/julia

function fib(n::Int)
    setprecision(BigFloat, 800000) do
        n = big(n)
        phi = big((1 + √big(5)) / 2)
        phiprime = big((1 - √big(5)) / 2)
        tmp = big((1 / √big(5))) * (phi^n - phiprime^n)
        convert(BigInt, round(tmp))
    end
end


using FactCheck

facts("Basic tests") do
  @fact fib(0) --> 0
  @fact fib(1) --> 1
  @fact fib(2) --> 1
  @fact fib(-2) --> -1
  @fact fib(-3) --> 2
  @fact fib(10) --> 55
  @fact fib(-10) --> -55
end