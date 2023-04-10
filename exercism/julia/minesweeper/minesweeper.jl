function annotate(minefield)
    nrows = length(minefield)
    ncols = 0
    if nrows >= 1
        ncols = length(minefield[1])
    end
    mutable_minefield = map(collect, minefield)
    for i in 1:nrows
        for j in 1:ncols
            if mutable_minefield[i][j] != '*'
                mutable_minefield[i][j] = neighbors(i, j, nrows, ncols) |> nbors -> count(nbor -> minefield[nbor[1]][nbor[2]] == '*', nbors) |> i -> i == 0 ? ' ' : Char('0'+i)
            end
        end     
    end
    map(join,  mutable_minefield)
end

function neighbors(i, j, nrows, ncols)
    valid_neighbors = []
    for x in -1:1
        for y in -1:1
            if x+i in 1:nrows && y+j in 1:ncols && (x+i, y+j) != (i,j) 
                push!(valid_neighbors, (x+i, y+j))
            end
        end
    end
    valid_neighbors
end

#https://stackoverflow.com/questions/29143667/whats-the-best-way-to-convert-an-int-to-a-char-in-julia#29146061