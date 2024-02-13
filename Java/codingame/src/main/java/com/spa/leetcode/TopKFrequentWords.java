package com.spa.leetcode;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentWords {

    //https://leetcode.com/problems/top-k-frequent-words/
    public List<String> topKFrequent(String[] words, int k) {
        return Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream().sorted(Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue).reversed().thenComparing(Map.Entry::getKey)
            ).limit(k).map(Map.Entry::getKey).toList();
    }
}
