

#
# Complete the 'kangaroo' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. INTEGER x1
#  2. INTEGER v1
#  3. INTEGER x2
#  4. INTEGER v2
#

function kangaroo(x1, v1, x2, v2)
    try
        q, t = divrem((x2 - x1), (v1 - v2))
        t == 0 && q > 0 ? "YES" : "NO"
    catch
        "NO"
    end
end

fptr = open(ENV["OUTPUT_PATH"], "w")

first_multiple_input = Array{String}(split(rstrip(readline(stdin))))

x1 = parse(Int32, first_multiple_input[1])

v1 = parse(Int32, first_multiple_input[2])

x2 = parse(Int32, first_multiple_input[3])

v2 = parse(Int32, first_multiple_input[4])

result = kangaroo(x1, v1, x2, v2)

write(fptr, result * "\n")

close(fptr)
