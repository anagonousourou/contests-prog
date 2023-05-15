import std.stdio;

void main()
{
	writeln("Edit source/app.d to start your project.");
}

export string derive(uint coefficient, uint exponent)
{
	import std.format : format;

	if (exponent > 2)
	{
		return format("%dx^%d", coefficient * exponent, exponent - 1);
	}
	else
	{
		return format("%dx", coefficient * exponent);
	}
}

unittest
{
	assert(derive(7, 8) == "56x^7");
	assert(derive(5, 9) == "45x^8");
}

//

/** 
 * https://www.codewars.com/kata/58ca658cc0d6401f2700045f/train/d
 */
export uint[] findMultiples(uint n, uint limit)
{
	uint[] multiples = [n];
	auto m = n * 2;
	while (m <= limit)
	{
		multiples ~= m;
		m += n;
	}
	return multiples;
}

@("Basic tests")
unittest
{
	assert(findMultiples(1, 2) == [1, 2]);
	assert(findMultiples(5, 7) == [5]);
	assert(findMultiples(4, 27) == [4, 8, 12, 16, 20, 24]);
	assert(findMultiples(11, 54) == [11, 22, 33, 44]);
	assert(findMultiples(5, 25) == [5, 10, 15, 20, 25]);
}

export int makeNegative(int number)
{
	return number > 0 ? -number : number;
}

@("Positive test")
unittest
{
	assert(makeNegative(42) == -42);
}

@("Negative test")
unittest
{
	assert(makeNegative(-9) == -9);
}

@("Zero test")
unittest
{
	assert(makeNegative(0) == 0);
}

export ubyte[] digitize(ulong n)
{
	import std.conv : to;
	import std.algorithm : map, reverse;
	import std.array : array;

	return (n.to!string).map!(c => cast(ubyte)(c - '0')).array.reverse;
}

@("Fixed tests")
unittest
{
	assert(digitize(348_597) == [7, 9, 5, 8, 4, 3]);
	assert(digitize(35_231) == [1, 3, 2, 5, 3]);
	assert(digitize(0) == [0]);
	assert(digitize(23_582_357) == [7, 5, 3, 2, 8, 5, 3, 2]);
	assert(digitize(984_764_738) == [8, 3, 7, 4, 6, 7, 4, 8, 9]);
	assert(digitize(45_762_893_920) == [0, 2, 9, 3, 9, 8, 2, 6, 7, 5, 4]);
	assert(digitize(548_702_838_394) == [4, 9, 3, 8, 3, 8, 2, 0, 7, 8, 4, 5]);
}

export int positiveSum(const int[] arr)
{
	import std.algorithm : filter, sum;

	return arr.filter!(a => a > 0).sum;
}

@("Basic tests for positiveSum")
unittest
{
	assert(positiveSum([1, 2, 3, 4, 5]) == 15);
	assert(positiveSum([1, -2, 3, 4, 5]) == 13);
	assert(positiveSum([-1, 2, 3, 4, -5]) == 9);
	assert(positiveSum(null) == 0);
	assert(positiveSum([-1, -2, -3, -4, -5]) == 0);
}

export bool isDivisible(uint n, uint a, uint b)
{
	return n % a == 0 && n % b == 0;
}

@("Basic tests isDivisible")
unittest
{
	assert(isDivisible(3, 2, 2) == false);
	assert(isDivisible(3, 3, 4) == false);
	assert(isDivisible(12, 3, 4) == true);
	assert(isDivisible(8, 3, 4) == false);
}

export string repeatStr(string str, uint count)
{
	import std.range : repeat;
	import std.array : join;

	return str.repeat(count).join;
}

@("Basic tests repeatStr")
unittest
{
	assert(repeatStr("a", 4) == "aaaa");
	assert(repeatStr("hello ", 3) == "hello hello hello ");
	assert(repeatStr("abc", 2) == "abcabc");
}

export ulong[] powersOfTwo(uint n)
{
	import std.algorithm : map;
	import std.range : iota;
	import std.array : array;

	return iota(0, n + 1).map!(x => (cast(ulong) 2) ^^ x).array;
}

@("Basic tests powersOfTwo")
unittest
{
	assert(powersOfTwo(0) == [1]);
	assert(powersOfTwo(1) == [1, 2]);
	assert(powersOfTwo(4) == [1, 2, 4, 8, 16]);
}

import std.bigint;

BigInt core(int m, uint function(uint, uint) operation)
{
	BigInt s = 0;
	foreach (x; 1 .. m + 1)
	{
		foreach (y; x .. m + 1)
		{
			s += (x == y ? operation(x, y) : 2 * operation(x, y));
		}
	}
	return s;
}

export BigInt sumin(int m)
{
	return core(m, (a, b) => a < b ? a : b);
}

export BigInt sumax(int m)
{
	return core(m, (a, b) => a > b ? a : b);
}

export BigInt sumsum(int m)
{
	return core(m, (a, b) => a + b);
}

void dotest(string name, BigInt function(int) f, int n, BigInt exp)
{
	BigInt actual = f(n);
	assert(actual == exp);
}

@("fixed tests")
unittest
{
	dotest("sumax", &sumax, 5, BigInt(95));
	dotest("sumax", &sumax, 6, BigInt(161));

	dotest("sumin", &sumin, 5, BigInt(55));
	dotest("sumin", &sumin, 6, BigInt(91));

	dotest("sumsum", &sumsum, 8, BigInt(576));
	dotest("sumsum", &sumsum, 730, BigInt(389_549_900));
}
