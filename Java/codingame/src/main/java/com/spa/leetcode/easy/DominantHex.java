package com.spa.leetcode.easy;

import java.util.Arrays;

public class DominantHex {


    // https://leetcode.com/problems/largest-number-at-least-twice-of-others/submissions/1585594848/
    public int dominantIndexV1(int[] nums) {
        int maxIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }

        int finalMaxIndex = maxIndex;
        return Arrays.stream(nums).allMatch(n -> nums[finalMaxIndex] >= 2 * n || nums[finalMaxIndex] == n) ? maxIndex : -1;
    }

    // https://leetcode.com/problems/largest-number-at-least-twice-of-others/submissions/1585606266/
    public int dominantIndex(int[] nums) {
        int maxIndex = nums[0] > nums[1] ? 0 : 1;
        int secondMaxIndex = nums[0] > nums[1] ? 1 : 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[maxIndex] < nums[i]) {
                secondMaxIndex = maxIndex;
                maxIndex = i;
            }
            if (nums[secondMaxIndex] < nums[i] && nums[i] < nums[maxIndex]) {
                secondMaxIndex = i;
            }
        }
        return nums[maxIndex] >= 2 * nums[secondMaxIndex] ? maxIndex : -1;
    }

}
