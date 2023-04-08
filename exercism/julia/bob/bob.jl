function bob(statement)
    if isblank(statement)
      "Fine. Be that way!"
    elseif capital(statement) && endswith(strip(statement), "!")
      "Whoa, chill out!"
    elseif capital(statement) && endswith(strip(statement), "?")
      "Calm down, I know what I'm doing!" 
    elseif capital(statement)
      "Whoa, chill out!"
    elseif endswith(strip(statement), "?")
      "Sure."
    else
      "Whatever."
    
    end
end

function isblank(input::AbstractString)
    length(input) == 0 || all(isspace, input)
end

function capital(statement::AbstractString)
    filter(isletter, statement) |> x -> all(isuppercase, x) && any(isletter, statement)
end
