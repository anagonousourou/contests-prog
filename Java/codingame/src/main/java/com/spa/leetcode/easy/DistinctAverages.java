package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistinctAverages {

    // https://leetcode.com/problems/number-of-distinct-averages/submissions/1582255919/
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> average = new HashSet<>();

        for (int i = 0; i < nums.length / 2; i++) {
            average.add(nums[i] + nums[nums.length - 1 - i]);
        }
        return average.size();
    }
}
