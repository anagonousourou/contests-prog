package com.spa.leetcode.easy;

import java.util.List;

public class MinimumSumSubarray {

    // https://leetcode.com/problems/minimum-positive-sum-subarray/submissions/2195844380/?envType=daily-question&envId=2026-11-14
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int[] prefixSum = new int[nums.size()];

        prefixSum[0] = nums.getFirst();
        for (int i = 1; i < nums.size(); i++) {
            prefixSum[i] = prefixSum[i - 1] + nums.get(i);
        }

        int min = -1;
        for (int i = l; i <= r; i++) {
            for (int j = 0; j <= prefixSum.length - i; j++) {
                int sumrange = prefixSum[j + i - 1] - (j > 0 ? prefixSum[j - 1] : 0);
                if (sumrange > 0) {
                    min = Math.min(min == -1 ? sumrange : min, sumrange);
                }
            }
        }
        return min;
    }
}
