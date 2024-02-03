package com.spa.leetcode;

import java.util.Arrays;

public class MinimumNumberGame {

    //https://leetcode.com/problems/minimum-number-game/
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int tmp;
        for (int i = 0; i + 1 < nums.length; i += 2) {
            tmp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = tmp;
        }
        return nums;
    }
}
