package com.spa.leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class ValidParentheses {

    // https://leetcode.com/problems/valid-parentheses/submissions/1167908691/

        private static final Set<String> OPENING_BRACKETS = Set.of("(", "{", "[");
    private static final Set<String> CLOSING_BRACKETS = Set.of(")", "}", "]");
    private static final Map<String, String> MATCHING_BRACKETS = Map.of("(", ")", "{", "}", "[", "]");
    public boolean isValid(String s) {
        return isPairedRecursive(s, new LinkedList<>());
    }

        public static boolean isPairedRecursive(String brackets, Deque<String> bracketsStacks) {
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
