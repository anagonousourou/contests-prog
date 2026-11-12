package com.spa.leetcode.easy;

public class IsSubsequence {

    // https://leetcode.com/problems/is-subsequence/submissions/1122543350/?envType=study-plan-v2&envId=leetcode-75
    public boolean isSubsequence(String s, String t) {
        if (t.isEmpty() && !s.isEmpty()) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        if (s.substring(0, 1).equals(t.substring(0, 1))) {
            return isSubsequence(s.substring(1), t.substring(1));
        }
        if (!s.substring(0, 1).equals(t.substring(0, 1))) {
            return isSubsequence(s, t.substring(1));
        }

        return false;
    }
}
