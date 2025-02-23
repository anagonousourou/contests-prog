package com.spa.leetcode.easy;

import java.util.Set;

public class GoatLatin {

    // https://leetcode.com/problems/goat-latin/submissions/1549669227/
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public String toGoatLatin(String sentence) {
        var words = sentence.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            if (VOWELS.contains(Character.toLowerCase(words[i].charAt(0)))) {
                words[i] = words[i] + "ma" + "a".repeat(i + 1);
            } else {
                words[i] = words[i].substring(1) + words[i].charAt(0) + "ma" + "a".repeat(i + 1);
            }
        }
        return String.join(" ", words);
    }
}
