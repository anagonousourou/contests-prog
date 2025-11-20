package com.spa.leetcode.medium;

public class SpecialArrayII {

    // TODO https://leetcode.com/problems/special-array-ii/description/?envType=daily-question&envId=2024-12-09
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = isArraySpecial(nums, queries[i]);
        }
        return result;
    }

    private boolean isArraySpecial(int[] nums, int[] query) {
        for (int i = query[0]; i < query[1]; i++) {
            if (i + 1 < nums.length && nums[i] % 2 == nums[i + 1] % 2) {
                return false;
            }
        }
        return true;
    }

}
