@enum DIRECTION NORTH=1 WEST=2 EAST=3 SOUTH=4


struct Point
    x::Int
    y::Int
end

mutable struct Robot
    x::Int
    y::Int
    direction::DIRECTION
    Robot(p, d) = new(p[1], p[2], d)
end

function position(r::Robot)
   Point(r.x, r.y)
end 

function heading(r::Robot)
    r.direction
end

const nextdirectionright = Dict(NORTH => EAST, WEST => NORTH, EAST => SOUTH, SOUTH => WEST)
function turn_right!(r::Robot)
    r.direction = nextdirectionright[r.direction]
    r
end
const nextdirectionleft = Dict(NORTH => WEST, WEST => SOUTH, EAST => NORTH, SOUTH => EAST)
function turn_left!(r::Robot)
    r.direction = nextdirectionleft[r.direction]
    r
end

function advance!(r::Robot)
    if r.direction == NORTH
        r.y += 1
    elseif r.direction == WEST
        r.x -= 1
    elseif r.direction == SOUTH
        r.y -= 1
    else
        r.x += 1
    end
    return r
end

const actionToFunction = Dict('A' => advance!, 'R' => turn_right!, 'L' => turn_left!)
function move!(r::Robot, actions::AbstractString)
    for action in actions
        actionToFunction[action](r)
    end
    return r
end
    

