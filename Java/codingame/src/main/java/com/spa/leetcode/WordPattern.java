package com.spa.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    /**
     * https://leetcode.com/problems/word-pattern/
     *
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        return wordPattern(pattern, s.split(" "), new HashMap<>());
    }

    private boolean wordPattern(String pattern, String[] words, Map<Character, String> matches) {

        if (!pattern.isEmpty() && words.length > 0) {
            char currentChar = pattern.charAt(0);
            if (matches.containsKey(currentChar) && !matches.get(currentChar).equals(words[0])) {
                return false;
            } else if (!matches.containsKey(currentChar) && matches.containsValue(words[0])) {
                return false;
            } else if (matches.containsKey(currentChar) && matches.containsValue(words[0])) {
                return wordPattern(pattern.substring(1), Arrays.copyOfRange(words, 1, words.length), matches);
            } else if (!matches.containsKey(currentChar) && !matches.containsValue(words[0])) {
                matches.put(currentChar, words[0]);
                return wordPattern(pattern.substring(1), Arrays.copyOfRange(words, 1, words.length), matches);
            }

        } else if (pattern.isEmpty() && words.length == 0) {
            return true;
        }
        return false;
    }
}
