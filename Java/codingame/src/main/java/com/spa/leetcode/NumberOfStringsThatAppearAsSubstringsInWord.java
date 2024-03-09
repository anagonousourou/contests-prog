package com.spa.leetcode;

import java.util.Arrays;


//https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/
public class NumberOfStringsThatAppearAsSubstringsInWord {
    public int numOfStrings(String[] patterns, String word) {
        return (int) Arrays.stream(patterns).filter(word::contains).count();
    }
}
