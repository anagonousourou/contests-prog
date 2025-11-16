package com.spa.leetcode.easy;

import java.util.Arrays;

public class ApplyOperations {

    // https://leetcode.com/problems/apply-operations-to-an-array/submissions/1558998337/?envType=daily-question&envId=2025-03-01
    public int[] applyOperations(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
        return nums;
    }
}
