package com.spa.leetcode;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CustomSortString {

    //https://leetcode.com/problems/custom-sort-string/submissions/1200299257/?envType=daily-question&envId=2024-03-11
    public String customSortString(String order, String s) {
        Map<Character, Integer> lettersPosition = IntStream.range(0, order.length()).boxed().collect(Collectors.toMap(order::charAt, Function.identity()));

        return s.chars().mapToObj(c -> (char)c).sorted(Comparator.comparingInt(c -> lettersPosition.getOrDefault(c, lettersPosition.size()))).map(String::valueOf).collect(Collectors.joining());
    }
}
