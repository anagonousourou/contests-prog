function encode(s)
    if isempty(s)
        return s
    end
    currentChar = s[1]
    currentCounter = 1
    results = []
    for i in 2:lastindex(s)
        if s[i] == currentChar
            currentCounter += 1
        else
            if currentCounter > 1
                push!(results, string(currentCounter))
            end
            push!(results, string(currentChar))
            currentChar = s[i]
            currentCounter = 1
        end
    end
    if currentCounter > 1
        push!(results, string(currentCounter))
    end
    push!(results, string(currentChar))
    join(results)
end


const partsRegex = r"\d+|\s+|[a-zA-z]"
function decode(s)
    #find the parts of the encoded string eg : ["12", "W", "B", "12", "W", "3", "B", "24", "W", "B"]
    parts = eachmatch(partsRegex, s) |> x -> map(m -> m.match, x)  |> collect
    results = []
    for i in eachindex(parts)
        # when we get a number we take the next token and add it to the result
        if isnumber(parts[i])
            # we only repeat the token n-1 times so that 
            # we could add the n times but we will have to skip the next token which makes the code more complex
            push!(results, repeat(parts[i+1], parse(Int, parts[i]) - 1))
        else
            push!(results, parts[i])
        end
    end
    join(results)
end

function isnumber(a)
    return tryparse(Int, a) !== nothing
end