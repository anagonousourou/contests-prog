package com.spa.leetcode;

public class ShuffleTheArray {

    //https://leetcode.com/problems/shuffle-the-array/
    public int[] shuffle(int[] nums, int n) {
        int[] result = nums.clone();
        int k = 0;
        for (int i = 0; i < n; i++) {
            result[k] = nums[i];
            result[k + 1] = nums[i + n];
            k += 2;
        }
        return result;
    }
}
