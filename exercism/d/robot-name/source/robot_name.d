module robot;

import std.regex;
import std.stdio;

class Robot
{

    string name;
    static bool[string] usedNames;
    static int collisons = 0;
    this()
    {
        this.name = generateName();
    }

    void reset()
    {
        this.name = generateName();
    }

    static string generateName()
    {
        import std.random;
        import std.array : array;
        import std.range : generate, takeExactly;
        import std.conv;

        bool hasCollision = false;

        string robotName;
        do
        {
            auto part1 = generate!(() => uniform!"[]"('A', 'Z')).takeExactly(2).array.to!string;
            auto part2 = generate!(() => uniform!"[]"('0', '9')).takeExactly(3).array.to!string;
            robotName = part1 ~ part2;
            if (usedNames != null)
            {

                auto hasName = robotName in usedNames;
                if (hasName !is null)
                {
                    collisons++;
                    hasCollision = true;
                }
                else
                {
                    hasCollision = false;
                }
            }

        }
        while (hasCollision);
        usedNames[robotName] = true;
        return robotName;
    }
}

unittest
{

    // test for properly formatted name
    {
        auto pattern = regex(`^[A-Z]{2}\d{3}`);
        auto theRobot = new Robot();

        // test the regex pattern
        assert(matchAll("VAV224", pattern).empty);
        assert(matchAll("V221", pattern).empty);
        assert(matchAll("190", pattern).empty);
        assert(matchAll("12345", pattern).empty);
        assert(matchAll("SB1", pattern).empty);
        assert(matchAll("TT", pattern).empty);

        writefln("Robot name: %s", theRobot.name);

        // test that the name respects the pattern
        // that is: "2 uppercase letters followed by 3 digits"
        assert(!matchAll(theRobot.name, pattern).empty);
    }
    // test name stickiness
    {
        auto theRobot = new Robot();
        auto name = theRobot.name;

        writefln("Robot name: %s", theRobot.name);
        assert(name == theRobot.name);
    }

    // test different names for different Robots
    {
        auto erTwoDeeTwo = new Robot();
        auto beeBeeEight = new Robot();

        writefln("Robot name: %s", erTwoDeeTwo.name);
        writefln("Robot name: %s", beeBeeEight.name);
        assert(erTwoDeeTwo.name != beeBeeEight.name);
    }

    // test name reset
    {
        auto theRobot = new Robot();
        auto nameOne = theRobot.name;
        theRobot.reset();
        auto nameTwo = theRobot.name;

        writefln("Robot name: %s", nameOne);
        writefln("Robot name: %s", nameTwo);
        assert(nameOne != nameTwo);
    }

    // collision test
    {
        foreach (i; 1 .. 10000)
        {
            auto theRobot = new Robot();
        }

        writefln("Collisons: %s that is %s%%", Robot.collisons,
            (Robot.collisons / 10000.0f) * 100);
    }
    immutable int allTestsEnabled = 0;

    static if (allTestsEnabled)
    {

    }

}
