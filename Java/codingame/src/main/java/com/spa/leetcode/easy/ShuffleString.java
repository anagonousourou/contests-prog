package com.spa.leetcode.easy;

public class ShuffleString {

    // https://leetcode.com/problems/shuffle-string/
    public String restoreString(String s, int[] indices) {
        var result = new char[s.length()];

        for (int i = 0; i < indices.length; i++) {
            result[indices[i]] = s.charAt(i);
        }
        return new String(result);
    }
}
