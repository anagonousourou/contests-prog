import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
 * https://docs.oracle.com/javase/8/docs/api/java/util/regex/Matcher.html
 * https://www.baeldung.com/java-substring
 * https://www.baeldung.com/java-lowercase-uppercase-special-character-digit-regex
 */
class SqueakyClean {

    private static Pattern kebabPattern = Pattern.compile("-\\p{Ll}");

    static String clean(String identifier) {
        identifier = identifier.replace(" ", "_");
        identifier = identifier.replaceAll("\\p{Cntrl}", "CTRL");
        String[] identifierPieces = kebabPattern.split(identifier);
        Matcher matcher = kebabPattern.matcher(identifier);
        if (identifierPieces.length > 1) {
            StringBuilder identifierBuilder = new StringBuilder();
            for (String identifierPart : identifierPieces) {
                identifierBuilder.append(identifierPart);
                if (matcher.find()) {
                    identifierBuilder.append(matcher.group().substring(1).toUpperCase());
                }
            }
            identifier = identifierBuilder.toString();
        }

        identifier = identifier.codePoints()
                .filter(mychar -> (Character.toChars(mychar).length == 1 && Character.toChars(mychar)[0] == '_')
                        || Character.isLetter(mychar))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

        return identifier.replaceAll("[α-ω]", "");
    }
}
