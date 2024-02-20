package com.spa.leetcode;

import java.util.Set;

public class VowelStrings {

    //https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range/submissions/1179661196/
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');
    public int vowelStrings(String[] words, int left, int right) {
        int nb = 0;
        for (int i = left; i <= right; i++) {
            if(VOWELS.contains(words[i].charAt(0)) && VOWELS.contains(words[i].charAt(words[i].length() - 1))){
                nb++;
            }
        }
        return nb;
    }
}
