function score(x, y)
    distance = √(x ^ 2 + y ^ 2)
    if distance > 10
        0
    elseif distance > 5
        1
    elseif distance > 1
        5
    else
        10
    end
end
