const powers = Dict( 'w' => 4, 'p' => 3, 'b' => 2, 's' => 1, 'm' => -4, 'q' => -3, 'd' => -2, 'z' => -1)
function alphabetwar(fight::AbstractString)::String
   result = map(chr -> get(powers, chr, 0), collect(fight)) |> sum
   result > 0 && return "Left side wins!"
   result < 0 && return "Right side wins!"
   "Let's fight again!"
end

