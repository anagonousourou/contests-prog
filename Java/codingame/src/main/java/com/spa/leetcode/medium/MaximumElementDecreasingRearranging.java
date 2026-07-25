package com.spa.leetcode.medium;

import java.util.Arrays;

public class MaximumElementDecreasingRearranging {

    // https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/submissions/2048927216/?envType=daily-question&envId=2026-06-28
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);

        int[] target = new int[arr.length];
        target[0] = 1;
        for (int j = 1; j < arr.length; j++) {
            if( arr[j] == target[j - 1] || arr[j] == target[j - 1] + 1 ){
                target[j] = arr[j];
            }else{
                target[j] = target[j - 1] + 1;
            }
        }

        return target[arr.length - 1];
    }
}
