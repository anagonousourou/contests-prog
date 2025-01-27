package com.spa.leetcode.easy;

public class ValidMountainArray {


    // https://leetcode.com/problems/valid-mountain-array/submissions/1444680238/
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int maxIndex = 0;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }

        if (maxIndex == 0 || maxIndex == arr.length - 1) {
            return false;
        }
        for (int i = maxIndex + 1; i < arr.length; i++) {
            if (arr[i - 1] <= arr[i]) {
                return false;
            }
        }

        for (int i = 1; i <= maxIndex; i++) {
            if (arr[i - 1] >= arr[i]) {
                return false;
            }
        }

        return true;
    }
}
