package com.spa.leetcode;

import java.util.Arrays;

public class SmallerNumbersThanCurrent {

    // https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/submissions/1834565465/

    public int[] smallerNumbersThanCurrent(int[] nums) {
        return Arrays.stream(nums).map(n -> smallerThan(n, nums)).toArray();
    }

    private static int smallerThan(int n, int[] nums) {
        return (int) Arrays.stream(nums).filter(num -> num < n).count();
    }
}
