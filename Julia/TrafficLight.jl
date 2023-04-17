const colors = Dict("green" => "yellow", "yellow" => "red", "red" => "green")

function updatelight(current)
    get(colors, current, current)
end