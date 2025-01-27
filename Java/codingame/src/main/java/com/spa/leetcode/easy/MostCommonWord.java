package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostCommonWord {


    // https://leetcode.com/problems/most-common-word/submissions/1477063233/
    public String mostCommonWord(String paragraph, String[] banned) {
        return Arrays.stream(paragraph.toLowerCase().split("\\s+|\\p{Punct}"))
            .filter(word -> !word.isBlank())
            .filter(word -> Arrays.stream(banned).noneMatch(ban -> ban.equals(word)))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .max(Comparator.comparingLong(Map.Entry::getValue))
            .orElseThrow().getKey();
    }
}
