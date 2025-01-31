package com.spa.leetcode.medium;

import java.util.Arrays;

public class WaysToSplitArray {

    // https://leetcode.com/problems/number-of-ways-to-split-array/submissions/1526298309/?envType=daily-question&envId=2025-01-03
    public int waysToSplitArray(int[] nums) {

        long[] prefixSum = new long[nums.length];

        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int nbWays = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(prefixSum[i] >= prefixSum[prefixSum.length - 1] - prefixSum[i]){
                nbWays++;
            }
        }
        return nbWays;
    }

    // https://leetcode.com/problems/number-of-ways-to-split-array/submissions/1526303783/?envType=daily-question&envId=2025-01-03
    public int waysToSplitArray_alternative(int[] nums) {
        int nbWays = 0;
        long prefixSum = 0;

        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        //long totalSum = Arrays.stream(nums).asLongStream().sum();
        for (int i = 0; i < nums.length - 1; i++) {
            prefixSum += nums[i];
            if(prefixSum >= totalSum - prefixSum){
                nbWays++;
            }
        }
        return nbWays;
    }
}
