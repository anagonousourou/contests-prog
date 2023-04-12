

#
# Complete the 'minimumNumber' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. STRING password
#

lower_case = "abcdefghijklmnopqrstuvwxyz"
upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
special_characters = r"[!@#$%^&*()-+]"

# "AUzs-nV" does not work 

function minimumNumber(n, password)
    # Return the minimum number of characters to make the password strong
    nb = 0
    if !any(isdigit, password)
        nb +=1
    end
    if !any(islowercase, password)
        nb += 1
    end
    if !any(isuppercase, password)
        nb += 1
    end
    if !occursin(special_characters , password)
        nb +=1
    end
    max(nb, 6 - n)
end

fptr = open(ENV["OUTPUT_PATH"], "w")

n = parse(Int32, strip(readline(stdin)))

password = readline(stdin)

answer = minimumNumber(n, password)

write(fptr, string(answer) * "\n")

close(fptr)
