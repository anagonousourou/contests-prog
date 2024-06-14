package com.spa.leetcode;

import java.util.Arrays;

public class ArrayPartition {

    //https://leetcode.com/problems/array-partition/submissions/1204264607/
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }
}
