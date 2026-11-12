package com.spa.leetcode.easy;

//https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
public class StringArrayEquivalent {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("", word2).equals(String.join("", word1));
    }
}
