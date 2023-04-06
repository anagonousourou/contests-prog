function digitTransformation(positionDigitTuple)
    if iseven(positionDigitTuple[1])
        digit = parse(Int, positionDigitTuple[2])
        if 2 * digit >= 10
            (2 * digit) - 9
        else 
            2 * digit
        end
    else 
        parse(Int, positionDigitTuple[2])
    end
end

function luhn(cardNumber)
    cardNumber = filter(x -> !isspace(x), cardNumber)
    if occursin(r"[^0-9]+", cardNumber) || length(cardNumber) <= 1
        false
    else
        cardNumber |> reverse |> enumerate |> x -> map(digitTransformation, x) |> sum |> x -> mod(x, 10) == 0                                           
    end
end