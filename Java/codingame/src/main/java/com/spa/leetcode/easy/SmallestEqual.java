package com.spa.leetcode.easy;

public class SmallestEqual {

    // https://leetcode.com/problems/smallest-index-with-equal-value/submissions/1623834793/
    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == (i % 10)){
                return i;
            }
        }
        return -1;
    }
}
