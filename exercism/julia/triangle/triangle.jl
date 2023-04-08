function is_equilateral(sides)
    is_triangle(sides) && unique(sides) |> length == 1
end

function is_isosceles(sides)
    is_triangle(sides) && unique(sides) |> length <= 2
end

function is_scalene(sides)
    is_triangle(sides) && unique(sides) |> length == 3
end

function is_triangle(sides)
    perimeter = sum(sides)
    all(side -> side > 0 && perimeter - side >= side, sides)
end
