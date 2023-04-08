const color_values = Dict("black" => "0", "brown" => "1", "red" => "2", "orange" => "3", "yellow" => "4",
    "green" => "5", "blue" => "6", "violet" => "7", "grey" => "8", "white" => "9")
function label(colors)
    resistance_duo_value = map(color -> color_values[color], colors[1:2]) |> join
    resistance_value = string(resistance_duo_value, repeat("0", parse(Int, color_values[colors[3]])))
    resistance_int_value = parse(Int, resistance_value)
    if resistance_int_value >= 1000 && resistance_int_value % 1000 == 0
        "$(resistance_int_value ÷ 1000) kiloohms"
    else
        "$(resistance_int_value) ohms"
    end
end
