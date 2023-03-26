import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class WordCount {
    public Map<String, Integer> phrase(String input) {
        return frequencies(reSeq(
                Pattern.compile("\\p{Alnum}+'+\\p{Alnum}+|\\p{Alnum}+"), input.toLowerCase()));
    }

    /**
     * reSeq(Pattern.compile("\\p{Alpha}+"), "Hello, World7 '17") => [Hello, World]
     * reSeq(Pattern.compile("\\d+"), "Hello, World 17")          => [17]
     *
     * @param re    regex
     * @param input the input
     * @return return the tokens matching the regex re
     */
    public static List<String> reSeq(Pattern re, String input) {
        List<String> tokens = new ArrayList<>();
        Matcher m = re.matcher(input);

        while (m.find()) {
            tokens.add(m.group());
        }
        return tokens;
    }

    public static <A> Map<A, Integer> frequencies(List<A> elements) {
        return elements.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.reducing(0, e -> 1, Integer::sum)));
    }
}
