package com.spa.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/reverse-vowels-of-a-string/
public class ReverseVowels {

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public String reverseVowels(String s) {
        List<Character> vowels = new ArrayList<>(s.length());

        for (int i = s.length() - 1; i >= 0; i--) {
            if (VOWELS.contains(Character.toLowerCase(s.charAt(i)))) {
                vowels.add(s.charAt(i));
            }
        }

        StringBuilder result = new StringBuilder();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (VOWELS.contains(Character.toLowerCase(s.charAt(i)))) {
                result.append(vowels.get(j));
                j++;
            } else {
                result.append(s.charAt(i));
            }

        }
        return result.toString();
    }
}
