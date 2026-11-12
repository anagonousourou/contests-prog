package com.spa.leetcode.medium;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {

    // https://leetcode.com/problems/max-number-of-k-sum-pairs/submissions/2194552431/?envType=study-plan-v2&envId=leetcode-75
    public int maxOperations(int[] nums, int k) {

        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int count = 0;
        while (i < j) {
            if (nums[i] + nums[j] == k) {
                i++;
                j--;
                count++;
            } else if (nums[i] + nums[j] < k) {
                i++;
            } else {
                j--;
            }
        }

        return count;
    }
}
