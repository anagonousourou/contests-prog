package com.spa.leetcode.easy;

import java.util.Arrays;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/1121180443/
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        var uniqs = Arrays.stream(nums).distinct().toArray();
        System.arraycopy(uniqs, 0, nums, 0, uniqs.length);
        return uniqs.length;
    }
}
