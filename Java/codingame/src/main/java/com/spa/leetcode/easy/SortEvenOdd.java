package com.spa.leetcode.easy;

public class SortEvenOdd {

    // https://leetcode.com/problems/sort-even-and-odd-indices-independently/submissions/1474236388/
    public int[] sortEvenOdd(int[] nums) {

        //sort even
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (i % 2 == 0 && j % 2 == 0 && nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = tmp;
            }
        }


        // sort odd
        for (int i = 0; i < nums.length; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (i % 2 == 1 && j % 2 == 1 && nums[j] > nums[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int tmp = nums[i];
                nums[i] = nums[maxIndex];
                nums[maxIndex] = tmp;
            }
        }


        return nums;
    }

}
