package com.spa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SortVowelsInAString {

    public String sortVowels(String s) {
        char[] originalchars = s.toCharArray();
        List<Character> vowels = new ArrayList<>();

        for (char c : originalchars) {
            if (ReverseVowels.VOWELS.contains(Character.toLowerCase(c))) {
                vowels.add(c);
            }
        }

        vowels.sort(Character::compareTo);

        int j = 0;
        for (int i = 0; i < originalchars.length; i++) {
            if (ReverseVowels.VOWELS.contains(Character.toLowerCase(originalchars[i]))) {
                originalchars[i] = vowels.get(j);
                j++;
            }
        }
        return new String(originalchars);
    }
}
