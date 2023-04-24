module resistor_color_duo;

class ResistorColorDuo
{

    static pure int value(string[] colors)
    {
        immutable colorsToValues = [
            "black": "0",
            "brown": "1",
            "red": "2",
            "orange": "3",
            "yellow": "4",
            "green": "5",
            "blue": "6",
            "violet": "7",
            "grey": "8",
            "white": "9"
        ];
        import std.algorithm;
        import std.array;
        import std.conv;
        import std.range : take;

        return colors.take(2).map!(a => colorsToValues[a]).join().to!int;
    }
}

unittest
{
    immutable int allTestsEnabled = 1;

    // Brown and black
    assert(ResistorColorDuo.value(["brown", "black"]) == 10);

    static if (allTestsEnabled)
    {
        // Blue and grey
        assert(ResistorColorDuo.value(["blue", "grey"]) == 68);

        // Yellow and violet
        assert(ResistorColorDuo.value(["yellow", "violet"]) == 47);

        // Orange and orange
        assert(ResistorColorDuo.value(["orange", "orange"]) == 33);

        // Ignore additional colors
        assert(ResistorColorDuo.value(["green", "brown", "orange"]) == 51);
    }

}
