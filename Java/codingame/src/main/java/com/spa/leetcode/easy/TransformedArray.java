package com.spa.leetcode.easy;

public class TransformedArray {


    // https://leetcode.com/problems/transformed-array/submissions/1585643468/
    public int[] constructTransformedArray(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else if (nums[i] < 0) {
                result[i] = nums[(i + 100 * nums.length - Math.abs(nums[i])) % nums.length];
            } else {
                result[i] = nums[(i + nums[i]) % nums.length];
            }
        }
        return result;
    }
}
