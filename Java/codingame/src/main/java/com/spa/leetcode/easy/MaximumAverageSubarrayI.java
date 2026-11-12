package com.spa.leetcode.easy;

import java.util.Arrays;

public class MaximumAverageSubarrayI {

    // https://leetcode.com/problems/maximum-average-subarray-i/submissions/2194709749/?envType=study-plan-v2&envId=leetcode-75
    public double findMaxAverage(int[] nums, int k) {

        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        Double maxAverage = null;
        for (int i = 0; i < nums.length - k + 1; i++) {
            double sum = prefixSum[i + k - 1] - ((i - 1) >= 0 ? prefixSum[i - 1] : 0);
            maxAverage = maxAverage == null ? sum / k : Math.max(maxAverage, sum / k);
        }
        return maxAverage == null ? 0 : maxAverage;
    }
}
