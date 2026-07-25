package com.spa.leetcode.easy;

public class ValidPalindromeII {


    public boolean validPalindrome(String s) {

        return validPalindrome(s, s);
    }


    private boolean validPalindrome(String s, String originalString) {
        if (s.length() == 1) {
            return true;
        }

        int mid = s.length() / 2;

        String part1 = s.substring(0, mid);
        String part2 = s.length() % 2 == 0 ? s.substring(mid) : s.substring(mid + 1);
        int diff = Math.abs(s.length() - originalString.length());
        int diffIndex = -1;
        for (int i = 0; i < part2.length(); i++) {
            if (part2.charAt(i) != part1.charAt(part1.length() - 1 - i)) {
                diff++;
                if (diff == 1) {
                    diffIndex = i;
                }
            }

        }
        if (diff == 0) {
            return true;
        }
        if (s.length() % 2 == 0) {
            return diff <= 1;
        }
        if (s.length() % 2 == 1 && diff == 1) {
            return validPalindrome(s.substring(0, diffIndex) + s.substring(diffIndex + 1), s);
        }
        return false;
    }
}
