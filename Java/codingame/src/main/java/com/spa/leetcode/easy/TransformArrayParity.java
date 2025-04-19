package com.spa.leetcode.easy;

import java.util.Arrays;

public class TransformArrayParity {

    // https://leetcode.com/problems/transform-array-by-parity/submissions/1587936471/
    public int[] transformArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % 2 == 0 ? 0 : 1;
        }

        Arrays.sort(nums);
        return nums;
    }
}
