import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TwelveDays {
    static List<String> presents = List.of("twelve Drummers Drumming", "eleven Pipers Piping",
            "ten Lords-a-Leaping", "nine Ladies Dancing", "eight Maids-a-Milking",
            "seven Swans-a-Swimming", "six Geese-a-Laying", "five Gold Rings", "four Calling Birds",
            "three French Hens", "two Turtle Doves", "a Partridge in a Pear Tree");
    static List<String> dayNumber = List.of("first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth",
            "eleventh", "twelfth");

    String verse(int verseNumber) {
        return String.format("On the %s day of Christmas my true love gave to me: %s.\n", dayNumber.get(verseNumber - 1), combine(presents.subList(presents.size() - verseNumber, presents.size())));

    }

    String verses(int startVerse, int endVerse) {
        return IntStream.rangeClosed(startVerse, endVerse).mapToObj(this::verse).collect(Collectors.joining("\n"));
    }

    public static String combine(List<String> words) {
        if (words.size() == 1) {
            return words.get(0);
        }
        if (words.size() == 2) {
            return String.join(", and ", words);
        }
        return String.join(", ", words.subList(0, words.size() - 1)) + ", and " + words.get(words.size() - 1);
    }

    String sing() {
        return verses(1, 12);
    }
}
