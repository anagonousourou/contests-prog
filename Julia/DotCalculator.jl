const equationRegex = r"\.+|\+|\*|//|-"
const operators = Dict("+" => +, "-" => -, "//" => ÷, "*" => *)
function dotcalculator(equation)
   adot, op, bdot =  eachmatch(equationRegex, equation) |> x -> map(m -> m.match, x)
   a = length(adot)
   b = length(bdot)
   operators[op](a,b) |> n -> repeat(".", n)
end
