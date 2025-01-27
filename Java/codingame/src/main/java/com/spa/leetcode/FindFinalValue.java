package com.spa.leetcode;

public class FindFinalValue {


    public int findFinalValue(int[] nums, int original) {
        int finalValue = original;
        boolean originalExist = false;
        for (int num : nums) {
            if(original == num){
                originalExist = true;
            }
            if (num % original == 0 && isPowerOf2(num / original)) {
                finalValue = Math.max(finalValue, num);
            }
        }
        return originalExist ? finalValue * 2: original;
    }

    public static boolean isPowerOf2(int num) {
        if (num <= 0) {
            return false;
        }
        return (num & (num - 1)) == 0;
    }
}
