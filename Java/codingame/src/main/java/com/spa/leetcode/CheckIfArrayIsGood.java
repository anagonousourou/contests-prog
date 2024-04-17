package com.spa.leetcode;

import java.util.Arrays;

public class CheckIfArrayIsGood {

    //https://leetcode.com/problems/check-if-array-is-good/submissions/1200357706/
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -1; i++) {
            if(nums[i] != i + 1){
                return false;
            }
        }
        return nums[nums.length - 1] == nums.length - 1;
    }
}
