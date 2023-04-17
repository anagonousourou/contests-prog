function computedepth(n::Integer)
    depth = 1
    digitsSet = Set()
    push!(digitsSet, digits(n)...)
    while length(digitsSet) != 10
        depth += 1 
        push!(digitsSet, digits(n * depth)...)
    end
    depth
end

using FactCheck

facts("Integer depth") do
    context("Example tests") do
        @fact computedepth(1) --> 10
        @fact computedepth(42) --> 9
    end
end