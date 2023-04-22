#https://www.codewars.com/kata/54fb853b2c8785dd5e000957

function chain(input, fs)
    ∘(reverse(fs)...)(input)
end

function add(num) 
    return num + 1
end
  
function mult(num) 
    return num * 30
end
  