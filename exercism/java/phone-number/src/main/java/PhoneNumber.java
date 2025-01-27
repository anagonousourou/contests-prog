import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PhoneNumber {
    private static final Pattern PUNCTUATION_REGEX = Pattern.compile("\\p{Punct}");

    private static final Pattern LETTER_REGEX = Pattern.compile("\\p{Alpha}");

    private static Map<String, String> FORBIDDEN_STARTING_DIGITS = Map.of("0", "zero", "1", "one");
    
    private String number;


    public PhoneNumber(String input) {
        if (LETTER_REGEX.matcher(input).find()) {
            throw new IllegalArgumentException("letters not permitted");
        }

        List<String> digits = reSeq(Pattern.compile("\\d"), input);
        if (PUNCTUATION_REGEX.matcher(input).find() && (digits.size() > 11 || digits.size() < 10)) {
            throw new IllegalArgumentException("punctuations not permitted");
        }
        if (digits.size() < 10) {
            throw new IllegalArgumentException("incorrect number of digits");
        }
        if (digits.size() > 11) {
            throw new IllegalArgumentException("more than 11 digits");
        }
        if (digits.size() == 11) {
            if (!"1".equals(digits.get(0))) {
                throw new IllegalArgumentException("11 digits must start with 1");
            }
            digits = digits.subList(1, digits.size());
        }
        if (FORBIDDEN_STARTING_DIGITS.containsKey(digits.get(0))) {
            throw new IllegalArgumentException(
                    "area code cannot start with " + FORBIDDEN_STARTING_DIGITS.get(digits.get(0)));
        }

        if (FORBIDDEN_STARTING_DIGITS.containsKey(digits.get(3))) {
            throw new IllegalArgumentException(
                    "exchange code cannot start with " + FORBIDDEN_STARTING_DIGITS.get(digits.get(3)));
        }

        this.number = digits.stream().collect(Collectors.joining());

    }

    public String getNumber() {
        return number;
    }

    /**
     * reSeq(Pattern.compile("\\p{Alpha}+"), "Hello, World7 '17") => [Hello, World]
     * reSeq(Pattern.compile("\\d+"), "Hello, World 17") => [17]
     *
     * @param re    regex
     * @param input the input
     * @return return the tokens matching the regex re
     */
    private static List<String> reSeq(Pattern re, String input) {
        List<String> tokens = new ArrayList<>();
        Matcher m = re.matcher(input);

        while (m.find()) {
            tokens.add(m.group());
        }
        return tokens;
    }
}