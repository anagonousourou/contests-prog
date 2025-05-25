package com.spa.leetcode.easy;

import java.util.Arrays;

public class MaxSumUnique {

    // https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/submissions/1586779612/
    public int maxSum(int[] nums) {
        var tmp = Arrays.stream(nums).filter(n -> n >= 0).distinct().toArray();
        if (tmp.length == 0) {
            return Arrays.stream(nums).max().orElseThrow();
        }
        return Arrays.stream(tmp).sum();
    }
}
