package com.spa.leetcode.easy;

import java.util.Arrays;

public class IntersectionOfTwoArrays {

    // https://leetcode.com/problems/intersection-of-two-arrays/submissions/1199362950/

    public int[] intersection(int[] nums1, int[] nums2) {
        return Arrays.stream(nums1).filter(n -> Arrays.stream(nums2).anyMatch(n2 -> n2 == n)).distinct().toArray();
    }
}
