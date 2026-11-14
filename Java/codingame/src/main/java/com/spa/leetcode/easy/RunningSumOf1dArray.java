package com.spa.leetcode.easy;

public class RunningSumOf1dArray {

    // https://leetcode.com/problems/running-sum-of-1d-array/submissions/828825939/

     public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        runningSum[0] = nums[0];
        for (int index = 1; index < nums.length; index++) {
            runningSum[index] =  nums[index]+runningSum[index-1];
        }
        return runningSum;
    }
}
