module LuciansLusciousLasagna exposing (elapsedTimeInMinutes, expectedMinutesInOven, preparationTimeInMinutes)

-- TODO: define the expectedMinutesInOven constant
-- TODO: define the preparationTimeInMinutes function
-- TODO: define the elapsedTimeInMinutes function
expectedMinutesInOven : number
expectedMinutesInOven = 40


preparationTimeInMinutes : number -> number
preparationTimeInMinutes nbLayers = 2 * nbLayers 

elapsedTimeInMinutes : number -> number -> number
elapsedTimeInMinutes nbLayers ovenTime = preparationTimeInMinutes(nbLayers) + ovenTime

