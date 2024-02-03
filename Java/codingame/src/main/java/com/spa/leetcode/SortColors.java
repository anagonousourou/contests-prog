package com.spa.leetcode;

import java.util.Arrays;

public class SortColors {


    //https://leetcode.com/problems/sort-colors/submissions/
    public void sortColors(int[] nums) {
        int[] colorsCount = new int[3];

        for (var n : nums) {
            colorsCount[n] += 1;
        }

        Arrays.fill(nums, 0, colorsCount[0], 0);
        Arrays.fill(nums, colorsCount[0], colorsCount[0] + colorsCount[1], 1);
        Arrays.fill(nums, colorsCount[0] + colorsCount[1], nums.length, 2);
    }
}
