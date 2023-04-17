module LongestConsec
    export longest_consec
    function longest_consec(strarr::Array{String}, k::Int)::String
        (k > length(strarr) || k <= 0) && return ""
       joinedstrings = map(join, partitionstep(strarr, k - 1, 1))
       maxlength = maximum(map(length, joinedstrings))
       longestindex = findfirst(x -> length(x) == maxlength, joinedstrings)
       joinedstrings[longestindex]
    end

    partitionstep(data, k, step) = [data[i:i+k] for i=1:step:length(data)-k]
end




using FactCheck
using .LongestConsec

facts("longest_consec") do

    function testing(arr, k, expect)
        actual = longest_consec(arr, k)
        println("Actual ", actual)
        println("Expect ", expect)
        @fact actual --> expect "longest_consec($(arr), $(k))"
    end

    context("fixed tests") do
        testing(["zone", "abigail", "theta", "form", "libe", "zas"], 2, "abigailtheta")
        testing(["ejjjjmmtthh", "zxxuueeg", "aanlgjrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"], 1, "oocccffuucccjjjkkkjyyyeehh")
        testing(["itvayloxrp","wkppqsztdkmvcuwvereiupccauycnjutlv","vweqilsfytihvrzlaodfixoyxvyuyvgpck"], 2, "wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck")
        testing(["zone", "abigail", "theta", "form", "libe", "zas"], -2, "")
        testing(["wlwsasphmxx","owiaxujylentrklctozmymu","wpgozvxxiu"], 2, "wlwsasphmxxowiaxujylentrklctozmymu")
        testing(["it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"], 3, "ixoyx3452zzzzzzzzzzzz")
        testing(["it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"], 15, "")
        testing(["it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"], 0, "")
        testing(String[], 3, "")
    end
end