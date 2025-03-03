package com.spa.leetcode.easy;

import java.util.Arrays;

public class FormSmallestNumber {


    // https://leetcode.com/problems/form-smallest-number-from-two-digit-arrays/submissions/1550583054/
    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int k : nums1) {
            for (int i : nums2) {
                if (k == i) {
                    return k;
                }
            }
        }
        if (nums1[0] < nums2[0]) {
            return nums1[0] * 10 + nums2[0];
        } else {
            return nums2[0] * 10 + nums1[0];
        }
    }
}
