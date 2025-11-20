

# https://www.hackerrank.com/challenges/utopian-tree/problem?isFullScreen=true
# Complete the 'utopianTree' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER n as parameter.
#

function utopianTree(n)
    spring = true
    treeSize = 1
    while n > 0
        if spring
            treeSize = treeSize * 2
        else
            treeSize = treeSize + 1
        end
        spring = !spring
        n = n - 1
    end
    return treeSize
end

fptr = open(ENV["OUTPUT_PATH"], "w")

t = parse(Int32, strip(readline(stdin)))

for t_itr = 1:t
    n = parse(Int32, strip(readline(stdin)))

    result = utopianTree(n)

    write(fptr, string(result) * "\n")
end

close(fptr)
