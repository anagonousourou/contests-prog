package com.spa.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class DistinctDifferenceArray {

    // https://leetcode.com/problems/find-the-distinct-difference-array/submissions/1557178486/
    public int[] distinctDifferenceArray(int[] nums) {
        int[] prefix = new int[nums.length];

        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            seen.add(nums[i]);
            prefix[i] = seen.size();
        }

        int[] suffix = new int[nums.length];

        Set<Integer> seenSuffix = new HashSet<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            seenSuffix.add(nums[i]);
            suffix[i] = seenSuffix.size();
        }

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length - 1; i++) {
            result[i] = prefix[i] - suffix[i + 1];
        }
        result[nums.length - 1] = prefix[nums.length - 1];
        return result;
    }
}
