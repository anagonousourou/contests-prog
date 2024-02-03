package com.spa.leetcode;

public class IncreasingTripletSubsequence {

    //https://leetcode.com/problems/increasing-triplet-subsequence/
    /*
    // if there is a triplet of number x  < y < z with their respective indices being i < j < k
    // then we can represent visualize the array as this
    // [(1)..., x, ..., y, ..., z, (4)...]
    //since we are only interested in finding whether there is a triplet verifying the condition
    we can say that if there is z is the biggest rightmost number verifying the condition
    therefore in section (4) of the array there is no number bigger than z
    we use a similar reasoning for the section (1) => which means that in section (1) of
    the array there is no number smaller than x

    This prompt us to create two arrays : one for a prefix min and another for a suffix max.
    Once we have those arrays, we can iterate through the original array looking for a number nums[i]
    such that the prefix min at its left is less than it and the suffix max at its right is greater than it.
    */
    public boolean increasingTriplet(int[] nums) {
        int[] mins = new int[nums.length];
        int[] maxs = new int[nums.length];

        //prefix min
        mins[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            mins[i] = Math.min(nums[i], mins[i - 1]);
        }

        //suffix max
        maxs[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            maxs[i] = Math.max(maxs[i + 1], nums[i]);
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (mins[i - 1] < nums[i] && nums[i] < maxs[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
