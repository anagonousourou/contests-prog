package com.spa.leetcode;

public class BinarySubarraysWithSum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] prefixSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i] = nums[i] + (i - 1 >= 0 ? prefixSum[i - 1] : 0);
        }
        int count = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = 0; j < prefixSum.length; j++) {
                if(prefixSum[j] - prefixSum[i] == goal){
                    count++;
                }
            }
        }

        return count;
    }
}
