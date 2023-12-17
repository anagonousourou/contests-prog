package com.spa.leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        var uniqs = Arrays.stream(nums).distinct().toArray();
        System.arraycopy(uniqs, 0, nums, 0, uniqs.length);
        return uniqs.length;
    }
}
