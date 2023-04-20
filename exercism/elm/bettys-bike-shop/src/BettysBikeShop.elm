module BettysBikeShop exposing (poundsToString, penceToPounds)

-- TODO: import the String module


penceToPounds : Float -> Float
penceToPounds pence = pence / 100.0


poundsToString : Float -> String
poundsToString pounds = "£" ++ String.fromFloat(pounds)
