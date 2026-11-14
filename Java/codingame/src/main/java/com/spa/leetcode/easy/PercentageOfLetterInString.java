package com.spa.leetcode.easy;

public class PercentageOfLetterInString {
    //https://leetcode.com/problems/percentage-of-letter-in-string/submissions/1166701508/
    public int percentageLetter(String s, char letter) {
        return (int) Math.floor(((double) s.chars().filter(c -> c == (int) letter).count() / (double) s.length()) * 100);
    }
}
