package com.spa.leetcode.medium;

public class MaximumTripletValueII {


    public long maximumTripletValue(int[] nums) {

        int a = nums[1] - nums[0], c = nums[2];

        return Math.max(0, a);
    }

}
