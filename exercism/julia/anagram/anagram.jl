function detect_anagrams(subject, candidates)
    subject_frequency = frequency(lowercase(subject))
    filter(candidate -> frequency(lowercase(candidate)) == subject_frequency && lowercase(candidate) != lowercase(subject), candidates)
end

function frequency(input)
    counter = Dict()
    for i in input
        if haskey(counter, i)
            counter[i] += 1
        else
            counter[i] = 1
        end
    end
    counter
end
