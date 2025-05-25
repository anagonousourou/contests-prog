package com.spa.leetcode.easy;

public class HasSameDigits {


    // https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/submissions/1588002890/
    public boolean hasSameDigits(String s) {
        while (s.length() > 2) {
            StringBuilder newS = new StringBuilder();
            for (int i = 0; i < s.length() - 1; i++) {
                newS.append((Character.getNumericValue(s.charAt(i)) + Character.getNumericValue(s.charAt(i + 1))) % 10);
            }
            s = newS.toString();
        }

        return s.charAt(0) == s.charAt(1);
    }
}
