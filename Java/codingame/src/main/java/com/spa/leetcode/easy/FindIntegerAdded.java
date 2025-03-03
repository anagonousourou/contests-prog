package com.spa.leetcode.easy;

import java.util.Arrays;

public class FindIntegerAdded {

    // https://leetcode.com/problems/find-the-integer-added-to-array-i/submissions/1549712000/
    public int addedInteger(int[] nums1, int[] nums2) {
        return Arrays.stream(nums2).min().orElseThrow() - Arrays.stream(nums1).min().orElseThrow();
    }
}
