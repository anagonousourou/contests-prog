package com.spa.leetcode;

import java.util.Arrays;

public class FindIntersectionValues {

    //https://leetcode.com/problems/find-common-elements-between-two-arrays/
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        return new int[]{
            (int) Arrays.stream(nums1).filter(n -> Arrays.stream(nums2).anyMatch(m -> n == m))
                .count(),
            (int) Arrays.stream(nums2).filter(n -> Arrays.stream(nums1).anyMatch(m -> n == m))
                .count()
        };
    }
}
