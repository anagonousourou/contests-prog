package com.spa.leetcode.easy;

public class SmallerNumbersThanCurrent {

    // https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/submissions/1834565465/?envType=problem-list-v2&envId=dsa-linear-shoal-array-ii
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    res[i]++;
                }
            }
        }
        return res;
    }
}
