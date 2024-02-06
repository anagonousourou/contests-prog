package com.spa.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequent {

    //https://leetcode.com/problems/top-k-frequent-elements/
    public int[] topKFrequent(int[] nums, int k) {
        return Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream().sorted(Comparator.<Map.Entry<Integer, Long>>comparingLong(Map.Entry::getValue).reversed())
            .limit(k).mapToInt(Map.Entry::getKey).toArray();
    }
}
