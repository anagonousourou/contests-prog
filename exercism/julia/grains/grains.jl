"""Calculate the number of grains on square `square`."""
function on_square(square)
    if 1 <= square <= 64
        2 ^ (big(square) - 1)
    else
        throw(DomainError(square, "$square not in [1:64]"))
    end
end

"""Calculate the total number of grains after square `square`."""
function total_after(square)
    if 1 <= square <= 64
        (2 ^ big(square)) - 1
    else
        throw(DomainError(square, "$square not in [1:64]"))
    end
end
