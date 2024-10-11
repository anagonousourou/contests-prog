package com.spa.leetcode;

import java.util.Arrays;

public class MinimumAverage {

    // https://leetcode.com/problems/minimum-average-of-smallest-and-largest-elements/submissions/1418850398/
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double result = Double.MAX_VALUE;
        for (int i = 0; i < nums.length / 2; i++) {
            result = Math.min(((double) nums[i] + nums[nums.length - 1 - i]) / 2.0, result);
        }
        return result;
    }
}
