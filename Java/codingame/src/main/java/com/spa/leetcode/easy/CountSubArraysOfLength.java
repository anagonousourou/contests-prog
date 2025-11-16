package com.spa.leetcode.easy;

public class CountSubArraysOfLength {

    // https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition/submissions/1619050507/?envType=daily-question&envId=2025-04-27
    public int countSubarrays(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if((nums[i] + nums[i + 2]) * 2 == nums[i + 1]){
                count++;
            }
        }
        return count;
    }
}
