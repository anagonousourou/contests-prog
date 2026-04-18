package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class FindFinalValue {

    // https://leetcode.com/problems/keep-multiplying-found-values-by-two/submissions/1834532386/?envType=daily-question&envId=2025-11-19
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        while (numsSet.contains(original)) {
            original = 2 * original;
        }
        return original;
    }
}
