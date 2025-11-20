package com.spa.leetcode.easy;

public class SortArrayParityII {


    // https://leetcode.com/problems/sort-array-by-parity-ii/submissions/1618196521/
    public int[] sortArrayByParityII(int[] nums) {
        int[] result = new int[nums.length];

        int odd = 1;
        int even = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] % 2 == 1) {
                result[odd] = nums[i];
                odd += 2;
            } else {
                result[even] = nums[i];
                even += 2;
            }
            i++;
        }

        return result;
    }
}
