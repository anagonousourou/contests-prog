package com.spa.leetcode.easy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountLargestGroup {

    // https://leetcode.com/problems/count-largest-group/submissions/1615425161/?envType=daily-question&envId=2025-04-23
    public int countLargestGroup(int n) {

        var groups = IntStream.rangeClosed(1, n).boxed()
            .collect(Collectors.groupingBy(i -> String.valueOf(i).chars().map(Character::getNumericValue)
                .sum()));

        var largestSize = groups.values().stream().map(List::size).max(Integer::compareTo).orElseThrow();

        return (int)groups.entrySet().stream().filter(entry -> entry.getValue().size() == largestSize)
            .count();
    }
}
