package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class FindClosestToZero {

    // https://leetcode.com/problems/find-closest-number-to-zero/submissions/1624220636/
    public int findClosestNumber(int[] nums) {
        return Arrays.stream(nums).boxed().min(Comparator.<Integer>comparingInt(Math::abs).thenComparing(i -> -i))
            .orElseThrow();
    }
}
