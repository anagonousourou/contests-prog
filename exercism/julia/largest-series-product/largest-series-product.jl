function largest_product(str, span)
    if isempty(str) && span != 0
        throw(ArgumentError("empty string and nonzero span = $span"))
    elseif span > length(str)
        throw(ArgumentError("span = $span longer than string length $(length(str))"))
    elseif any(character -> !isdigit(character), str)
        throw(ArgumentError("invalid character in digits"))
    elseif span < 0
        throw(ArgumentError("negative span"))
    elseif span == 0
        1
    else
        # can't map accross a string, need a collect first
        biggest = 0
        digits = str |> collect |> x -> map(chr -> parse(Int, chr), x)
        for i in 1:length(digits)
            if i + span - 1 <= length(digits)
                biggest = max(biggest, prod(digits[i:i+span-1]))
            end
        end
        biggest
    end
end


