package com.spa.leetcode;

public class MaximumRepeatingSubstring {


    // https://leetcode.com/problems/maximum-repeating-substring/submissions/1415835006/
    public int maxRepeating(String sequence, String word) {
        int i = 0;
        while (sequence.contains(word.repeat(i + 1))) {
            i++;
        }
        return i;
    }
}
