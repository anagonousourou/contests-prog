const wordRegex = r"\w+'\w+|\w+"
function wordcount(sentence)
    sentence = lowercase(sentence)
    eachmatch(wordRegex ,sentence) |> x -> map(rm -> rm.match, x) |> frequency
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

#https://stackoverflow.com/questions/54935955/convert-regex-match-into-string
