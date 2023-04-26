module crypto;

string computeNormalizedPlainText(string input)
{
    import std.ascii : isAlphaNum;
    import std.algorithm : filter;
    import std.conv : to;
    import std.uni : toLower;

    return input
        .filter!isAlphaNum
        .to!string
        .toLower();
}

uint computeSize(string input)
{

    import std.math : sqrt;

    auto l = input.length;
    auto sqrtL = cast(int) sqrt(cast(float) l);
    return sqrtL * sqrtL == l ? sqrtL : sqrtL + 1;
}

string cipherText(string[] cipherTextSegments)
{
    import std.array : join;

    return join(cipherTextSegments, " ");
}

class Cipher
{
    private string input;
    private string _normalizePlainText;
    private uint _size;

    this(string input)
    {
        this.input = input;
        this._normalizePlainText = computeNormalizedPlainText(this.input);
        this._size = computeSize(this._normalizePlainText);
    }

    string normalizePlainText()
    {
        return this._normalizePlainText;
    }

    uint size()
    {
        return this._size;
    }

    string[] plainTextSegments()
    {
        import std.regex : regex, matchAll;
        import std.format : format;
        import std.array : array;
        import std.algorithm : map;

        auto myregex = format(".{1,%s}", this._size).regex();

        return matchAll(this._normalizePlainText, myregex).map!(a => a[0]).array();
    }

    string cipherText()
    {
        import std.array : appender;

        auto cipherString = appender!string();
        auto textSegments = plainTextSegments();

        for (int j = 0; j < this._size; j++)
        {
            for (int i = 0; i < textSegments.length; i++)
            {
                if (j < textSegments[i].length)
                {
                    cipherString.put(textSegments[i][j]);
                }

            }
        }

        return cipherString.data();

    }

    string[] normalize()
    {
        import std.array : appender;

        string[] results;

        auto textSegments = plainTextSegments();

        for (int j = 0; j < this._size; j++)
        {
            auto cipherString = appender!string();
            for (int i = 0; i < textSegments.length; i++)
            {
                if (j < textSegments[i].length)
                {
                    cipherString.put(textSegments[i][j]);
                }

            }
            results ~= cipherString.data();
        }

        return results;
    }
}

unittest
{
    immutable int allTestsEnabled = 0;

    // normalize_strange_characters
    {
        auto theCipher = new Cipher("s#$%^&plunk");

        assert("splunk" == theCipher.normalizePlainText());
    }

    // normalize_numbers
    {
        auto theCipher = new Cipher("1, 2, 3 GO!");
        assert("123go" == theCipher.normalizePlainText());
    }

    // size_of_small_square
    {
        auto theCipher = new Cipher("1234");
        assert(2U == theCipher.size());
    }

    // size_of_slightly_larger_square
    {
        auto theCipher = new Cipher("123456789");
        assert(3U == theCipher.size());
    }
    // size_of_non_perfect_square
    {
        auto theCipher = new Cipher("123456789abc");
        assert(4U == theCipher.size());
    }

    // size_of_non_perfect_square_less
    {
        auto theCipher = new Cipher("zomgzombies");
        assert(4U == theCipher.size());
    }

    // plain_text_segments_from_phrase
    {
        const string[] expected = [
            "neverv", "exthin", "eheart", "withid", "lewoes"
        ];
        auto theCipher = new Cipher("Never vex thine heart with idle woes");
        const auto actual = theCipher.plainTextSegments();

        assert(expected == actual);
    }

    // plain_text_segments_from_complex_phrase
    {
        const string[] expected = ["zomg", "zomb", "ies"];
        auto theCipher = new Cipher("ZOMG! ZOMBIES!!!");
        const auto actual = theCipher.plainTextSegments();

        assert(expected == actual);
    }

    // Cipher_text_short_phrase
    {
        auto theCipher = new Cipher("Time is an illusion. Lunchtime doubly so.");
        debug { import std.stdio : writeln; try { writeln(theCipher.cipherText()); } catch (Exception) {} }
        assert("tasneyinicdsmiohooelntuillibsuuml" == theCipher.cipherText());
    }

    // Cipher_text_long_phrase
    {
        auto theCipher = new Cipher("We all know interspecies romance is weird.");
        assert("wneiaweoreneawssciliprerlneoidktcms" == theCipher.cipherText());
    }


    static if (allTestsEnabled)
    {

    // normalized_Cipher_text1
    {
        auto theCipher = new Cipher("Madness, and then illumination.");
        assert("msemo aanin dnin ndla etlt shui" == theCipher.normalize.cipherText());
    }

    // normalized_Cipher_text2
    {
        auto theCipher = new Cipher("Vampires are people too!");
        assert("vrel aepe mset paoo irpo" == theCipher.normalize.cipherText());
    }
    }

}
