

# https://www.hackerrank.com/challenges/the-birthday-bar?isFullScreen=true
# Complete the 'birthday' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER_ARRAY s
#  2. INTEGER d
#  3. INTEGER m
#

function birthday(s, d, m)
    l = length(s)
    result = 0
    for i in eachindex(s)
       limit =  min(i + m - 1, l)
       result += sum(s[i:limit]) == d ? 1 : 0
    end
    return result
end

fptr = open(ENV["OUTPUT_PATH"], "w")

n = parse(Int32, strip(readline(stdin)))

s = map(x -> parse(Int32, x), Array{String}(split(rstrip(readline(stdin)))))

first_multiple_input = Array{String}(split(rstrip(readline(stdin))))

d = parse(Int32, first_multiple_input[1])

m = parse(Int32, first_multiple_input[2])

result = birthday(s, d, m)

write(fptr, string(result) * "\n")

close(fptr)
