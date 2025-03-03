package com.spa.leetcode.easy;

public class LongestMonotonicSubarray {


    // https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/submissions/1529614335/
    public int longestMonotonicSubarray(int[] nums) {
        int increasing = 1;
        int longestIncreasing = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i - 1] < nums[i]){
                increasing++;
                longestIncreasing = Math.max(increasing, longestIncreasing);
            }else{
                longestIncreasing = Math.max(increasing, longestIncreasing);
                increasing = 1;
            }

        }

        int decreasing = 1;
        int longestDecreasing = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i - 1] > nums[i]){
                decreasing++;
                longestDecreasing = Math.max(decreasing, longestDecreasing);
            }else{
                longestDecreasing = Math.max(decreasing, longestDecreasing);
                decreasing = 1;
            }
        }

        return Math.max(longestDecreasing, longestIncreasing);
    }
}
