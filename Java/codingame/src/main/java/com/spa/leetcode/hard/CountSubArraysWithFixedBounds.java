package com.spa.leetcode.hard;

public class CountSubArraysWithFixedBounds {

    // https://leetcode.com/problems/count-subarrays-with-fixed-bounds/submissions/1618188704/?envType=daily-question&envId=2025-04-26


    public long countSubarrays(int[] nums, int minK, int maxK) {
        // Variables to store the last positions of minK and maxK in the current segment
        int lastMin = -1, lastMax = -1;
        // Variable to track the start index of a valid subarray
        int start = 0;
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            // If current number is outside [minK, maxK], move the start to next position
            if (nums[i] < minK || nums[i] > maxK) {
                lastMin = -1;
                lastMax = -1;
                start = i + 1;
            } else {
                // Update positions of minK and maxK within the current segment
                if (nums[i] == minK) lastMin = i;
                if (nums[i] == maxK) lastMax = i;

                // If both minK and maxK are found in the current segment, count subarrays
                if (lastMin != -1 && lastMax != -1) {
                    // The number of subarrays ending at index i is determined by the minimum of the two positions plus one
                    count += Math.min(lastMin, lastMax) - start + 1;
                }
            }
        }

        return count;
    }

}
