package com.spa.leetcode;

public class MinimumPushes {

    // https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/submissions/1415640308/
    public int minimumPushes(String word) {
        if (word.length() <= 8) {
            return word.length();
        } else if (word.length() <= 16) {
            return 8 + 2 * (word.length() - 8);
        } else if (word.length() <= 24) {
            return 8 + 2 * 8 + 3 * (word.length() - 16);
        } else {
            return 8 + 2 * 8 + 3 * 8 + 4 * (word.length() - 24);
        }
    }
}
