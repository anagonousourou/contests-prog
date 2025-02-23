package com.spa.leetcode.easy;

public class MaxAdjacentDistance {

    // https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/submissions/1549718640/
    public int maxAdjacentDistance(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(Math.abs(nums[i] - nums[i + 1]), max);
        }
        return Math.max(Math.abs(nums[0] - nums[nums.length - 1]), max);
    }
}
