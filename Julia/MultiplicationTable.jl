function multiplicationtable(size::Int64)::Matrix{Int64}
    reshape([i * j for i in 1:size for j in 1:size], (size,size))
end

# alternative implementation from Unnamed

function multiplicationtable(size::Int64)::Matrix{Int64}
    (1:size)' .* (1:size)
  end