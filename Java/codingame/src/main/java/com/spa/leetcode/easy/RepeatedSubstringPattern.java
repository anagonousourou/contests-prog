package com.spa.leetcode.easy;

public class RepeatedSubstringPattern {

    //https://leetcode.com/problems/repeated-substring-pattern/submissions/1171395294/
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.length() % i == 0 && s.substring(0, i).repeat(s.length() / i).equals(s)) {
                return true;
            }
        }
        return false;
    }
}
