package com.spa.leetcode.easy;

public class CheckAlmostEquivalent {

    // https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent/submissions/1444627191/
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            freq1[word1.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < word2.length(); i++) {
            freq2[word2.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < freq1.length; i++) {
            if (Math.abs(freq1[i] - freq2[i]) > 3) {
                return false;
            }
        }
        return true;
    }
}
