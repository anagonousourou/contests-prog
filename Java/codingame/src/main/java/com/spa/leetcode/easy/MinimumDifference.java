package com.spa.leetcode.easy;

import java.util.Arrays;

public class MinimumDifference {

    // https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/submissions/1585686430/
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i + k - 1 >= nums.length) {
                break;
            }
            minimum = Math.min(minimum, nums[i + k - 1] - nums[i]);
        }
        return minimum;
    }
}
