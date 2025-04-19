package com.spa.leetcode.easy;


public class SumGoodNumbers {

    // https://leetcode.com/problems/sum-of-good-numbers/submissions/1587023363/
    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(!(i + k < nums.length && nums[i] <= nums[i + k] || i - k >= 0 && nums[i] <= nums[i - k])){
                sum += nums[i];
            }
        }
        return sum;
    }

}
