package com.spa.leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/search-insert-position
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        var result = Arrays.binarySearch(nums, target);
        if (result < 0) {
            return Math.abs(result) - 1;
        }
        return result;
    }
}
