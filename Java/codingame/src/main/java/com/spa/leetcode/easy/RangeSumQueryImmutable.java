package com.spa.leetcode.easy;

public class RangeSumQueryImmutable {

    // https://leetcode.com/problems/range-sum-query-immutable/submissions/1643784809/
    class NumArray {
        private final int[] prefix;
        public NumArray(int[] nums) {
            this.prefix = new int[nums.length];
            this.prefix[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                prefix[i] = prefix[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return prefix[right] - (left == 0 ? 0 : prefix[left - 1]);
        }
    }
}
