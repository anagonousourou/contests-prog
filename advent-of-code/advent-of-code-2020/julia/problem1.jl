
function part1()
    inputNumbers = map(line -> parse(Int, strip(line)),  eachline("input"))
    subtractedNumbers = 2020 .- inputNumbers
    @show prod(intersect(subtractedNumbers, inputNumbers))
end

function part2()
    inputNumbers = map(line -> parse(Int, strip(line)),  eachline("input"))
    @show [(x, y, z) for x in inputNumbers, y in inputNumbers, z in inputNumbers if x + y + z == 2020]
end


