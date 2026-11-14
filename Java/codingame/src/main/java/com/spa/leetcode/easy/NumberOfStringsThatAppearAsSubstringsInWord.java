package com.spa.leetcode.easy;

import java.util.Arrays;

//https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/submissions/2049945895/
public class NumberOfStringsThatAppearAsSubstringsInWord {
    public int numOfStrings(String[] patterns, String word) {
        return (int) Arrays.stream(patterns).filter(word::contains).count();
    }
}
