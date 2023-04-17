#
# Complete the 'staircase' function below.
#
# The function accepts INTEGER n as parameter.
#

function staircase(n)
    for i in 1:n
       string(repeat(' ',n-i), repeat('#', i)) |> println 
    end
end

n = parse(Int32, strip(readline(stdin)))

staircase(n)
