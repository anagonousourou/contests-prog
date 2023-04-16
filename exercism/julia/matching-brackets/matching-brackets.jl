const OPENING_BRACKETS = Set(['(', '{', '[']);
const CLOSING_BRACKETS = Set([')', '}', ']']);
const MATCHING_BRACKETS = Dict('(' => ')', '{' => '}', '[' => ']');

function matching_brackets(brackets::AbstractString) 
    bracketsStack = []
    for elt in brackets
        if elt ∈ OPENING_BRACKETS 
            push!(bracketsStack, get(MATCHING_BRACKETS, elt, elt))
        elseif elt ∈ CLOSING_BRACKETS && !isempty(bracketsStack) && elt == last(bracketsStack)
            pop!(bracketsStack)
        elseif elt ∈ CLOSING_BRACKETS && (isempty(bracketsStack) || elt != last(bracketsStack)) 
            return false 
        end
    end
    isempty(bracketsStack)
end
