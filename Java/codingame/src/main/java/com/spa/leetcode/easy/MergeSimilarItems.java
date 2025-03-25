package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeSimilarItems {

    // https://leetcode.com/problems/merge-similar-items/submissions/1554847878/
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        return Stream.concat(Arrays.stream(items1), Arrays.stream(items2))
            .collect(Collectors.toMap(item -> item[0], item -> item[1], Integer::sum))
            .entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .map(entry -> List.of(entry.getKey(), entry.getValue())).toList();
    }

}
