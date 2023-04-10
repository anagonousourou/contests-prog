# Given an array of integers, where all elements but one occur twice, find the unique element.
# Complete the 'lonelyinteger' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY a as parameter.

#Every pair cancel each other out
function lonelyinteger(a)
    reduce(xor,a)
end

fptr = open(ENV["OUTPUT_PATH"], "w")

n = parse(Int32, strip(readline(stdin)))

a = map(x -> parse(Int32, x), Array{String}(split(rstrip(readline(stdin)))))

result = lonelyinteger(a)

write(fptr, string(result) * "\n")

close(fptr)
