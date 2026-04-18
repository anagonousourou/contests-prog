package com.spa.leetcode.easy;

public class ConcatenationOfArray {

    // https://leetcode.com/problems/concatenation-of-array/submissions/1834535889/?envType=problem-list-v2&envId=dsa-linear-shoal-array-i
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        System.arraycopy(nums, 0, ans, 0, nums.length);
        System.arraycopy(nums, 0, ans, nums.length, nums.length);
        return ans;
    }
}
