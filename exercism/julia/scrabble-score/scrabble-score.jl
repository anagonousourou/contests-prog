const raw_scores = Dict(1 => ['A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'],
                        2 => ['D', 'G'],
                        3 => ['B', 'C', 'M', 'P'],
                        4 => ['F','H', 'V', 'W', 'Y'],
                        5 => ['K'],
                        8 => ['J', 'X'],
                        10 => ['Q', 'Z'])
const scores = Dict((letter, score) for (score, letters) in raw_scores for letter in letters)

function score(str)
    mapreduce(letter -> get(scores, uppercase(letter), 0), + , str, init = 0)
end
