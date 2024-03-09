package com.spa.leetcode;

public class LongestContinuousIncreasingSubsequence {

    //https://leetcode.com/problems/longest-continuous-increasing-subsequence/submissions/1197959890/
    public int findLengthOfLCIS(int[] nums) {
        int count = 1;
        int currentCount = 1;

        for (int i = 1; i < nums.length; i++) {
            if(nums[i - 1] < nums[i]){
                currentCount++;
                count = Math.max(currentCount, count);
            }else{
                currentCount = 1;
            }
        }
        return count;

    }
}
