package com.spa.leetcode.easy;

public class UnequalTriplets {

    // https://leetcode.com/problems/number-of-unequal-triplets-in-array/submissions/1425275490/
    public int unequalTriplets(int[] nums) {
        int nb = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] != nums[j] && nums[j] != nums[k] && nums[i] != nums[k]) {
                        nb++;
                    }
                }
            }
        }

        return nb;
    }
}
