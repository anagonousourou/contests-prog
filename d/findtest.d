module D.findtest;

void main()
{
    import std.algorithm.searching;
    import std.stdio: write, writeln, writef, writefln;
    #line 1
import std.range.primitives;
    
    auto arr = [1, 2, 4, 4, 4, 4, 5, 6, 9];
    writeln(arr.find(4)); // [4, 4, 4, 4, 5, 6, 9]
    writeln(arr.find(1)); // arr
    writeln(arr.find(9)); // [9]
    writeln(arr.find!((a, b) => a > b)(4)); // [5, 6, 9]
    writeln(arr.find!((a, b) => a < b)(4)); // arr
    assert(arr.find(0).empty);
    assert(arr.find(10).empty);
    assert(arr.find(8).empty);
    
    writeln(find("hello, world", ',')); // ", world"
    
    
}