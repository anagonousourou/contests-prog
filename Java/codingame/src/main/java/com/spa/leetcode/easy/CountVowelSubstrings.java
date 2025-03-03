package com.spa.leetcode.easy;

import java.util.Set;
import java.util.stream.Collectors;

public class CountVowelSubstrings {

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    // https://leetcode.com/problems/count-vowel-substrings-of-a-string/submissions/1549590994/
    public int countVowelSubstrings(String word) {
        int n = 0;
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 5; j <= word.length(); j++) {
                if (VOWELS.equals(word.substring(i, j).chars().mapToObj(c -> (char) c).collect(Collectors.toSet()))) {
                    n++;
                }
            }
        }
        return n;
    }
}
