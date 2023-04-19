# NOT FINISHED

n = parse(Int32, strip(readline(stdin)))

genes = Array{String}(split(rstrip(readline(stdin))))

health = map(x -> parse(Int32, x), Array{String}(split(rstrip(readline(stdin)))))

s = parse(Int32, strip(readline(stdin)))

maxStrandHealth = 0
minStrandHealth = 0
for s_itr = 1:s
    first_multiple_input = Array{String}(split(rstrip(readline(stdin))))

    first = parse(Int, first_multiple_input[1]) + 1

    last = parse(Int, first_multiple_input[2]) + 1

    d = first_multiple_input[3]

    strandHealth = 0
    for geneIndex in first:last
        gene = genes[geneIndex]
        # how many occurences of this gene
        strandHealth += count(gene, d, overlap=true) * health[geneIndex]
    end
    global minStrandHealth = min(minStrandHealth, strandHealth)
    global maxStrandHealth = max(maxStrandHealth, strandHealth)
end
println("$minStrandHealth $maxStrandHealth")