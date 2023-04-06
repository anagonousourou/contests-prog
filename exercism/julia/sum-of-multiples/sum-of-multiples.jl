function sum_of_multiples(limit, factors)
    0:(limit -1) |> x -> filter(n -> any(factor -> factor == 0 ? false : n % factor == 0 , factors) , x) |> sum    
end


function sum_of_multiples_work_in_progress(limit, factors)
    all_factor_contribution = mapreduce(factor -> sum_of_multiple_of_factor(limit, factor),+, factors, init = 0)
    # remove the duplicates
    @show all_factor_contribution
    non_zero_factors = filter(factor -> factor != 0, factors)
    if length(non_zero_factors) <= 1
        all_factor_contribution
    else
        common_multiple = lcm(non_zero_factors)
        all_factor_contribution - sum_of_multiple_of_factor(limit, common_multiple)
    end
    
    
end

function biggest_multiple_below(limit, factor)
    while limit > 0
        if limit % factor == 0
            return limit
        end
        limit -= 1
    end
    0
end

function sum_of_multiple_of_factor(limit, factor)
    if factor == 0
        return 0
    end
    n = (limit - 1) ÷ factor
    (n + 1) * factor * n ÷ 2
end
