import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram {
    private final String word;

    public Anagram(String word){
        this.word = word;
    }

    List<String> match(List<String> words){
        return words.stream().filter(w -> frequencies(w).equals(frequencies(this.word)) && !w.equalsIgnoreCase(this.word)).collect(Collectors.toList());
    }

    /**
     * Compute the frequency of the characters of the String in a case-insensitive way
     *
     * @param elements a string
     * @return frequency of the character of elements
     */
    public static Map<Character, Long> frequencies(String elements) {
        return elements.toLowerCase().chars().mapToObj(a -> (char) a).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
