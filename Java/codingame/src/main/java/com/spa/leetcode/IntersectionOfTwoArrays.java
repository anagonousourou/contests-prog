package com.spa.leetcode;

import java.util.Arrays;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        return Arrays.stream(nums1).filter(n -> Arrays.stream(nums2).anyMatch(n2 -> n2 == n)).distinct().toArray();
    }
}
