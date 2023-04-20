# https://www.codewars.com/kata/58f5c63f1e26ecda7e000029/train/julia
function wave(s::String)
    results = String[]
    for i in eachindex(s)
        if isspace(s[i])
            continue
        end
        push!(results, s[begin: prevind(s, i)] * uppercase(s[i]) * s[nextind(s, i):end])
    end
    results
  end

  using FactCheck
facts("Basic tests") do
  @fact wave("a       b    ") --> ["A       b    ", "a       B    "]
  @fact wave("this is a few words") --> ["This is a few words", "tHis is a few words", "thIs is a few words", "thiS is a few words", "this Is a few words", "this iS a few words", "this is A few words", "this is a Few words", "this is a fEw words", "this is a feW words", "this is a few Words", "this is a few wOrds", "this is a few woRds", "this is a few worDs", "this is a few wordS"]
  @fact wave("") --> []
  @fact wave(" gap ") --> [" Gap ", " gAp ", " gaP "]
end