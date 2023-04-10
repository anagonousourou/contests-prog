

#
# Complete the 'plusMinus' function below.
#
# The function accepts INTEGER_ARRAY arr as parameter.
#

function plusMinus(arr)
    (count(>(0), arr) / length(arr)) |> println
    (count(<(0), arr) / length(arr)) |> println
    (count(==(0), arr) / length(arr)) |> println
end

n = parse(Int32, strip(readline(stdin)))

arr = map(x -> parse(Int32, x), Array{String}(split(rstrip(readline(stdin)))))

plusMinus(arr)
