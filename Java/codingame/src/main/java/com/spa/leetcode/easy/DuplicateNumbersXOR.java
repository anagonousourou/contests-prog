package com.spa.leetcode.easy;

import java.util.Arrays;

public class DuplicateNumbersXOR {

    // https://leetcode.com/problems/find-the-xor-of-numbers-which-appear-twice/submissions/1476102269/
    public int duplicateNumbersXOR(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                res ^= nums[i];
            }
        }
        return res;
    }
}
