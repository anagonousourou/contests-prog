module D.scratch;
import std.stdio;

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



void main()
{
    import std.conv;
    import std.algorithm;
    import std.array;
    import std.range;
    
    
    int n = 150;
    string nstring = n.to!string;

    writeln(nstring.map!(a => (a - '0') ^^ nstring.length).sum() == n);

    writeln(iota(1, (n/2) + 1).filter!(a =>  n % a == 0).sum());

    writeln(typeid("hello, world"[1 .. $]));
}
