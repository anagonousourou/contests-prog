package com.spa.leetcode;

public class AreAlmostEqual {

    // https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/submissions/1418991763/
    public boolean areAlmostEqual(String s1, String s2) {
        int differences = 0;
        int firstIndex = -1;
        int secondIndex = -1;
        for (int i = 0; i < s2.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                differences++;
                if (firstIndex == -1) {
                    firstIndex = i;
                } else if (secondIndex == -1) {
                    secondIndex = i;
                }
            }
        }

        return differences == 0 ||
            (differences == 2 && s1.charAt(firstIndex) == s2.charAt(secondIndex) && s2.charAt(firstIndex) == s1.charAt(secondIndex));

    }
}
