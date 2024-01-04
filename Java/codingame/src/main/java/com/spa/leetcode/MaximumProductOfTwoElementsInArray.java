package com.spa.leetcode;

import java.util.Arrays;

public class MaximumProductOfTwoElementsInArray {


    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }

    public int maxProduct2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] -= 1;
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    result = Math.max(result, nums[i] * nums[j]);
                }
            }
        }
        return result;
    }
}
