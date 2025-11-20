

# https://www.hackerrank.com/challenges/service-lane/problem?isFullScreen=true
# Complete the 'serviceLane' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts following parameters:
#  1. INTEGER n
#  2. 2D_INTEGER_ARRAY cases
#

function serviceLane(n, widths, cases)
    # @show widths
    # @show cases
    result =  Array{Int32, 1}()
    for case in cases
        # @show case
        # @show widths[case[1]+1:case[2]+1]
        push!(result, minimum(widths[case[1]+1:case[2]+1]))
    end
    result
end

#fptr = open(ENV["OUTPUT_PATH"], "w")

first_multiple_input = Array{String}(split(rstrip(readline(stdin))))

n = parse(Int32, first_multiple_input[1])

t = parse(Int32, first_multiple_input[2])

width = map(x -> parse(Int32, x), Array{String}(split(rstrip(readline(stdin)))))

cases = Array{Array{Int32, 1}, 1}()

for _ = 1:t
    push!(cases, map(x -> parse(Int32, x), Array{String}(split(rstrip(readline(stdin))))))
end

result = serviceLane(n, width, cases)
@show result
#write(fptr, join(result, "\n"))
#write(fptr, "\n")

#close(fptr)
