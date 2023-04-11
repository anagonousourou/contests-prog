const isbnRegex = r"^[0-9]{9}[0-9|X]$"
function ISBN(input)
    input = filter(chr -> isletter(chr) || isdigit(chr), input)
    if !occursin(isbnRegex, input)
        throw(DomainError(input, "$input is not a valid isbn"))
    end
    check = map(chr -> chr == 'X' ? 10 : parse(Int, chr) , collect(input)) |> x -> map(*, 10:-1:1, x) |> sum |> x -> mod(x, 11) == 0 
    if !check
        throw(DomainError(input, "$input is not a valid isbn"))
    end
    input 
end