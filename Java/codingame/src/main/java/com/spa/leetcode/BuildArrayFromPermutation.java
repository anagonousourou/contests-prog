package com.spa.leetcode;

public class BuildArrayFromPermutation {

    //https://leetcode.com/problems/build-array-from-permutation/description/
    public int[] buildArray(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[nums[i]];
        }
        return result;
    }

    //Follow-up: Can you solve it without using an extra space (i.e., O(1) memory)?
}
