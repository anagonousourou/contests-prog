package com.spa.leetcode.easy;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DigitFrequencyScore {

    // https://leetcode.com/problems/digit-frequency-score/submissions/2136025917/
    public int digitFrequencyScore(int n) {
        return String.valueOf(n).chars().map(Character::getNumericValue)
            .boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream().mapToInt(entry -> entry.getValue().intValue() * entry.getKey())
            .sum();
    }
}
