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

export uint[] primeFactors(uint n)
{
	uint i = 2;
	uint[] factors = [];
	while (n > 1)
	{
		if (n % i == 0)
		{
			factors ~= i;
			n /= i;
		}
		else
		{
			i++;
		}
	}
	return factors;
}

@("Basic tests")
unittest
{

	void dotest(uint n, uint[] expected)
	{
		assert(primeFactors(n) == expected); //because("n = %d".format(n));
	}

	dotest(1, []);
	dotest(4, [2, 2]);
	dotest(8, [2, 2, 2]);
	dotest(9, [3, 3]);
	dotest(12, [2, 2, 3]);
	dotest(11_020_332, [2, 2, 3, 918_361]);
	dotest(429_496_7295, [3, 5, 17, 257, 65_537]);
	dotest(0, []);
}

export string contamination(string text, string character)
{
	import std.algorithm : map;
	import std.array : array;
	import std.range : empty;

	if (text.empty || character.empty)
	{
		return "";
	}
	return text.map!(c => character[0]).array;
}

void dotest(string text, string character, string expected)
{
	assert(contamination(text, character) == expected);
}

@("Basic tests")
unittest
{
	dotest("abc", "z", "zzz");
	dotest("", "z", "");
	dotest("abc", "", "");
	dotest("_3ebzgh4", "&", "&&&&&&&&");
	dotest("//case", " ", "      ");
}

export string addBinary(uint a, uint b)
{
	import std.format : format;

	return format("%b", a + b);
}

void dotest(uint a, uint b, string expected)
{
	assert(addBinary(a, b) == expected);
}

@("Basic tests")
unittest
{
	dotest(1, 1, "10");
	dotest(0, 1, "1");
	dotest(1, 0, "1");
	dotest(2, 2, "100");
	dotest(51, 12, "111111");
}

export string accum(string s)
{
	import std.range : repeat, take;
	import std.array : join, array;
	import std.string : capitalize;

	string[] parts = [];
	foreach (i, ch; s)
	{
		parts ~= ch.repeat.take(i + 1).array.capitalize;
	}
	return parts.join("-");
}

@("fixed tests")
unittest
{
	assert(
		accum(
			"ZpglnRxqenU") == "Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn-Uuuuuuuuuuu");
	assert(
		accum(
			"NyffsGeyylB") == "N-Yy-Fff-Ffff-Sssss-Gggggg-Eeeeeee-Yyyyyyyy-Yyyyyyyyy-Llllllllll-Bbbbbbbbbbb");
	assert(
		accum(
			"MjtkuBovqrU") == "M-Jj-Ttt-Kkkk-Uuuuu-Bbbbbb-Ooooooo-Vvvvvvvv-Qqqqqqqqq-Rrrrrrrrrr-Uuuuuuuuuuu");
	assert(
		accum(
			"EvidjUnokmM") == "E-Vv-Iii-Dddd-Jjjjj-Uuuuuu-Nnnnnnn-Oooooooo-Kkkkkkkkk-Mmmmmmmmmm-Mmmmmmmmmmm");

}

export uint sequenceSum(uint start, uint end, uint step)
{
	if (start > end)
	{
		return 0;
	}

	uint actualEnd = end;
	while ((actualEnd - start) % step != 0)
	{
		actualEnd--;
	}

	int nbElts = ((actualEnd - start) / step) + 1;
	return (start + actualEnd) * nbElts / 2;
}

@("Basic tests")
unittest
{
	assert(sequenceSum(2, 6, 2) == 12);
	assert(sequenceSum(1, 5, 1) == 15);
	assert(sequenceSum(1, 5, 3) == 5);
	assert(sequenceSum(0, 15, 3) == 45);
	assert(sequenceSum(16, 15, 3) == 0);
	assert(sequenceSum(2, 24, 22) == 26);
	assert(sequenceSum(2, 2, 2) == 2);
	assert(sequenceSum(2, 2, 1) == 2);
	assert(sequenceSum(1, 15, 3) == 35);
	assert(sequenceSum(15, 1, 3) == 0);
}

export uint zeros(uint n)
{
	import std.algorithm : min;

	auto factors = primeFactorsFor2And5(n);
	debug
	{
		import std.stdio : writeln;

		try
		{
			writeln("factors = ", factors);
		}
		catch (Exception)
		{
		}
	}
	return min(factors.get(2, 0), factors.get(5, 0));
}

uint[uint] primeFactorsFor2And5(uint upperbound)
{

	uint[uint] factors;
	foreach (n; 2 .. upperbound + 1)
	{
		if (n == 7 || n == 13 || n == 3 || n == 17)
		{
			continue;
		}
		uint i = 2;
		while (n > 1 && i < 6)
		{
			if (i == 3 || i == 4)
			{
				i++;
				continue;
			}

			if (n % i == 0)
			{
				factors[i] = factors.get(i, 0) + 1;
				n /= i;
			}
			else
			{
				i++;
			}
		}
	}

	return factors;
}

@("Number of trailing zeros of N!")
unittest
{
	assert(zeros(0) == 0);
	debug
	{
		import std.stdio : writeln;

		try
		{
			writeln(zeros(6));
		}
		catch (Exception)
		{
		}
	}
	assert(zeros(6) == 1);
	assert(zeros(12) == 2);
	debug
	{
		import std.stdio : writeln;

		try
		{
			writeln("nbzeros = ", zeros(30));
		}
		catch (Exception)
		{
		}
	}
	assert(zeros(30) == 7);
}
