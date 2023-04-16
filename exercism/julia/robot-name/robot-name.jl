const usedNames = Set{String}()
mutable struct Robot    
    name::String    
end

function Robot()
    Robot(makeuniquename())
end

function makeuniquename()::String
    new_name = cat(rand('A':'Z',2), rand('0':'9',3), dims = 1) |> join
    while new_name ∈ usedNames
        new_name = cat(rand('A':'Z',2), rand('0':'9',3), dims = 1) |> join
    end
    push!(usedNames, new_name)
    new_name
end

function reset!(instance::Robot)
    instance.name = makeuniquename()
end

function name(instance::Robot)
    instance.name
end
