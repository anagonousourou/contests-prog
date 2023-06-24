// A constant for the Earth orbital period in seconds
const int EARTH_ORBITAL_PERIODS = 31557600;

// A mapping of planet names and their orbital periods relative to Earth
map<float> orbitalPeriods = {"Mercury": 0.2408467, "Venus": 0.61519726, "Earth": 1.0, "Mars": 1.8808158, "Jupiter": 11.862615, "Saturn": 29.447498, "Uranus": 84.016846, "Neptune": 164.79132};

# Returns the age on another planet or error if it is not a planet.
#
# + planet - planet name as a string
# + seconds - person's age measured in seconds
# + return - person's age in years of that planet, or error if unknown planet.
function age(string planet, int seconds) returns float|error {
    // Check if the planet name is valid
    if (orbitalPeriods.hasKey(planet)) {
        // Get the orbital period of the planet
        float period = orbitalPeriods.get(planet);
        // Calculate the age on the planet by dividing the seconds by the Earth orbital period and then by the planet's orbital period
        float age = (<float>seconds / EARTH_ORBITAL_PERIODS) / period;
        // Return the age as a float value
        return age.round(2);
    } else {
        // Return an error if the planet name is unknown
        return error("not a planet");
    }
}
