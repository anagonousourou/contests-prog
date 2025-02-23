package com.spa.leetcode;

import java.util.Arrays;

public class SumOddLengthSubarrays {

    //https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
    public int sumOddLengthSubarrays(int[] arr) {
        int[] prefix = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            prefix[i] = arr[i] +(i - 1 >= 0 ? prefix[i - 1]: 0);
        }

        int sum = Arrays.stream(arr).sum();
        for (int i = 3; i <= arr.length; i += 2) {
            for (int j = 0; j < arr.length; j++) {
                if(j - i == -1){
                    sum += prefix[j];
                }
                else if(j - i >= 0){
                    sum += prefix[j] - prefix[j - i];
                }
            }
        }
        return sum;
    }

    static class Solution {
        public int sumOddLengthSubarrays(int[] arr) {
            int n = arr.length;
            int sum = 0;
            for (int i=0; i<n; i++) {
                sum = sum + ((i+1)*(n-i)+1)/2*arr[i];
            }
            return sum;
        }
    }
}
