package com.spa.leetcode.easy;

import java.util.Arrays;

//https://leetcode.com/problems/missing-number
public class MissingNumber {

    // https://leetcode.com/problems/missing-number/submissions/1180849273/

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedTotal = ((n + 1) * n) / 2;
        return expectedTotal - Arrays.stream(nums).sum();
    }
}
