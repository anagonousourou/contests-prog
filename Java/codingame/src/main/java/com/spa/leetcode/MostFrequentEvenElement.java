package com.spa.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostFrequentEvenElement {

    //https://leetcode.com/problems/most-frequent-even-element/description/
    public int mostFrequentEven(int[] nums) {
        return Arrays.stream(nums).filter(i -> i % 2 == 0).boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream().max(Comparator.<Map.Entry<Integer, Long>>comparingLong(Map.Entry::getValue).thenComparing(entry -> -entry.getKey()))
            .map(Map.Entry::getKey).orElse(-1);
    }
}
