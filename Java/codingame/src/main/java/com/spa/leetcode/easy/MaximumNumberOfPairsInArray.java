package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaximumNumberOfPairsInArray {

    //https://leetcode.com/problems/maximum-number-of-pairs-in-array/submissions/1168641043/
    public int[] numberOfPairs(int[] nums) {
        int[] result = new int[2];
        var frequencies = Arrays.stream(nums).boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (var entry : frequencies.entrySet()) {
            result[0] += entry.getValue() / 2;
            result[1] += entry.getValue() % 2;
        }
        return result;
    }
}
