package com.spa.leetcode;

public class PercentageOfLetterInString {
    //https://leetcode.com/problems/percentage-of-letter-in-string/
    public int percentageLetter(String s, char letter) {
        return (int) Math.floor(((double) s.chars().filter(c -> c == (int) letter).count() / (double) s.length()) * 100);
    }
}
