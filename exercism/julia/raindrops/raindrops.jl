function raindrops(number)
    # Can't use a dict because it is not ordered
    raindropsPairs = [3 => "Pling", 5 => "Plang", 7 => "Plong"]
    raindropsString = raindropsPairs |> 
                                        x -> filter(raindropPair -> mod(number, raindropPair.first) == 0, x) |> 
                                        x -> map(raindropPair -> raindropPair.second, x) |> join
    if isempty(raindropsString)
        string(number)
    else
        raindropsString
    end
end


function raindrops_alt(number)
    # Can't use a dict because it is not ordered
    raindropsPair = [3 => "Pling", 5 => "Plang", 7 => "Plong"]
    raindropsArray = []
    for (n, word) in raindropsPair
        if mod(number, n) == 0
            push!(raindropsArray, word)
        end
    end
    if length(raindropsArray) == 0
        string(number)
    else
        join(raindropsArray)
    end

end