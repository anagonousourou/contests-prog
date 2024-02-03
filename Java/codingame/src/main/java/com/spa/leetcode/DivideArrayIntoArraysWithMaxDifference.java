package com.spa.leetcode;

import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDifference {

    //https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        while (i <= nums.length && i + 2 <= nums.length) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][0];
            }
            i = i + 3;
        }

        int[][] result = new int[nums.length / 3][3];

        for (int j = 0; j < nums.length / 3; j++) {
            System.arraycopy(nums, j * 3, result[j], 0, 3);
        }
        return result;
    }
}
