package com.spa.leetcode;

public class RepeatedSubstringPattern {

    //https://leetcode.com/problems/repeated-substring-pattern/
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i < s.length(); i++) {
            if(s.length() % i == 0 && s.substring(0, i).repeat( s.length() / i).equals(s)){
                return true;
            }
        }
        return false;
    }
}
