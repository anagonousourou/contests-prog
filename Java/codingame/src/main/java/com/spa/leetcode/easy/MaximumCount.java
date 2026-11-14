package com.spa.leetcode.easy;

import java.util.Arrays;

public class MaximumCount {

    //https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/submissions/1571209404/
    public int maximumCount(int[] nums) {
        int pos = (int) Arrays.stream(nums).filter(p -> p > 0).count();
        int neg = (int) Arrays.stream(nums).filter(p -> p < 0).count();

        return Math.max(pos, neg);
    }
}
