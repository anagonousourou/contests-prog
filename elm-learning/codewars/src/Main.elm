module Main exposing (..)


import Html exposing (text)
import Html exposing (math)
import Html exposing (datalist)
import Html exposing (s)


checkForFactor : Int -> Int -> Bool
checkForFactor factor base =
    modBy base factor == 0



-- https://www.codewars.com/kata/526c7363236867513f0005ca/train/elm


isLeap : Int -> Bool
isLeap year =
    if modBy 400 year == 0 then
        True

    else if modBy 100 year == 0 then
        False

    else
        modBy 4 year == 0



-- https://www.codewars.com/kata/56541980fa08ab47a0000040/train/elm


isBadChar c =
    Char.toCode c > Char.toCode 'm' || (Char.toCode c < Char.toCode 'a')


printerError : String -> String
printerError s =
    let
        errorCount =
            String.length (String.filter isBadChar s)

        totalCount =
            String.length s
    in
    String.fromInt errorCount ++ "/" ++ String.fromInt totalCount



-- https://www.codewars.com/kata/5a03b3f6a1c9040084001765/train/elm
-- https://byjus.com/maths/sum-of-angles-in-a-polygon/


angle : Int -> Int
angle n =
    (n - 2) * 180



-- https://www.codewars.com/kata/5aba780a6a176b029800041c/train/elm


maxMultiple : Int -> Int -> Int
maxMultiple d b =
    if modBy d b == 0 then
        b

    else
        maxMultiple d (b - 1)



-- https://www.codewars.com/kata/55fd2d567d94ac3bc9000064/train/elm


rowSumOddNumbers : Int -> Int
rowSumOddNumbers n =
    let
        nbPreviousElements =
            ((n - 1) * n) // 2
        _ =
            Debug.log "TAG" (String.fromInt nbPreviousElements)
        firstElement =
            1 + nbPreviousElements * 2
        lastElement =
            firstElement + (n - 1) * 2
    in
    ((firstElement + lastElement) * n) // 2
    


-- https://www.codewars.com/kata/5506b230a11c0aeab3000c1f/train/elm

findN : Float -> number -> Float -> Float -> number
findN currentValue n evapPerDay threshold = 
    let
      newValue = currentValue * (1 - evapPerDay / 100)
    in
        if newValue <= threshold then
            n
        else
            findN newValue (n + 1) evapPerDay threshold
    
evaporator : Float -> Float -> Float -> Int
evaporator _ evapPerDay threshold = 
    findN 100 1 evapPerDay threshold
    
-- https://www.codewars.com/kata/5fde1ea66ba4060008ea5bd9/train/elm

burner : Int -> Int -> Int -> (Int, Int, Int)
burner c h o = 
    let
        nbHydrogenForWater = h // 2
        nbWater = min nbHydrogenForWater o
        remainingHydrogen = h - nbWater * 2
        remainingOxygen = o - nbWater
        nbCo2 = min c (remainingOxygen // 2)
        remainingCarbon = c - nbCo2
        nbCh4 = min remainingCarbon (remainingHydrogen // 4)
    in
        (nbWater, nbCo2, nbCh4)


-- https://www.codewars.com/kata/566fc12495810954b1000030/train/elm
nbDig : Int -> Int -> Int    
nbDig n d =
    (List.map (\x -> x * x) (List.range 0 n)) |>
    List.map String.fromInt |>
    String.concat |>
    String.filter (\x -> (String.fromChar x) == (String.fromInt d)) |>
    String.length

-- https://www.codewars.com/kata/546e2562b03326a88e000020
    
squareDigit : Int -> Int
squareDigit a = 
    String.fromInt a |>
    String.split "" |>
    List.map (\x -> Maybe.withDefault 0 (String.toInt x)) |>
    List.map (\x -> String.fromInt(x * x)) |>
    String.concat |>
    String.toInt |>
    Maybe.withDefault 0

-- https://www.codewars.com/kata/5a420163b6cfd7cde5000077/train/elm
-- in Elm all scores are integers
nbaCup : String -> String -> String
nbaCup dta toFind = 
    dta
-- to continue

-- https://www.codewars.com/kata/56ed20a2c4e5d69155000301/train/elm

scale : String -> Int -> Int -> String
scale s k n =
    if s == "" then
        s
    else
        String.lines s |> 
        List.map (\line -> scaleinner line k n) |>
        String.join "\n"


scaleinner line k n = 
    String.split "" line |>
    List.map (\x -> (List.repeat k x) |> String.concat) |>
    String.concat |>
    List.repeat n |>
    String.join "\n"

toString b =
    if b then
        "True"

    else
        "False"


main =
    text (toString (checkForFactor 8 2))
