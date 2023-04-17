

#
# Complete the 'gradingStudents' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts INTEGER_ARRAY grades as parameter.
#

function gradingStudents(grades)
    map(transformGrade, grades) 
end
function transformGrade(grade)
    if grade < 38
        grade
    else
        gap = 5 - (grade % 5)
        if gap < 3
           gap + grade
        else
            grade
        end
    end
end

fptr = open(ENV["OUTPUT_PATH"], "w")

grades_count = parse(Int32, strip(readline(stdin)))

grades = Array{Int32, 1}()

for _ = 1:grades_count
    grades_item = parse(Int32, strip(readline(stdin)))
    push!(grades, grades_item)
end

result = gradingStudents(grades)

write(fptr, join(result, "\n"))
write(fptr, "\n")

close(fptr)
