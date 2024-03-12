package com.spa.leetcode;

public class MaximumDifferenceBetweenIncreasingElements {

    //https://leetcode.com/problems/maximum-difference-between-increasing-elements/submissions/1199391880/
    public int maximumDifference(int[] nums) {

        int difference = -1;
        int currentMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int newDifference = nums[i] - currentMin;
            currentMin = Math.min(currentMin, nums[i]);
            difference = Math.max(difference, newDifference);
        }
        return difference <= 0 ? -1 : difference;
    }
}
