package com.spa.leetcode;

public class NeitherMinimumNorMaximum {


    //https://leetcode.com/problems/neither-minimum-nor-maximum/description/
    public int findNonMinOrMax(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        for (int num : nums) {
            if (num != max && num != min) {
                return num;
            }
        }
        return -1;
    }
}
