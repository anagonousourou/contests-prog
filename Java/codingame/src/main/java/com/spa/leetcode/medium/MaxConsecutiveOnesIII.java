package com.spa.leetcode.medium;

public class MaxConsecutiveOnesIII {

    // https://leetcode.com/problems/max-consecutive-ones-iii/description/?envType=study-plan-v2&envId=leetcode-75
    public int longestOnes(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int forward = 0;
        int backward = nums.length - 1;


        int result = 0;
        while (forward < backward) {
            int nbOnes = prefixSum[backward] - ((forward - 1) >= 0 ? prefixSum[forward - 1] : 0);
            if (backward - forward + 1 - nbOnes <= k) {
                result = Math.max(backward - forward + 1, result);
            }

            if (prefixSum[backward - 1] == prefixSum[backward]) {
                backward--;
            } else {
                forward++;
            }
        }
        return result;
    }
}
