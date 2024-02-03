package com.spa.leetcode;

import java.util.Arrays;

public class CheckIfArrayIsSortedAndRotated {

    //https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
    public boolean check(int[] nums) {
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        if (Arrays.equals(nums, sortedNums)) {
            return true;
        }
        for (int x = 0; x < nums.length; x++) {
            boolean found = true;
            for (int i = 0; i < nums.length; i++) {
                if (sortedNums[i] != nums[(i + x) % nums.length]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return true;
            }
        }
        return false;
    }
}
