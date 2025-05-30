package com.spa.leetcode.easy;

public class CountGoodTriplets {


    // https://leetcode.com/problems/count-good-triplets/submissions/1606826763/?envType=daily-question&envId=2025-04-14
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if(Math.abs(arr[i] - arr[j]) <= a
                        && Math.abs(arr[j] - arr[k]) <= b
                            && Math.abs(arr[i] - arr[k]) <= c) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
