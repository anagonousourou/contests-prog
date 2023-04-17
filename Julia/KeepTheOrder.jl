module KeepOrder
  export keeporder
  function keeporder(ary, val)
    result = findfirst(x -> x >= val, ary)
    result === nothing ? length(ary) + 1 : result
  end
end