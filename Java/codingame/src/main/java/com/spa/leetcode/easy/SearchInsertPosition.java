package com.spa.leetcode.easy;

import java.util.Arrays;

//https://leetcode.com/problems/search-insert-position
public class SearchInsertPosition {

    // https://leetcode.com/problems/search-insert-position/submissions/1121189463/

    public int searchInsert(int[] nums, int target) {
        var result = Arrays.binarySearch(nums, target);
        if (result < 0) {
            return Math.abs(result) - 1;
        }
        return result;
    }
}
