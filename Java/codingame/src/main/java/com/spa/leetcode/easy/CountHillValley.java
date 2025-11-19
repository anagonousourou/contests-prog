package com.spa.leetcode.easy;

public class CountHillValley {

    // https://leetcode.com/problems/count-hills-and-valleys-in-an-array/submissions/1713531319/?envType=daily-question&envId=2025-07-27
    public int countHillValley(int[] nums) {

        int nbValleys = 0;
        int nbHills = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i - 1]) {
                int j = i - 1;
                while (j >= 0 && nums[j] == nums[i]) {
                    j--;
                }

                int k = i + 1;
                while (k < nums.length && nums[k] == nums[i]) {
                    k++;
                }

                if (k < nums.length && j >= 0 && nums[k] < nums[i] && nums[j] < nums[i]) {
                    nbHills++;
                }

                if (k < nums.length && j >= 0 && nums[k] > nums[i] && nums[j] > nums[i]) {
                    nbValleys++;
                }


            }
        }
        return nbHills + nbValleys;
    }
}
