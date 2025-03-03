package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CountPairsSimilarString {

    // https://leetcode.com/problems/count-pairs-of-similar-strings/submissions/1560225402/
    public int similarPairs(String[] words) {
        return Arrays.stream(words)
            .collect(Collectors.groupingBy(word -> Arrays.stream(word.split("")).collect(Collectors.toSet())))
            .values()
            .stream()
            .mapToInt(list -> (list.size() * (list.size() - 1)) / 2).sum();
    }
}
