local leap_year = function(number)
    if math.fmod(number, 400) == 0 then
        return true
    elseif math.fmod(number, 100) == 0 then 
        return false
    else
        return math.fmod(number, 4) == 0
    end  

end

return leap_year
