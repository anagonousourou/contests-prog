

#
# Complete the 'compareTriplets' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts following parameters:
#  1. INTEGER_ARRAY a
#  2. INTEGER_ARRAY b
#

function compareTriplets(a, b)
    results = map((ai, bi) -> if ai > bi "alice" elseif ai < bi "bob" else "noone" end, a, b)
    [count(==("alice"), results),count(==("bob"), results) ]
end

fptr = open(ENV["OUTPUT_PATH"], "w")

a = map(x -> parse(Int32, x), Array{String}(split(rstrip(readline(stdin)))))

b = map(x -> parse(Int32, x), Array{String}(split(rstrip(readline(stdin)))))

result = compareTriplets(a, b)

write(fptr, join(result, " "))
write(fptr, "\n")

close(fptr)
