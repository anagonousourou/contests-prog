package com.spa.leetcode;

public class MonotonicArray {

    //https://leetcode.com/problems/monotonic-array/submissions/1195659919/
    public boolean isMonotonic(int[] nums) {
        int sign = 0;
        for (int i = 0; i < nums.length -1; i++) {
            int newSign = nums[i + 1] - nums[i];
            if(sign * newSign < 0){
                return false;
            }
            if(sign == 0 && newSign != 0){
                sign = newSign;
            }
        }
        return true;
    }
}
