module d.scratch;
import std.stdio;

int perThread;
shared int perProcess;


void main()
{
    import std.random;
    import std.array : array;
    import std.range : generate, takeExactly;
    import std.conv;

    auto part1 = generate!(() => uniform!"[]"('A', 'Z')).takeExactly(2).array.to!string;
    auto part2 = generate!(() => uniform!"[]"('0', '9')).takeExactly(3).array.to!string;

    writeln(part1 ~ part2);
}

void pangram_scratch()
{
    import std.stdio;
    import std.uni;

    bool[char] charseen;
    string name = "The brown fox Machin.".toLower;
    foreach (key; name)
    {
        if (isAlpha(key))
        {
            charseen[key] = true;
            writeln(key);
        }

    }
    writeln(charseen.length == 26);
}

void miscellaneous()
{
    import std.conv;
    import std.algorithm;
    import std.array;
    import std.range;
    import std.math;

    int n = 150;
    string nstring = n.to!string;

    writeln(nstring.map!(a => (a - '0') ^^ nstring.length).sum() == n);

    writeln(iota(1, (n / 2) + 1).filter!(a => n % a == 0).sum());

    writeln(typeid("hello, world"[1 .. $]));

    writeln(sqrt(-5.0));
}
bool isPrime(long n)
{
    import std.math : sqrt;

    if (n <= 1)
    {
        return false;
    }
    int limit = cast(int) sqrt(cast(float) n);
    for (int i = 2; i <= limit; i++)
    {
        if (n % i == 0)
        {
            return false;
        }
    }
    return true;
}

void nthprime()
{
    import std.range;
    import std.algorithm;
    import std.stdio : say = writeln; 
    auto naturalNumbers = recurrence!((a, n) => n)(0);
    say(naturalNumbers.filter!isPrime().take(10_001).drop(10_000).front());
}


