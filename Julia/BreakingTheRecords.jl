

#
# Complete the 'breakingRecords' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts INTEGER_ARRAY scores as parameter.
#

function breakingRecords(scores)
    currentMax = scores[1]
    currentMin = scores[1]
    breakingMaxCount = 0
    breakingMinCount = 0
    for i in eachindex(scores)
        if scores[i] > currentMax
            currentMax = scores[i]
            breakingMaxCount += 1
        end
        if scores[i] < currentMin
            currentMin = scores[i]
            breakingMinCount += 1
        end
    end
    return [breakingMaxCount, breakingMinCount]
end

fptr = open(ENV["OUTPUT_PATH"], "w")

n = parse(Int32, strip(readline(stdin)))

scores = map(x -> parse(Int32, x), Array{String}(split(rstrip(readline(stdin)))))

result = breakingRecords(scores)

write(fptr, join(result, " "))
write(fptr, "\n")

close(fptr)
