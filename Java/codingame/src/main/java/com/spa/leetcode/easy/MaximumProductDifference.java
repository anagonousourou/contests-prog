package com.spa.leetcode.easy;

import java.util.Arrays;

public class MaximumProductDifference {

    // https://leetcode.com/problems/maximum-product-difference-between-two-pairs/submissions/1122377092/

    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 2] * nums[nums.length - 1]) - (nums[0] * nums[1]);
    }
}
