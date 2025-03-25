package com.spa.leetcode.easy;

public class SubsetXorSum {

    // https://leetcode.com/problems/sum-of-all-subset-xor-totals/submissions/1585570363/
    public int subsetXORSum(int[] nums) {
        return subsetXORSum(nums, 0, 0);
    }


    private int subsetXORSum(int[] nums, int i, int currentXor) {
        if (i == nums.length) {
            return currentXor;
        }

        return subsetXORSum(nums, i + 1, currentXor ^ nums[i]) + subsetXORSum(nums, i + 1, currentXor);
    }
}
