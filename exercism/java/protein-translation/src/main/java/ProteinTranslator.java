import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ProteinTranslator {

    static final Set<String> STOPS = Set.of("UAA", "UAG", "UGA");

    Map<String, String> mapping = Map.ofEntries(
            Map.entry("AUG", "Methionine"),
            Map.entry("UUU", "Phenylalanine"),
            Map.entry("UUC", "Phenylalanine"),
            Map.entry("UUA", "Leucine"),
            Map.entry("UUG", "Leucine"),
            Map.entry("UCU", "Serine"),
            Map.entry("UCC", "Serine"),
            Map.entry("UCA", "Serine"),
            Map.entry("UCG", "Serine"),
            Map.entry("UGG", "Tryptophan"),
            Map.entry("UGC", "Cysteine"),
            Map.entry("UGU", "Cysteine"),
            Map.entry("UAC", "Tyrosine"),
            Map.entry("UAU", "Tyrosine")
    );

    List<String> translate(String rnaSequence) {
        return reSeq(Pattern.compile("\\w{3}"), rnaSequence).stream().takeWhile(codon -> !STOPS.contains(codon)).map(mapping::get)
                .toList();

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
}
