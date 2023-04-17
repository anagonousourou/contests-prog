

#
# Complete the 'getTotalX' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER_ARRAY a
#  2. INTEGER_ARRAY b
#

function getTotalX(a, b)
    count(n -> all(aElt -> n % aElt == 0,  a) && all(bElt -> bElt % n == 0,  b), maximum(a):minimum(b))
end

fptr = open(ENV["OUTPUT_PATH"], "w")

first_multiple_input = Array{String}(split(rstrip(readline(stdin))))

n = parse(Int32, first_multiple_input[1])

m = parse(Int32, first_multiple_input[2])

arr = map(x -> parse(Int32, x), Array{String}(split(rstrip(readline(stdin)))))

brr = map(x -> parse(Int32, x), Array{String}(split(rstrip(readline(stdin)))))

total = getTotalX(arr, brr)

write(fptr, string(total) * "\n")

close(fptr)
