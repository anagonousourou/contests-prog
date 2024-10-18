package com.spa.leetcode.easy;

import java.util.Arrays;

public class MinimumOperations {

    // https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/submissions/1424509776/
    public int minimumOperations(int[] nums) {
        return Arrays.stream(nums).map(i -> i % 3 == 0 ? 0 : 1).sum();
    }
}
