package com.spa.leetcode;

public class LongestUncommonSubsequence {

    // https://leetcode.com/problems/longest-uncommon-subsequence-i/submissions/1415812349/
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        } else {
            return Math.max(a.length(), b.length());
        }
    }
}
