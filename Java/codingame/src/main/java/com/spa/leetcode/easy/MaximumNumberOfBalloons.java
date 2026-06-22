package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class MaximumNumberOfBalloons {

    // https://leetcode.com/problems/maximum-number-of-balloons/submissions/2042087152/?envType=daily-question&envId=2026-06-22
    public int maxNumberOfBalloons(String text) {
        Map<String, Long> occurrences = Arrays.stream(text.split(""))
            .filter("balloon"::contains)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long aocc =  occurrences.getOrDefault("a", 0L);
        long bocc =  occurrences.getOrDefault("b", 0L);
        long locc =  occurrences.getOrDefault("l", 0L);
        long oocc =  occurrences.getOrDefault("o", 0L);
        long nocc =  occurrences.getOrDefault("n", 0L);

        long nbBallon = LongStream.of(aocc, bocc, locc / 2, oocc / 2, nocc).min().orElseThrow();

        return (int) nbBallon;
    }
}
