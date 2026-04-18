

#
# Complete the 'repeatedString' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts following parameters:
#  1. STRING s
#  2. LONG_INTEGER n
#

function repeatedString(s, n)
    nbOccurenceInS = count(i -> i == 'a', s)
    return nbOccurenceInS * div(n, length(s)) + count(i -> i == 'a', s[1:rem(n, length(s))])
end

fptr = open(ENV["OUTPUT_PATH"], "w")

s = readline(stdin)

n = parse(Int64, strip(readline(stdin)))

result = repeatedString(s, n)

write(fptr, string(result) * "\n")

close(fptr)
