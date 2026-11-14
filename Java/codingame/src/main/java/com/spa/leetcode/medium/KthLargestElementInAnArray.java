package com.spa.leetcode.medium;

import java.util.Arrays;

public class KthLargestElementInAnArray {

    //https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/1168682496/description/
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
