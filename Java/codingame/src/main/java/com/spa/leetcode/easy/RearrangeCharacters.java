package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RearrangeCharacters {

    // https://leetcode.com/problems/rearrange-characters-to-make-target-string/submissions/2091195314/
    public int rearrangeCharacters(String s, String target) {
        Map<String, Long> targetOccs = Arrays.stream(target.split(""))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Long> sOccs = Arrays.stream(s.split(""))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int n = s.length();

        for (var entry : targetOccs.entrySet()){
            n = Math.toIntExact(Math.min(n, sOccs.getOrDefault(entry.getKey(), 0L) / entry.getValue()));
        }

        return n;
    }
}
