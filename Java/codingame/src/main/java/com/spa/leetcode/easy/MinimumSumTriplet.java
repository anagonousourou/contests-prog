package com.spa.leetcode.easy;

public class MinimumSumTriplet {


    // https://leetcode.com/problems/minimum-sum-of-mountain-triplets-i/submissions/1625131101/
    public int minimumSum(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if(nums[i] < nums[j] && nums[j] > nums[k]){
                        min = Math.min(min, nums[i] + nums[j] + nums[k]);
                    }
                }
            }
        }

        return min == Integer.MAX_VALUE ? - 1 : min;
    }
}
