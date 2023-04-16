module Solution
  export rangeextraction
  
  function rangeextraction(list)
    isempty(list) && return ""
    from = list[1]
    to = list[1]
    result = []
    for i in 1:length(list) - 1
        if list[i] + 1 == list[i+1]
            to = list[i+1]
        else 
            push!(result, (from, to))
            from = list[i+1]
            to = list[i+1]
        end
    end
    push!(result, (from, to))
    map(elt ->  elt[1] == elt[2] ? string(elt[1]) : (elt[2] - elt[1] > 1 ?  "$(elt[1])-$(elt[2])" : "$(elt[1]),$(elt[2])"), result) |> x -> join(x, ",")
  end
end

using FactCheck
using .Solution
facts("Example test") do
  @fact rangeextraction([-6 -3 -2 -1 0 1 3 4 5 7 8 9 10 11 14 15 17 18 19 20]) == "-6,-3-1,3-5,7-11,14,15,17-20"
end