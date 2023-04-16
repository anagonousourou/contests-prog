

#
# Complete the 'diagonalDifference' function below.
#
# The function is expected to return an INTEGER.
# The function accepts 2D_INTEGER_ARRAY arr as parameter.
#
#https://docs.julialang.org/en/v1/manual/arrays/
function diagonalDifference(arr)
    dim1 = size(arr, 1)
    dim2 = size(arr, 2)
    abs(sum(arr[CartesianIndex.(1:1:dim1, dim2:-1:1)]) - sum(arr[CartesianIndex.(1:1:dim1, 1:1:dim2)]))
end

fptr = open(ENV["OUTPUT_PATH"], "w")

n = parse(Int32, strip(readline(stdin)))

lines = String[]

for _ in 1:n
    push!(lines, strip(readline(stdin)))
end
elts = join(lines, " ") |> split |> x -> map(elt -> parse(Int, elt), x)

arr =  reshape(elts, (n,n)) |> transpose

result = diagonalDifference(arr)

write(fptr, string(result) * "\n")

close(fptr)
