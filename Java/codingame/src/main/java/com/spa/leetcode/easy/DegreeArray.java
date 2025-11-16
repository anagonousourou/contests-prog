package com.spa.leetcode.easy;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DegreeArray {


    // https://leetcode.com/problems/degree-of-an-array/submissions/1588278746/
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Long> leftOccs = new HashMap<>();
        int degree = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .values().stream().max(Long::compareTo).orElseThrow().intValue();

        int minimumLength = nums.length;
        Map<Integer, Integer> firstIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            firstIndex.putIfAbsent(nums[i], i);
            if (leftOccs.compute(nums[i], (k, oldV) -> oldV == null ? 1 : oldV + 1) == degree) {
                minimumLength = Math.min(minimumLength, i - firstIndex.get(nums[i]) + 1);
            }
        }
        return minimumLength;
    }
}
