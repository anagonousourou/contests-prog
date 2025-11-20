package com.spa.leetcode.easy;

import java.util.Arrays;

public class MaxProduct {

    // TODO https://leetcode.com/problems/maximum-product-of-three-numbers/description/
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
    }
}
