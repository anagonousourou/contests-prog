

# https://www.hackerrank.com/challenges/save-the-prisoner/problem?isFullScreen=true
# Complete the 'saveThePrisoner' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER m
#  3. INTEGER s
#

function saveThePrisoner(n, m, s)

end

fptr = open(ENV["OUTPUT_PATH"], "w")

t = parse(Int32, strip(readline(stdin)))

for t_itr = 1:t
    first_multiple_input = Array{String}(split(rstrip(readline(stdin))))

    n = parse(Int32, first_multiple_input[1])

    m = parse(Int32, first_multiple_input[2])

    s = parse(Int32, first_multiple_input[3])

    result = saveThePrisoner(n, m, s)

    write(fptr, string(result) * "\n")
end

close(fptr)
