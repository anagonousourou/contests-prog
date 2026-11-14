package com.spa.leetcode.easy;

import java.util.Arrays;

public class MinimumOperationsToMakeArraySumDivisibleByK {

    // https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k/submissions/1842411447/

    public int minOperations(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();

        for (int i = 0; i <= sum; i++) {
            if((sum - i) % k  == 0){
                return i;
            }
        }
        return 0;
    }
}
