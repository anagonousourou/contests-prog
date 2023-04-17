

#
# Complete the 'birthdayCakeCandles' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY candles as parameter.
#

function birthdayCakeCandles(candles)
  tallest =  maximum(candles)
  count(==(tallest), candles)
end

fptr = open(ENV["OUTPUT_PATH"], "w")

candles_count = parse(Int32, strip(readline(stdin)))

candles = map(x -> parse(Int32, x), Array{String}(split(rstrip(readline(stdin)))))

result = birthdayCakeCandles(candles)

write(fptr, string(result) * "\n")

close(fptr)
