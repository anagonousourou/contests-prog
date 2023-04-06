const handshakes = [1 => "wink", 2 => "double blink", 3 => "close your eyes", 4 => "jump"]

function secret_handshake(code)
    handshakes_result = []
    codestring = bitstring(Int8(code)) |> reverse
    for (index, action) in handshakes 
        if codestring[index] == '1'
            push!(handshakes_result, action)
        end
    end
    if codestring[5] == '1'
        handshakes_result |> reverse |> collect
    else
        handshakes_result
    end 
end