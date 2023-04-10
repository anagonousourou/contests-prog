const alphabets = join('a':'z')
function rotate(shiftcount, message::AbstractString)
    cipherAlphabets = string(alphabets[shiftcount + 1:26], alphabets[1:shiftcount])
    alphabetsToCipher = Dict(zip(alphabets, cipherAlphabets))
    collect(message) |> x -> map(letter -> islowercase(letter) ? get(alphabetsToCipher, letter, letter) : uppercase(get(alphabetsToCipher, lowercase(letter), letter)), x) |> join
end

function rotate(shiftcount, letter::AbstractChar)
    cipherAlphabets = string(alphabets[shiftcount + 1:26], alphabets[1:shiftcount])
    alphabetsToCipher = Dict(zip(alphabets, cipherAlphabets))
    islowercase(letter) ? get(alphabetsToCipher, letter, letter) : uppercase(get(alphabetsToCipher, letter, letter))
end