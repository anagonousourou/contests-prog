package com.spa.leetcode.medium;

public class MinimumRotatedSortedArray {

    // https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/2010151413/?envType=daily-question&envId=2026-05-15
    public int findMin(int[] nums) {
        if(nums[0] < nums[nums.length - 1]){
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;

        int middle = (left + right) / 2;
        while (true){
            if(Math.abs(right - left) <= 1){
                return Math.min(nums[right], nums[left]);
            }
            if(nums[middle] > nums[right]){
                left = middle;
                middle = (left + right) / 2;
            }else if(nums[middle] < nums[right]){
                right = middle;
                middle = (left + right) / 2;
            }
            else{
                return nums[middle];
            }
        }
    }
}
