package com.spa.leetcode;

import java.util.Arrays;

public class MaximumAverageSubarrayI {

    public static double findMaxAverage(int[] nums, int k) {

        double maxAverage = Double.MIN_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            double sum = 0.0;
            for (int j = i; j < i + k; j++) {
                sum = sum + nums[j];
            }
            maxAverage = Math.max(maxAverage, sum / k);
        }
        return maxAverage;
    }

    public static void main(String[] args) {
        System.out.println("Result = "+findMaxAverage(new int[]{1,2,3,4,5,6}, 3));
    }

    public double findMaxAverage2(int[] nums, int k) {

        if(k == 1){
           return Arrays.stream(nums).max().getAsInt();
        }
        if(k == nums.length){
            return Arrays.stream(nums).average().getAsDouble();
        }
        double maxAverage = Double.MIN_VALUE;
        int[] prefixSum = new int[nums.length];

        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = nums[i] + prefixSum[i-1];
        }

        for (int i = k; i < nums.length; i++) {
            double sum = (double) prefixSum[i] - prefixSum[i - k];
            maxAverage = Math.max(maxAverage, sum / k);
        }
        return maxAverage;
    }
}
