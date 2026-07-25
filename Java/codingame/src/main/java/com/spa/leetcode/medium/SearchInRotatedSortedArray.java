package com.spa.leetcode.medium;

import java.util.Arrays;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if(nums[0] < nums[nums.length - 1]){
            int tmp = Arrays.binarySearch(nums, target);
            return tmp >= 0 ? tmp : -1;
        }
        int left = 0;
        int right = nums.length - 1;

        int middle = (left + right) / 2;
        while (true){
            if(nums[left] == target){
                return left;
            }
            if(nums[right] == target){
                return right;
            }
            if(Math.abs(right - left) <= 1 && nums[right] != target && nums[left] != target){
                return -1;
            }
            if(nums[left] < target && target < nums[middle]){
                right = middle;
                middle = (left + right) / 2;
            }
            else if(nums[middle] < target && target < nums[right]){
                left = middle;
                middle = (left + right) / 2;
            } else if (nums[middle] > target && target < nums[right]) {
                left = middle;
                middle = (left + right) / 2;
            }
            else if (nums[middle] > target && target > nums[right]) {
                return -1;
            }
            else if(nums[middle] == target){
                return middle;
            }
            else if(nums[middle + 1] == target) {
                return middle + 1;
            }
        }
    }
}
