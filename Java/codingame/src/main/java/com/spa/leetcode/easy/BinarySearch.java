package com.spa.leetcode.easy;

import java.util.Arrays;

public class BinarySearch {

    // https://leetcode.com/problems/binary-search/submissions/832843441/

    public int search(int[] nums, int target) {
        var index = Arrays.binarySearch(nums, target);
        if (index < 0) {
            return -1;
        }
        return index;
    }
}
