package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindMostFrequentVowelAndConsonant {

    private static final Set<String> VOWELS = Set.of("a", "e", "i", "o", "u");

    // https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/submissions/2142845888/
    public int maxFreqSum(String s) {
        var freqs = Arrays.stream(s.split(""))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return Math.toIntExact(freqs.entrySet().stream().filter(entry -> VOWELS.contains(entry.getKey()))
            .max(Map.Entry.comparingByValue()).map(Map.Entry::getValue).orElse(0L)
            +
            freqs.entrySet().stream().filter(entry -> !VOWELS.contains(entry.getKey()))
                .max(Map.Entry.comparingByValue()).map(Map.Entry::getValue).orElse(0L));

    }

}
