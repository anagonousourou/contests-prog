import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class BracketChecker {
    private final String input;
    private static final Set<String> OPENING_BRACKETS = Set.of("(", "{", "[");
    private static final Set<String> CLOSING_BRACKETS = Set.of(")", "}", "]");
    private static final Map<String, String> MATCHING_BRACKETS = Map.of("(", ")", "{", "}", "[", "]");

    public BracketChecker(String input) {
        this.input = input;
    }

    public boolean areBracketsMatchedAndNestedCorrectly() {
        Stack<String> bracketsStacks = new Stack<>();
        return isPairedRecursive(this.input, bracketsStacks);
    }

    private boolean isPairedRecursive(String brackets, Stack<String> bracketsStacks) {
        String first = brackets.isEmpty() ? "" : brackets.substring(0, 1);
        String rest = brackets.isEmpty() ? "" : brackets.substring(1);
        if (brackets.isEmpty()) {
            return bracketsStacks.isEmpty();
        } else if (OPENING_BRACKETS.contains(first)) {
            bracketsStacks.push(MATCHING_BRACKETS.get(first));
            return isPairedRecursive(rest, bracketsStacks);
        } else if (CLOSING_BRACKETS.contains(first) && !bracketsStacks.isEmpty() && first.equals(bracketsStacks.peek())) {
            bracketsStacks.pop();
            return isPairedRecursive(rest, bracketsStacks);
        } else if (CLOSING_BRACKETS.contains(first) && (bracketsStacks.isEmpty() || !first.equals(bracketsStacks.peek()))) {
           return false;
        } else {
            return isPairedRecursive(rest, bracketsStacks);
        }
    }
}