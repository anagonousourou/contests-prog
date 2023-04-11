function saddlepoints(M)
    dims = size(M)
    nrows = dims[1]
    ncols = length(dims) > 1 ? dims[2] : 0
    results = []
    for i in 1:nrows
        for j in 1:ncols
            if saddlepoint(i, j, M)
                push!(results, (i, j))
            end
        end
    end
    results
end

function saddlepoint(i, j, M)
    all(<=(M[i,j]), M[i,:]) && all(>=(M[i,j]), M[:,j])
end
