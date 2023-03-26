import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BeerSong {

    public String singSong() {
        return sing(99, 100);
    }

    public String sing(int a, int b) {
        return Stream.iterate(a, i -> i - 1).map(BeerSong::generateVerse).limit(b).collect(Collectors.joining());
    }

    public static String generateVerse(int verseNumber) {
        if (verseNumber == 0) {
            return """
                    No more bottles of beer on the wall, no more bottles of beer.
                    Go to the store and buy some more, 99 bottles of beer on the wall.
                    
                    """;
        }
        if (verseNumber == 1) {
            return """
                    1 bottle of beer on the wall, 1 bottle of beer.
                    Take it down and pass it around, no more bottles of beer on the wall.
                    
                    """;
        }
        return String.format("""
                %d bottles of beer on the wall, %d bottles of beer.
                Take one down and pass it around, %d bottle%s of beer on the wall.
                
                """, verseNumber, verseNumber, verseNumber - 1, verseNumber -1 > 1 ? "s" : "");
    }
}
