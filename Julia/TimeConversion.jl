

#
# Complete the 'timeConversion' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#
using Printf

function timeConversion(s)
    period = s[end-1:end]
    hour = parse(Int,s[1:2])
    if hour == 12 && period == "AM"
        @sprintf "00%s" s[3:end-2]
    elseif hour == 12 && period == "PM"
        s[1:end-2]
    elseif period == "AM"
        s[1:end-2]
    elseif period == "PM"
        @sprintf "%02i%s" (hour+12) s[3:end-2]
    end
end

fptr = open(ENV["OUTPUT_PATH"], "w")

s = readline(stdin)

result = timeConversion(s)

write(fptr, result * "\n")

close(fptr)
