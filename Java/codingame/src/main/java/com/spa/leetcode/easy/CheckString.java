package com.spa.leetcode.easy;

public class CheckString {

    //https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/submissions/1163895089/
    public boolean checkString(String s) {
        boolean seenB = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                seenB = true;
            } else if (seenB && s.charAt(i) == 'a') {
                return false;
            }
        }
        return true;
    }
}
