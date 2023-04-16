const isbnRegex = r"^[0-9]{9}[0-9|X]$"
function isvalidISBN10(input::AbstractString)::Bool
    input = filter(chr -> isletter(chr) || isdigit(chr), input)
    occursin(isbnRegex, input) && map(chr -> chr == 'X' ? 10 : parse(Int, chr) , collect(input)) |> 
                                            x -> map(*, 10:-1:1, x) |> sum |> x -> mod(x, 11) == 0 
end

using FactCheck

facts("Sample tests") do
    @fact isvalidISBN10("1112223339") --> true 
    @fact isvalidISBN10("048665088X") --> true 
    @fact isvalidISBN10("1293000000") --> true 
    @fact isvalidISBN10("1234554321") --> true 
    @fact isvalidISBN10("1234512345") --> false
    @fact isvalidISBN10("1293") --> false 
    @fact isvalidISBN10("X123456788") --> false 
    @fact isvalidISBN10("ABCDEFGHIJ") --> false 
    @fact isvalidISBN10("XXXXXXXXXX") --> false
    @fact isvalidISBN10("048665088XZ") --> false
end
