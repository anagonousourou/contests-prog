

#
# Complete the 'hackerrankInString' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#
const hackerrankRegex = r".*h.*a.*c.*k.*e.*r.*r.*a.*n.*k.*"
function hackerrankInString(s)
    occursin(hackerrankRegex, s) ? "YES" : "NO"
end

fptr = open(ENV["OUTPUT_PATH"], "w")

q = parse(Int32, strip(readline(stdin)))

for q_itr = 1:q
    s = readline(stdin)

    result = hackerrankInString(s)

    write(fptr, result * "\n")
end

close(fptr)
