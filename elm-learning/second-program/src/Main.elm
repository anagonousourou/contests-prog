module Main exposing (..)

import Browser
import Html exposing (div, text)
import Html exposing (input)
import Html.Events exposing (onClick)
import Html exposing (button)


type Message = 
    Add
add a b = a + b
init =
    { value = 0}

view model =
    div [] [
            text ("Your Second Elm Program " ++ String.fromInt model.value),
            input [] [],
            button [onClick Add][text "Add"]
        ]

update action  model =
    { value = model.value + 1}

main =
    Browser.sandbox
        {
            init = init,
            view = view,
            update = update
        }