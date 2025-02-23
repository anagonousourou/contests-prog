.year |  if (. % 400) == 0 then true
  elif (. % 100) == 0 then false
  else (. % 4) == 0
  end