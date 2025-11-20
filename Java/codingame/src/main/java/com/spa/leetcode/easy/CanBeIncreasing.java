package com.spa.leetcode.easy;

import java.util.Arrays;

public class CanBeIncreasing {

    // https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/submissions/1805924079/

    public boolean canBeIncreasing(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean violation = false;
            for (int j = 0; j < nums.length; j++) {
                if(j == i){
                    continue;
                }

                int previous =  (j-1 == i) ? j -2  : j - 1;

                System.out.println("previous "+previous + " i = "+ "j = "+ j);
                if(previous >=0 && nums[previous] >= nums[j]){
                    violation = true;
                    break;
                }
            }
            if(!violation){
                return true;
            }
        }
        return false;
    }
}
