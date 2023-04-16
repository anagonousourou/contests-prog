module Solution
export rgb

    hex(n) = string(n, base=16, pad = 2) |> uppercase
    function rgb(r, g, b)
        min.(255, [r, g, b]) |> x -> max.(0, x) |> x ->  hex.(x) |> join
    end

    #=Alternative solution from https://www.codewars.com/users/zcassini
    function rgb(args...)
  string.(clamp.(args, 0, 255), base = 16, pad = 2) |> join |> uppercase
end
    =#
end



using FactCheck

if VERSION < v"1"
  using Solution
else
  rgb = Solution.rgb
end

facts("Testing rgb") do
  context("Sample Tests") do
    @fact rgb(0, 0, 0) --> "000000"
    @fact rgb(0, 0, -20) --> "000000"
    @fact rgb(300, 255, 255) --> "FFFFFF"
    @fact rgb(173, 255, 47) --> "ADFF2F"
  end
end