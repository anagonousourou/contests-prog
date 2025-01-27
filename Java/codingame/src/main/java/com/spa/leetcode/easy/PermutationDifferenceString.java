package com.spa.leetcode.easy;

public class PermutationDifferenceString {


    // https://leetcode.com/problems/permutation-difference-between-two-strings/submissions/1426202501/
    public int findPermutationDifference(String s, String t) {
        int[] positions = new int[26];

        for (int i = 0; i < s.length(); i++) {
            positions[s.charAt(i) - 'a'] = i;
        }

        int difference = 0;
        for (int i = 0; i < t.length(); i++) {
            difference += Math.abs(positions[t.charAt(i) - 'a'] - i);
        }

        return difference;
    }

}
