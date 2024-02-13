package com.spa.leetcode;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberOfPairs {

    //https://leetcode.com/problems/maximum-number-of-pairs-in-array/
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
