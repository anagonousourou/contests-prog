package com.spa.leetcode.easy;

import java.util.Arrays;

public class MaxProduct {

    // https://leetcode.com/problems/maximum-product-of-three-numbers/submissions/2081988657/?envType=daily-question&envId=2026-07-26
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int[] negativeNums = Arrays.stream(nums).filter(x -> x < 0).sorted().toArray();
        int[] posNums = Arrays.stream(nums).filter(x -> x >= 0).sorted().toArray();


        if(negativeNums.length >= 2 && posNums.length > 0) {
            int i = negativeNums[0] * negativeNums[1] * posNums[posNums.length - 1];
            if(posNums.length >= 3){
                int j = posNums[posNums.length - 1] * posNums[posNums.length - 2] * posNums[posNums.length - 3];
                return Math.max(i, j);
            }

            return i;
        }
        return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
    }
}
