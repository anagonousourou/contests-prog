package com.spa.leetcode.easy;

public class MaxConsecutiveOnes {

    // https://leetcode.com/problems/max-consecutive-ones/submissions/1415646661/
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int current = 0;
        for (int num : nums) {
            if (num == 1) {
                current++;
            } else {
                res = Math.max(res, current);
                current = 0;
            }
        }
        return Math.max(res, current);
    }
}
