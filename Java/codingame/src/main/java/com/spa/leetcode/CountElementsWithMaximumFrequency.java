package com.spa.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountElementsWithMaximumFrequency {

    //https://leetcode.com/problems/count-elements-with-maximum-frequency/?envType=daily-question&envId=2024-03-08
    public int maxFrequencyElements(int[] nums) {
        var occurences = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long maxFrequency = occurences.values().stream().mapToLong(Long::longValue).max().getAsLong();
        return (int) ((int) occurences.entrySet().stream().filter(occ -> occ.getValue() == maxFrequency).count() * maxFrequency);
    }
}
