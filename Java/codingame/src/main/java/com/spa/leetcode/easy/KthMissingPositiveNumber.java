package com.spa.leetcode.easy;

public class KthMissingPositiveNumber {

    // https://leetcode.com/problems/kth-missing-positive-number/submissions/1439842428/
    public int findKthPositive(int[] arr, int k) {
        int[] ints = new int[1001 + k + 1];
        for (var num : arr) {
            ints[num] = -1;
        }

        int missing = 0;
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] == 0) {
                missing++;
            }
            if (missing == k) {
                return i;
            }
        }

        return -1;
    }

}
