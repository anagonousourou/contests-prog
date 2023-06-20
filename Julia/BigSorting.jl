#
# Complete the 'bigSorting' function below.
#
# The function is expected to return a STRING_ARRAY.
# The function accepts STRING_ARRAY unsorted as parameter.
#

function bigSorting(unsorted)
    sort!(unsorted, by = elt -> parse(BigInt, elt))
end

fptr = open(ENV["OUTPUT_PATH"], "w")

n = parse(Int32, strip(readline(stdin)))

unsorted = Array{String, 1}()

for _ = 1:n
    unsorted_item = readline(stdin)
    push!(unsorted, unsorted_item)
end

result = bigSorting(unsorted)

write(fptr, join(result, "\n"))
write(fptr, "\n")

close(fptr)
