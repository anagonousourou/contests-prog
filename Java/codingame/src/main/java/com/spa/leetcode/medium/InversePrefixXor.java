package com.spa.leetcode.medium;

public class InversePrefixXor {
    //https://leetcode.com/problems/find-the-original-array-of-prefix-xor/submissions/1166828467/

    public int[] findArray(int[] pref) {
        int[] result = new int[pref.length];
        result[0] = pref[0];
        for (int i = 1; i < result.length; i++) {
            result[i] = pref[i - 1] ^ pref[i];
        }
        return result;
    }
}
