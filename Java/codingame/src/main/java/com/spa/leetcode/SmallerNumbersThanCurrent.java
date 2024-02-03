package com.spa.leetcode;

import java.util.Arrays;

public class SmallerNumbersThanCurrent {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        return Arrays.stream(nums).map(n -> smallerThan(n, nums)).toArray();
    }

    private static int smallerThan(int n, int[] nums) {
        return (int) Arrays.stream(nums).filter(num -> num < n).count();
    }
}
