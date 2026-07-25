package com.spa.leetcode.medium;

public class HouseRobber {

    public int rob(int[] nums) {
        int set1 = 0;
        int set2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if(i % 2 == 0){
                set1 += nums[i];
            }else{
                set2 += nums[i];
            }
        }
        return Math.max(set1, set2);
    }
}
