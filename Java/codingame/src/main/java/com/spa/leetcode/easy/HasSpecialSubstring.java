package com.spa.leetcode.easy;

public class HasSpecialSubstring {

    // https://leetcode.com/problems/find-special-substring-of-length-k/submissions/1803440830/
    public boolean hasSpecialSubstring(String s, int k) {
        String[] chars = s.split("");
        String previous = "";
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (previous.equals(chars[i])) {
                count++;
            } else {
                count = 1;
                previous = chars[i];
            }
            if ((i + 1 == chars.length || !chars[i + 1].equals(chars[i])) && count == k) {
                return true;
            }
        }

        return false;
    }
}
