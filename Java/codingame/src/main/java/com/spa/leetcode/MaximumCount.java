package com.spa.leetcode;

import java.util.Arrays;

public class MaximumCount {

    //https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/
    public int maximumCount(int[] nums) {
        int pos = (int) Arrays.stream(nums).filter(p -> p > 0).count();
        int neg = (int) Arrays.stream(nums).filter(p -> p < 0).count();

        return Math.max(pos, neg);
    }
}
