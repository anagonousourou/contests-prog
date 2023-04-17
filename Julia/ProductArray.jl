#https://www.codewars.com/kata/5a905c2157c562994900009d/train/julia
function productarray(numbers)
    map(i -> prod(numbers[begin:i-1]) * prod(numbers[i+1:end]), eachindex(numbers)) 
end
#alternative implementation from Unnamed, Shanethegamer
function productarray(numbers)
    prod(numbers) .÷ numbers
end

const vowels = Set(['a', 'e', 'i', 'o', 'u'])
function getcount(s::String)    
    count(i -> i ∈ vowels,s)
end